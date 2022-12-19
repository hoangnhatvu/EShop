package hcmute.vn.controller.admin.Product;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.lang.Math;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Product;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/products/update" })
public class ProductUpdateController extends HttpServlet {

	IProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// khai báo biến productId

			String productId = req.getParameter("id");

			// khởi tạo DAO

			// gọi hàm insert để thêm dữ liệu

			Product product = productService.findbyId(Integer.parseInt(productId));

			// thông báo

			req.setAttribute("action", "update");
			req.setAttribute("product", product);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/product/update.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			resp.setCharacterEncoding("UTF-8");

			// lấy dữ liệu từ jsp bằng BeanUtils

			Product product = new Product();

			BeanUtils.populate(product, req.getParameterMap());
			// tao gia tri slug random
			product.setSlug(String.valueOf(Math.random()));

			// Luu anh cu

			String oldImage = req.getParameter("listImage");

			// xử lý hình ảnh

			try {
				Part part = req.getPart("images");
				String realPath = req.getServletContext().getRealPath("/uploads");
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Paths.get(realPath))) {
					Files.createDirectory(Paths.get(realPath));
				}
				part.write(realPath + "/" + filename);
				String newImage = "/uploads/" + filename;
				System.out.println(newImage);
				product.setListImage(newImage);
			} catch (Exception e) {
				System.out.println(oldImage);
				product.setListImage(oldImage);
			}

			productService.update(product);

			// thông báoF

			req.setAttribute("product", product);

			req.setAttribute("message", "Cập nhật thành công!");

			req.getRequestDispatcher("/views/admin/product/list.jsp");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: Không thể cập nhật");

		}

		resp.sendRedirect(req.getContextPath() + "/admin/products/view");

	}

}

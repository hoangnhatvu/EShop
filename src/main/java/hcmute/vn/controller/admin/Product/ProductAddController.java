package hcmute.vn.controller.admin.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Product;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/products/add" })
public class ProductAddController extends HttpServlet {

	IProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();

		req.setAttribute("action", "add");
		req.setAttribute("product", product);

		req.getRequestDispatcher("/views/admin/product/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			req.setCharacterEncoding("UTF-8");

			req.setCharacterEncoding("UTF-8");

			// khỏi tạo đối tượng Model

			Product product = new Product();

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity

			BeanUtils.populate(product, req.getParameterMap());

			// xử lý hình ảnh

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

			productService.insert(product);

			// thông báo

			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		resp.sendRedirect(req.getContextPath() + "/admin/products/view");
	}
}

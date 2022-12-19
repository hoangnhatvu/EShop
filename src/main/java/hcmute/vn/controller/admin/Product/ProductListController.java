package hcmute.vn.controller.admin.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.entity.Product;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.impl.ProductServiceImpl;
@MultipartConfig

@WebServlet(urlPatterns = {"/admin/products/view"})
public class ProductListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Product> list = productService.findAll();

				//trả về giá trị cho view
			
			req.setAttribute("products", list);


		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: " + e.getMessage());
			

		}
		
		req.getRequestDispatcher("/views/admin/product/list.jsp").forward(req, resp);


	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}

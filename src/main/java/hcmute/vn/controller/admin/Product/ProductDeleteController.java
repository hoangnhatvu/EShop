package hcmute.vn.controller.admin.Product;

import java.io.IOException;

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

@WebServlet(urlPatterns = {"/admin/products/delete"})
public class ProductDeleteController extends HttpServlet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			// lấy dữ liệu trong jsp

			String productId = req.getParameter("id");

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			productService.delete(Integer.parseInt(productId));

			// thông báo

			req.setAttribute("message", "Đã xóa thành công");
						
			req.getRequestDispatcher("/views/admin/product/list.jsp").forward(req, resp);
			
			resp.sendRedirect(req.getContextPath() + "/admin/products/view");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}
		
				
	}
}

package hcmute.vn.controller.admin.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = {"/admin/users/view"})
public class UserListController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Users> list = userService.findAll();

				//trả về giá trị cho view
			
			req.setAttribute("users", list);
			
			


		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: " + e.getMessage());
			

		}
		
		req.getRequestDispatcher("/views/admin/user/list.jsp").forward(req, resp);		
		
	}
	
		
}

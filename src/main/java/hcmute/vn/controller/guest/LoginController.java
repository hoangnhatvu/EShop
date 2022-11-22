package hcmute.vn.controller.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.entity.Users;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.HashPassword;

@MultipartConfig

@WebServlet(urlPatterns = { "/login" })

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");	
			
			String email = request.getParameter("email");
			
			System.out.println(email);
			
			Users user = userService.findByEmail(email);	
			
			System.out.println(user.getHashedPassword());

			String password = request.getParameter("password");	
			
			System.out.println(password);

			
			HashPassword pw = new HashPassword();

			String hashPass = pw.hash(password);	
			
			System.out.println(hashPass);
				
			if(hashPass.equals(user.getHashedPassword())) {
				System.out.println("dfgdfgdfffffffffffffffffffffffffffffffffffffffffff");
				if(user.getRole() == 2) {
					response.sendRedirect(request.getContextPath() + "/vendor/home");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
package hcmute.vn.controller.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.vn.entity.Users;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.HashPassword;

@MultipartConfig

@WebServlet(urlPatterns = { "/login", "/logout" })

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("login")) {
			request.getRequestDispatcher("/views/user-template/bodyContent/login.jsp").forward(request, response);
		} else if (url.contains("logout")){
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(request.getContextPath());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");	
			
			String email = request.getParameter("email");
			
			Users user = userService.findByEmail(email);	
			if (user != null) {
				String password = request.getParameter("password");

				HashPassword pw = new HashPassword();

				String hashPass = pw.hash(password);

				if (hashPass.equals(user.getHashedPassword())) {

					if (user.getRole() == 2) {

						HttpSession session = request.getSession();

						session.setAttribute("ownerId", user.getId().toString());

						response.sendRedirect(request.getContextPath() + "/vendor/store/add");
					}
					if (user.getRole() == 1) {
						HttpSession session = request.getSession();
						session.setAttribute("userId", user.getId().toString());
						session.setAttribute("userName", user.getFirstName() + " " + user.getLastName());
						response.sendRedirect(request.getContextPath());
					}
				} else {
					request.setAttribute("msg", "Sai mật khâủ");
					request.getRequestDispatcher("/views/user-template/bodyContent/login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "Tài khoản không tồn tại");
				request.getRequestDispatcher("/views/user-template/bodyContent/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
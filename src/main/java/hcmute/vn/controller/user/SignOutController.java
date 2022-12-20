package hcmute.vn.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.UserServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/user/sign_out" })

public class SignOutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {	
		
		HttpSession session=request.getSession();
		
		session.setAttribute("ownerId",null);

		request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
	}
}
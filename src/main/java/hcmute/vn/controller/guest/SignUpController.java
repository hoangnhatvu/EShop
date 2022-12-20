package hcmute.vn.controller.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Users;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.HashPassword;
import hcmute.vn.util.StringUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/user/sign_up" })

public class SignUpController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		request.getRequestDispatcher("/views/user-template/bodyContent/sign_up.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");
			
			Users user = new Users();

			BeanUtils.populate(user, request.getParameterMap());			

			String password = request.getParameter("password");		
			
			HashPassword pw = new HashPassword();

			user.setHashedPassword(pw.hash(password));
			
			StringUtils remove = new StringUtils();
			
			String slug = remove.removeAccent(user.getFirstName()) + remove.removeAccent(user.getLastName()) + System.currentTimeMillis();
			
			user.setSlug(slug);		
			
			userService.createAccount(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
package hcmute.vn.controller.admin.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.HashPassword;
import hcmute.vn.util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/users/add" })
public class UserAddController extends HttpServlet {

	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users user = new Users();

		req.getRequestDispatcher("/views/admin/user/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			req.setCharacterEncoding("UTF-8");

			// khỏi tạo đối tượng Model

			Users user = new Users();

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity

			BeanUtils.populate(user, req.getParameterMap());

			String password = req.getParameter("hashedPassword");

			HashPassword pw = new HashPassword();

			user.setHashedPassword(pw.hash(password));
			
			

			// xử lý hình ảnh

			String fileName = String.valueOf(user.getId()) + System.currentTimeMillis();

			user.setAvatar(UploadUtils.processUpload("listImage", req, Constant.DIR + "\\category\\", fileName));

			// gọi hàm insert để thêm dữ liệu

			userService.insert(user);

			// thông báo

			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		resp.sendRedirect(req.getContextPath() + "/admin/users/view");
	}
}

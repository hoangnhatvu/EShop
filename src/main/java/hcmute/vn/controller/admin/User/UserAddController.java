package hcmute.vn.controller.admin.User;

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

		req.setAttribute("action", "add");
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

			// them role
			String role = req.getParameter("role");

			user.setRole(Integer.parseInt(role));

			user.setSlug(String.valueOf(Math.random()));

			String password = req.getParameter("hashedPassword");

			HashPassword pw = new HashPassword();

			user.setHashedPassword(pw.hash(password));

			String oldImage = req.getParameter("avatar");

			// xử lý hình ảnh

			try {
				Part part = req.getPart("avatarImage");
				String realPath = req.getServletContext().getRealPath("/uploads");
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Paths.get(realPath))) {
					Files.createDirectory(Paths.get(realPath));
				}
				part.write(realPath + "/" + filename);
				String newImage = "/uploads/" + filename;
				System.out.println(newImage);
				user.setAvatar(newImage);
			} catch (Exception e) {
				System.out.println(oldImage);
				user.setAvatar(oldImage);
			}
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

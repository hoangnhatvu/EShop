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

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/users/update" })
public class UserUpdateController extends HttpServlet {

	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// khai báo biến productId

			String userId = req.getParameter("id");

			// khởi tạo DAO

			// gọi hàm insert để thêm dữ liệu

			Users user = userService.findById(Integer.parseInt(userId));

			// thông báo

			req.setAttribute("action", "update");

			req.setAttribute("user", user);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/user/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			resp.setCharacterEncoding("UTF-8");

			// lấy dữ liệu từ jsp bằng BeanUtils

			Users user = new Users();

			BeanUtils.populate(user, req.getParameterMap());
			// tao gia tri slug random

			user.setSlug(String.valueOf(Math.random()));

			// them role
			String role = req.getParameter("role");

			user.setRole(Integer.parseInt(role));

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
			userService.update(user);

			// thông báoF

			req.setAttribute("user", user);

			req.setAttribute("message", "Cập nhật thành công!");

			req.getRequestDispatcher("/views/admin/users/list.jsp");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: Không thể cập nhật");

		}

		resp.sendRedirect(req.getContextPath() + "/admin/users/view");
	}

}

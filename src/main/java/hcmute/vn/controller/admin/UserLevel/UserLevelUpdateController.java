package hcmute.vn.controller.admin.UserLevel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.UserLevel;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IUserLevelService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.UserLevelServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/userlevels/update" })
public class UserLevelUpdateController extends HttpServlet {

	IUserLevelService userLevelService = new UserLevelServiceImpl();

	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khai báo biến productId

			String id = req.getParameter("id");

			// khởi tạo DAO

			// gọi hàm insert để thêm dữ liệu

			UserLevel userLevel = userLevelService.findById(Integer.parseInt(id));

			// thông báo

			req.setAttribute("userlevel", userLevel);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/userlevel/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			resp.setCharacterEncoding("UTF-8");

			// lấy dữ liệu từ jsp bằng BeanUtils

			UserLevel userLevel = new UserLevel();

			String id = req.getParameter("id");

			BeanUtils.populate(userLevel, req.getParameterMap());

			Users user = userService.findById(Integer.parseInt(id));

			userLevel.setId(Integer.parseInt(id));

			userLevel.setUsers(user);

			userLevelService.update(userLevel);

			// thông báoF

			// req.setAttribute("user", user);

			req.setAttribute("message", "Cập nhật thành công!");

			req.getRequestDispatcher("/views/admin/users/list.jsp");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: Không thể cập nhật");

		}

		resp.sendRedirect(req.getContextPath() + "/admin/userlevels/view");
	}

}

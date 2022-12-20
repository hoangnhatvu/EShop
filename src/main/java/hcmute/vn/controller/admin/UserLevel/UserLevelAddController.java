package hcmute.vn.controller.admin.UserLevel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Store;
import hcmute.vn.entity.StoreLevel;
import hcmute.vn.entity.UserLevel;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IUserLevelService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.UserLevelServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.HashPassword;
import hcmute.vn.util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/userlevels/add" })
public class UserLevelAddController extends HttpServlet {

	IUserLevelService userLevelService = new UserLevelServiceImpl();

	IUserService userService = new UserServiceImpl();

	private List<Users> FilterIdFromUsersTable(List<UserLevel> userLevels, List<Users> users) {

		List<Users> copyofUsers = users;

		copyofUsers.toArray();

		userLevels.toArray();

		try {

			for (int i = 0; i < copyofUsers.size(); i++) {

				for (int j = 0; j < userLevels.size(); j++) {
					if (userLevels.get(j).getId() == copyofUsers.get(i).getId())
						users.remove(i);
				}

			}

			return copyofUsers;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserLevel userLevel = new UserLevel();

		// lay tat ca danh sach userlevels va users
		List<UserLevel> userLevels = userLevelService.findAll();

		List<Users> users = userService.findAll();

		List<Users> list = FilterIdFromUsersTable(userLevels, users);

		// them bien list va userlevel vao view

		req.setAttribute("userlevel", userLevel);

		req.setAttribute("users", list);

		req.getRequestDispatcher("/views/admin/system/userlevel/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			req.setCharacterEncoding("UTF-8");
			
			String id = req.getParameter("idd");

			// khỏi tạo đối tượng Model

			UserLevel userLevel = new UserLevel();
			Users user = new Users();

			// sử dụng BeanUtils để tự lấy các name Field trên form
			
			
			// tên field phải trùng với entity

			BeanUtils.populate(userLevel, req.getParameterMap());

			// lay gia tri id va Users



			userLevel.setId(Integer.parseInt(id));

			user = userService.findById(Integer.parseInt(id));

			userLevel.setUsers(user);

			// gọi hàm insert để thêm dữ liệu

			userService.insert(user);

			// thông báo

			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		resp.sendRedirect(req.getContextPath() + "/admin/userlevels/view");
	}

}

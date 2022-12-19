package hcmute.vn.controller.admin.UserLevel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.dao.IUserLevelDao;
import hcmute.vn.entity.UserLevel;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IUserLevelService;
import hcmute.vn.service.impl.UserLevelServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/userlevels/view" })
public class UserLevelListController extends HttpServlet {

	IUserLevelService userLevelService = new UserLevelServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<UserLevel> list = userLevelService.findAll();

			// trả về giá trị cho view

			req.setAttribute("userlevels", list);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/userlevel/list.jsp").forward(req, resp);

	}
}

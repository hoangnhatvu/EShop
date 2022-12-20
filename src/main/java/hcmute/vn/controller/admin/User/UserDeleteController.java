package hcmute.vn.controller.admin.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.service.IProductService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/users/delete" })
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// lấy dữ liệu trong jsp

			String userId = req.getParameter("id");

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			userService.delete(Integer.parseInt(userId));

			// thông báo

			req.setAttribute("message", "Đã xóa thành công");

			req.getRequestDispatcher("/views/admin/user/list.jsp").forward(req, resp);

			resp.sendRedirect(req.getContextPath() + "/admin/users/view");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}
	}

}

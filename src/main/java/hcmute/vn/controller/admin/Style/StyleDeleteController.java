package hcmute.vn.controller.admin.Style;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.service.IStyleService;
import hcmute.vn.service.impl.StyleServiceImpl;
@MultipartConfig

@WebServlet(urlPatterns = { "/admin/styles/delete" })
public class StyleDeleteController extends HttpServlet{

	IStyleService styleService = new StyleServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// lấy dữ liệu trong jsp

			String styleId = req.getParameter("id");

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			styleService.delete(Integer.parseInt(styleId));

			// thông báo

			req.setAttribute("message", "Đã xóa thành công");

			req.getRequestDispatcher("/views/admin/system/style/list.jsp").forward(req, resp);

			resp.sendRedirect(req.getContextPath() + "/admin/styles/view");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}


	}

}

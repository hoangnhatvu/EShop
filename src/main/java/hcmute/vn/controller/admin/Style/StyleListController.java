package hcmute.vn.controller.admin.Style;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.entity.Style;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IStyleService;
import hcmute.vn.service.impl.StyleServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/styles/view" })
public class StyleListController extends HttpServlet {

	IStyleService styleService = new StyleServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Style> list = styleService.findAll();

			// trả về giá trị cho view

			req.setAttribute("styles", list);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/style/list.jsp").forward(req, resp);

	}

}

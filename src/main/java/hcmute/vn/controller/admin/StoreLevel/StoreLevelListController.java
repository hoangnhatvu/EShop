package hcmute.vn.controller.admin.StoreLevel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.entity.StoreLevel;
import hcmute.vn.service.IStoreLevelService;
import hcmute.vn.service.impl.StoreLevelServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/storelevels/view" })
public class StoreLevelListController extends HttpServlet {

	IStoreLevelService storeLevelService = new StoreLevelServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<StoreLevel> list = storeLevelService.findAll();

			// trả về giá trị cho view

			req.setAttribute("storelevels", list);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/storeLevel/list.jsp").forward(req, resp);
	}
}

package hcmute.vn.controller.admin.StoreLevel;

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
import hcmute.vn.entity.Users;
import hcmute.vn.service.IStoreLevelService;
import hcmute.vn.service.impl.StoreLevelServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/storelevels/update" })
public class StoreLevelUpdateController extends HttpServlet {
	IStoreLevelService storeLevelService = new StoreLevelServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khai báo biến productId

			String storeLevlelId = req.getParameter("id");

			// khởi tạo DAO

			// gọi hàm insert để thêm dữ liệu

			StoreLevel storeLevel = storeLevelService.findbyId(Integer.parseInt(storeLevlelId));

			req.setAttribute("storelevel", storeLevel);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/storeLevel/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			resp.setCharacterEncoding("UTF-8");

			// lấy dữ liệu từ jsp bằng BeanUtils

			StoreLevel storelevel = new StoreLevel();

			BeanUtils.populate(storelevel, req.getParameterMap());
			

			// khởi tạo DAO


			

			storeLevelService.update(storelevel);

			// thông báoF

			req.setAttribute("storelevel", storelevel);

			req.setAttribute("message", "Cập nhật thành công!");

			req.getRequestDispatcher("/views/admin/system/storeLevel/list.jsp");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: Không thể cập nhật");

		}

		resp.sendRedirect(req.getContextPath() + "/admin/storelevels/view");
	}
}

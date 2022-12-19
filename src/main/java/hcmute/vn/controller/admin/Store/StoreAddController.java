package hcmute.vn.controller.admin.Store;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Store;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/stores/add" })
public class StoreAddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IStoreService storeService = new StoreServiceImpl();
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Store store = new Store();

		List<Users> listUsers = userService.findAll();

		req.setAttribute("store", store);
		req.setAttribute("users", listUsers);

		req.getRequestDispatcher("/views/admin/store/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			req.setCharacterEncoding("UTF-8");

			// khỏi tạo đối tượng Model

			Store store = new Store();
			String userId = req.getParameter("userId");

			// Tim kiem User theo id

			Users user = userService.findById(Integer.parseInt(userId));

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity

			BeanUtils.populate(store, req.getParameterMap());

			// xử lý hình ảnh

			String fileName = String.valueOf(store.getId()) + System.currentTimeMillis();

			store.setAvatar(UploadUtils.processUpload("listImage", req, Constant.DIR + "\\category\\", fileName));

			// gọi hàm insert để thêm dữ liệu

			storeService.insert(store);

			// thông báo

			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		resp.sendRedirect(req.getContextPath() + "/admin/stores/view");
	}

}

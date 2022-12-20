package hcmute.vn.controller.admin.Store;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Store;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/stores/update" })
public class StoreUpdateController extends HttpServlet {
	IStoreService storeService = new StoreServiceImpl();
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khai báo biến productId

			String storeId = req.getParameter("id");

			// khởi tạo DAO

			// gọi hàm insert để thêm dữ liệu

			Store store = storeService.findbyId(Integer.parseInt(storeId));

			List<Users> listUsers = userService.findAll();

			req.setAttribute("store", store);
			req.setAttribute("users", listUsers);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/store/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			resp.setCharacterEncoding("UTF-8");

			// lấy dữ liệu từ jsp bằng BeanUtils

			Store store = new Store();

			String userId = req.getParameter("userId");

			BeanUtils.populate(store, req.getParameterMap());

			// tim kiem User theo id

			Users user = new Users();

			user = userService.findById(Integer.parseInt(userId));

			store.setUsers(user);

			System.out.println("----------------------------------------");
			System.out.println(store.getId());
			System.out.println(store.getName());
			System.out.println(store.getBio());
			System.out.println(store.getUsers().getId());
			System.out.println(store.getAvatar());

			System.out.println("----------------------------------------");

			// khởi tạo DAO

			// xử lý hình ảnh
			String oldImage = req.getParameter("avatar");

			// xử lý hình ảnh

			try {
				Part part = req.getPart("avatar");
				String realPath = req.getServletContext().getRealPath("/uploads");
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				if (!Files.exists(Paths.get(realPath))) {
					Files.createDirectory(Paths.get(realPath));
				}
				part.write(realPath + "/" + filename);
				String newImage = "/uploads/" + filename;
				System.out.println(newImage);
				store.setAvatar(newImage);
			} catch (Exception e) {
				System.out.println(oldImage);
				store.setAvatar(oldImage);
			}

			// khai báo danh sách và gọi hàm update trong service

			storeService.update(store);

			// thông báoF

			req.setAttribute("store", store);

			req.setAttribute("message", "Cập nhật thành công!");

			req.getRequestDispatcher("/views/admin/store/list.jsp");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: Không thể cập nhật");

		}

		resp.sendRedirect(req.getContextPath() + "/admin/stores/view");

	}

}

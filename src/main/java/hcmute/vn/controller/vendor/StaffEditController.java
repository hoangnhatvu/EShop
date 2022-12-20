package hcmute.vn.controller.vendor;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Staffs;
import hcmute.vn.entity.Store;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IStaffService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.StaffServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.UploadUtils;

@MultipartConfig
@WebServlet(urlPatterns = { "/vendor/staff-edit" })
public class StaffEditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();
	IStaffService staffService = new StaffServiceImpl();
	IStoreService storeService = new StoreServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		
		try {

			String staffId = request.getParameter("id");
			
			Staffs staff = staffService.findById(Integer.parseInt(staffId));
			
			Users user = userService.findById(staff.getUsers().getId());

			request.setAttribute("user", user);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

		request.getRequestDispatcher("/views/vendor/edit_staff.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");			

			Users user = new Users();

			BeanUtils.populate(user, request.getParameterMap());

			// khởi tạo DAO
			
			Users oldUser = userService.findById(user.getId());

			// xử lý hình ảnh

			if (request.getPart("avatar").getSize() == 0) {

				user.setAvatar(oldUser.getAvatar());

			} else {

				if (oldUser.getAvatar() != null) {

					// XOA ANH CU DI

					String fileName = oldUser.getAvatar();

					File file = new File(Constant.DIR + "\\user\\" + fileName);

					if (file.delete()) {

						System.out.println("Đã xóa thành công");

					} else {

						System.out.println(Constant.DIR + "\\user\\" + fileName);

					}

				}

				String fileName =Integer.toString(user.getId()) + System.currentTimeMillis();

				user.setAvatar(UploadUtils.processUpload("avatar", request, Constant.DIR + "\\user\\", fileName));

			}
			Date updateTime = new Date();
			
			user.setUpdateAt(updateTime);
			
			user.setHashedPassword(oldUser.getHashedPassword());
			
			user.setSlug(oldUser.getSlug());
			
			userService.update(user);
			
			request.setAttribute("message", "Cập nhật thành công!");
			
			response.sendRedirect(request.getContextPath() + "/vendor/staff");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}
	}
}
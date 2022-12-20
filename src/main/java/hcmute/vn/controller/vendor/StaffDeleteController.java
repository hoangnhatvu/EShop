package hcmute.vn.controller.vendor;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.vn.entity.Staffs;
import hcmute.vn.entity.Store;
import hcmute.vn.service.IStaffService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.StaffServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.Constant;

@MultipartConfig

@WebServlet(urlPatterns = { "/vendor/staff-delete" })

public class StaffDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();
	IStaffService staffService = new StaffServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
 
		try {

			String staffId = request.getParameter("id");			
			
			Staffs staff = staffService.findById(Integer.parseInt(staffId));
			
			if (staff.getUsers().getAvatar() != null) {

				String fileName = staff.getUsers().getAvatar();

				File file = new File(Constant.DIR + "\\user\\" + fileName);

				if (file.delete()) {

					System.out.println("Đã xóa thành công");

				} else {

					System.out.println(Constant.DIR + "\\user\\" + fileName);

				}

			}
			
			userService.delete(staff.getUsers().getId());
			
			HttpSession session = request.getSession();
			
			
			String storeId = (String)session.getAttribute("storeId");
			
			Store store = storeService.findById(Integer.parseInt(storeId));
			
			store.removeStaff(staff);
			
			response.sendRedirect(request.getContextPath() + "/vendor/staff");

			request.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {		

	}
}
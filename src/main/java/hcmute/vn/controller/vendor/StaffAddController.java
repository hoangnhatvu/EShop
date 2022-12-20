package hcmute.vn.controller.vendor;

import java.io.IOException;

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
import hcmute.vn.util.HashPassword;
import hcmute.vn.util.StringUtils;

@MultipartConfig
@WebServlet(urlPatterns = {"/vendor/staff-add"})
public class StaffAddController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	IStoreService storeService = new StoreServiceImpl();
	IUserService userService = new UserServiceImpl();
	IStaffService staffService = new StaffServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/vendor/add_staff.jsp").forward(request, response);		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SecurityException {
		
		try {
			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");			
			
			Users user = new Users();

			BeanUtils.populate(user, request.getParameterMap());			

			String password = request.getParameter("password");		
			
			HashPassword pw = new HashPassword();

			user.setHashedPassword(pw.hash(password));
			
			StringUtils remove = new StringUtils();
			
			String slug = remove.removeAccent(user.getFirstName()) + remove.removeAccent(user.getLastName()) + System.currentTimeMillis();
			
			user.setSlug(slug);	
			
			user.setRole(2);
			
			userService.createAccount(user);
			
			Users newUser = userService.findByEmail(user.getEmail());
			
			Staffs staff = new Staffs();
			
			staff.setUsers(newUser);
			
			HttpSession session = request.getSession();
			
			String storeId = (String)session.getAttribute("storeId");
			
			Store store = storeService.findById(Integer.parseInt(storeId));
			
			staffService.createStaff(store.addStaff(staff));
			
			response.sendRedirect(request.getContextPath() + "/vendor/staff");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
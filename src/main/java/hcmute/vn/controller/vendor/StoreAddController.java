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

import hcmute.vn.entity.Store;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.UploadUtils;

@MultipartConfig
@WebServlet(urlPatterns = {"/vendor/store-add"})
public class StoreAddController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	IStoreService storeService = new StoreServiceImpl();
	IUserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/vendor/add_store.jsp").forward(request, response);		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SecurityException {
		
		try {
			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");		
			
			HttpSession session = request.getSession();
			
			String ownerId = (String)session.getAttribute("ownerId");
			
			// khỏi tạo đối tượng Model

			Store store = new Store();

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity
			
			BeanUtils.populate(store, request.getParameterMap());

			// xử lý hình ảnh

			String fileName = "store" + System.currentTimeMillis();

			store.setAvatar(UploadUtils.processUpload("avatar", request, Constant.DIR + "\\store\\", fileName));
			
			// gọi hàm insert để thêm dữ liệu	
			
			System.out.println(store.getName());
			
			Users user = userService.findById(Integer.parseInt(ownerId));				

			storeService.insert(user.addStore(store));			
			
			request.setAttribute("message", "Đã thêm thành công");
			
			response.sendRedirect(request.getContextPath() + "/vendor/store");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

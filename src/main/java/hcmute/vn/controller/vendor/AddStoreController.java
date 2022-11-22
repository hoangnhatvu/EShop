package hcmute.vn.controller.vendor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Store;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.StoreServiceImpl;
import iotstar.vn.Util.Constant;
import iotstar.vn.Util.UploadUtils;
import iotstar.vn.entity.Category;

public class AddStoreController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	IStoreService storeService = new StoreServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/add-category.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SecurityException {
		Store store = new Store();
		try {
			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");

			// khỏi tạo đối tượng Model

			Category category = new Category();

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity
			
			BeanUtils.populate(category, request.getParameterMap());

			// xử lý hình ảnh

			String fileName = category.getCategorycode() + System.currentTimeMillis();

			category.setImages(UploadUtils.processUpload("images", request, Constant.DIR + "\\category\\", fileName));
			
			// gọi hàm insert để thêm dữ liệu

			categoryService.insert(category);					

			// thông báo

			request.setAttribute("message", "Đã thêm thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

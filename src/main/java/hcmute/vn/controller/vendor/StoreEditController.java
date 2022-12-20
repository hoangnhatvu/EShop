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

import hcmute.vn.entity.Category;
import hcmute.vn.entity.Product;
import hcmute.vn.entity.Store;
import hcmute.vn.service.ICategoryService;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.CategoryServiceImpl;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.UploadUtils;

@MultipartConfig
@WebServlet(urlPatterns = { "/vendor/store-edit" })
public class StoreEditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ICategoryService categoryService = new CategoryServiceImpl();
	IProductService productService = new ProductServiceImpl();
	IStoreService storeService = new StoreServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		
		try {
			
			HttpSession session = request.getSession();
			
			String storeId = (String)session.getAttribute("storeId");			
			
			Store store = storeService.findById(Integer.parseInt(storeId));
			
			request.setAttribute("store", store);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

		request.getRequestDispatcher("/views/vendor/edit_store.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");			

			Store store = new Store();

			BeanUtils.populate(store, request.getParameterMap());
			
			HttpSession session = request.getSession();
			
			String storeId = (String)session.getAttribute("storeId");
			
			store.setId(Integer.parseInt(storeId));
			
			Store oldStore = storeService.findById(Integer.parseInt(storeId));
			
			store.setUsers(oldStore.getUsers());

			if (request.getPart("avatar").getSize() == 0) {

				store.setAvatar(oldStore.getAvatar());

			} else {

				if (oldStore.getAvatar() != null) {

					// XOA ANH CU DI

					String fileName = oldStore.getAvatar();

					File file = new File(Constant.DIR + "\\store\\" + fileName);

					if (file.delete()) {

						System.out.println("Đã xóa thành công");

					} else {

						System.out.println(Constant.DIR + "\\store\\" + fileName);

					}

				}

				String fileName =Integer.toString(store.getId()) + System.currentTimeMillis();

				store.setAvatar(UploadUtils.processUpload("avatar", request, Constant.DIR + "\\store\\", fileName));

			}
			Date updateTime = new Date();
			
			store.setUpdateAt(updateTime);
			
			storeService.update(store);
			
			request.setAttribute("message", "Cập nhật thành công!");
			
			response.sendRedirect(request.getContextPath() + "/vendor/store-edit");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}
	}
}
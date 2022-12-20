package hcmute.vn.controller.vendor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hcmute.vn.entity.Store;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.StoreServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/vendor/store-delete" })

public class StoreDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IStoreService storeService = new StoreServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
 
		try {

			String storeid = request.getParameter("id");			
			
			Store store = storeService.findById(Integer.parseInt(storeid));
			
			storeService.delete(store.getId());
			
			response.sendRedirect(request.getContextPath() + "/vendor/store");

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
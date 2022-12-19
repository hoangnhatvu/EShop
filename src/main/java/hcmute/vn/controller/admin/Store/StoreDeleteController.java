package hcmute.vn.controller.admin.Store;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.service.IProductService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = {"/admin/stores/delete"})
public class StoreDeleteController extends HttpServlet{
	
	IStoreService storeService = new StoreServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// lấy dữ liệu trong jsp

			String storeId = req.getParameter("id");

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			storeService.delete(Integer.parseInt(storeId));

			// thông báo

			req.setAttribute("message", "Đã xóa thành công");
						
			req.getRequestDispatcher("/views/admin/store/list.jsp").forward(req, resp);
			
			resp.sendRedirect(req.getContextPath() + "/admin/stores/view");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}
		
	}
}

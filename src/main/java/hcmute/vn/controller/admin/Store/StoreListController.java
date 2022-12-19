package hcmute.vn.controller.admin.Store;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = {"/admin/stores/view"})
public class StoreListController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	IStoreService storeService = new StoreServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Store> list = storeService.findAll();

				//trả về giá trị cho view
			
			req.setAttribute("stores", list);
			


		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: " + e.getMessage());
			

		}
		
		req.getRequestDispatcher("/views/admin/store/list.jsp").forward(req, resp);	
	}
}

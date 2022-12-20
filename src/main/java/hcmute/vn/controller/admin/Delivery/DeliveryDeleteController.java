package hcmute.vn.controller.admin.Delivery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.service.IDeliveryService;
import hcmute.vn.service.impl.DeliveryServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/deliveries/delete" })
public class DeliveryDeleteController extends HttpServlet {
	IDeliveryService deliveryService = new DeliveryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// lấy dữ liệu trong jsp

			String deliveryId = req.getParameter("id");

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			deliveryService.delete(Integer.parseInt(deliveryId));

			// thông báo

			req.setAttribute("message", "Đã xóa thành công");

			req.getRequestDispatcher("/views/admin/system/delivery/list.jsp").forward(req, resp);

			resp.sendRedirect(req.getContextPath() + "/admin/deliveries/view");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}
	}

}

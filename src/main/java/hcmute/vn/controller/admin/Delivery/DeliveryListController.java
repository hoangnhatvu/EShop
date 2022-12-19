package hcmute.vn.controller.admin.Delivery;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.entity.Delivery;
import hcmute.vn.service.IDeliveryService;
import hcmute.vn.service.impl.DeliveryServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/deliveries/view" })
public class DeliveryListController extends HttpServlet {

	IDeliveryService deliveryService = new DeliveryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Delivery> list = deliveryService.findAll();

			// trả về giá trị cho view

			req.setAttribute("deliveries", list);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/delivery/list.jsp").forward(req, resp);
	}

}

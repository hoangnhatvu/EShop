package hcmute.vn.controller.admin.Oder;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.entity.Orders;
import hcmute.vn.entity.Product;
import hcmute.vn.service.IOrderService;
import hcmute.vn.service.impl.OrderServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/orders/view" })
public class OrderListController extends HttpServlet {

	IOrderService orderService = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Orders> list = orderService.findAll();

			// trả về giá trị cho view

			req.setAttribute("orders", list);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/order/list.jsp").forward(req, resp);
	}
}

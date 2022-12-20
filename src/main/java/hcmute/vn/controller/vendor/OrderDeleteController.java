package hcmute.vn.controller.vendor;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.vn.entity.Orders;
import hcmute.vn.entity.Store;
import hcmute.vn.service.IOrderService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.OrderServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/vendor/order-delete" })

public class OrderDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IOrderService orderService = new OrderServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
 
		try {

			String orderid = request.getParameter("id");			
			
			Orders order = orderService.findById(Integer.parseInt(orderid));
			
			HttpSession session = request.getSession();		
			
			String storeId = (String)session.getAttribute("storeId");
			
			Store store = storeService.findById(Integer.parseInt(storeId));
			
			store.removeOrder(order);
			
			orderService.delete(order.getId());
			
			response.sendRedirect(request.getContextPath() + "/vendor/order");

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
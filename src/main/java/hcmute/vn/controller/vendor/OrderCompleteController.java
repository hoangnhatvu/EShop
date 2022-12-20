package hcmute.vn.controller.vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/order-complete"})
public class OrderCompleteController extends HttpServlet{
	IStoreService storeService = new StoreServiceImpl();
	IOrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();		
		String orderid = request.getParameter("id");
		
		Orders order = orderService.findById(Integer.parseInt(orderid));
		order.setStatus(true);
		
		orderService.update(order);
		
		String storeId = (String)session.getAttribute("storeId");
		
		if(storeId != null)
		{
			Store store = storeService.findById(Integer.parseInt(storeId));
			
			
			
			List<Orders> orderList = store.getOrderses();
						
			request.setAttribute("orderList", orderList);
		}				
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/list_order.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}

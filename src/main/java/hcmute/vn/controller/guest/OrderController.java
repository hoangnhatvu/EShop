package hcmute.vn.controller.guest;

import hcmute.vn.entity.OrderItem;
import hcmute.vn.entity.Orders;
import hcmute.vn.service.IOrderItemService;
import hcmute.vn.service.IOrderService;
import hcmute.vn.service.impl.IOrderItemServiceImpl;
import hcmute.vn.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet( urlPatterns = {"/order", "/order/delete"})
public class OrderController extends HttpServlet {
    IOrderService orderService = new OrderServiceImpl();
    IOrderItemService orderItemService = new IOrderItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("delete")) {
            deleteOrder(request, response);
            findAllOrder(request, response);
            if (!response.isCommitted()) {
                request.getRequestDispatcher("/views/user/OrderList.jsp").forward(request, response);
            }
        }
        else{
            findAllOrder(request, response);
            if (!response.isCommitted()) {
                request.getRequestDispatcher("/views/user/OrderList.jsp").forward(request, response);
            }
        }

    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int ordId = Integer.parseInt(request.getParameter("ordId"));
                Orders orders = orderService.findbyId(ordId);
                if (orders.getStatus().equals("not precessed")) {
                    for(OrderItem orderItem : orders.getOrderItems()){
                        orderItemService.delete(orderItem);
                    }
                    orderService.delete(orders);
                    request.setAttribute("cancelMsg", "Hủy đơn hàng thành công");
                }
                else{
                    request.setAttribute("cancelMsg", "Hủy đơn hàng không thành công");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    private void findAllOrder(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                List<Orders> orders = orderService.findbyUserId(userId);
                request.setAttribute("orders", orders); //Trả về giá trị cho view
            }
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }
}

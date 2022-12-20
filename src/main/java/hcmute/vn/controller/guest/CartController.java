package hcmute.vn.controller.guest;

import hcmute.vn.entity.*;
import hcmute.vn.service.*;
import hcmute.vn.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ={"/cart", "/cart/delete", "/cart/updateQuantity", "/cart/checkout"})
public class CartController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    ICartService cartService = new CartServiceImpl();
    ICartItemService cartItemService = new CartItemServiceImpl();
    IOrderService orderService = new OrderServiceImpl();
    IOrderItemService orderItemService = new OrderItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("delete")){
            deleteCartItem(request, response);
            findAll(request, response);
            if (!response.isCommitted()) {
                request.getRequestDispatcher("/views/user-template/bodyContent/cart.jsp").forward(request, response);
            }
        } else if (url.contains("checkout")) {
            getCheckout(request, response);
        } else if (url.contains("updateQuantity")) {
            updateQuantity(request, response);
        } else {
            findAll(request, response);
            if (!response.isCommitted()){
                request.getRequestDispatcher("/views/user-template/bodyContent/cart.jsp").forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("updateQuantity")) {
            updateQuantity(request, response);
        } else if (url.contains("checkout")) {
            postCheckout(request, response);
            findAllOrder(request, response);
            request.getRequestDispatcher("/views/user-template/bodyContent/OrderList.jsp").forward(request,response);
        }
    }

    private void getCheckout(HttpServletRequest request, HttpServletResponse response) {
        try {
            findAll(request, response);
            List<Commission> commissions =  orderService.findCommision();
            List<Delivery> deliveries = orderService.findDelivery();
            request.setAttribute("commissions", commissions);
            request.setAttribute("deliveries", deliveries);
            request.getRequestDispatcher("/views/user-template/bodyContent/checkout.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void postCheckout(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Users user = userService.findById(userId);
                Commission comm = orderService.findCommisionById(Integer.parseInt(request.getParameter("commission")));
                Delivery deli = orderService.findDeliveryById(Integer.parseInt(request.getParameter("delivery")));
                String address = request.getParameter("address");
                int phone = Integer.parseInt(request.getParameter("phone"));

                Cart cart = cartService.findCartByUserId(userId);
                int total = 0;
                //tinh tong tien
                for (CartItem cartItem : cart.getCartItems()){
                    total = total + (cartItem.getProduct().getPrice() *(cartItem.getCount()));
                }
                int amount = total + (comm.getCost()*(deli.getPrice()));
                //tạo order
                Orders orders = new Orders(comm, deli, user, address, phone, amount);
                orderService.insert(orders);
                //thêm orderitem vào order
                for (CartItem cartItem : cart.getCartItems()){
                    OrderItem orderItem = new OrderItem(cartItem.getProduct(), cartItem.getCount(), cartItem.getProduct().getStore(),
                            4, cartItem.getProduct().getPrice() - 10, 3);
                    orderItemService.insert(orders.addOrderItem(orderItem));
                }
                //xoa cartitem khoi cart
                for (CartItem cartItem : cart.getCartItems()){
                    cartItemService.delete(cartItem);
                }

                request.setAttribute("orderMsg", "Đặt hàng thành công");

            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    private void updateQuantity(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int cartItemId = Integer.parseInt(request.getParameter("id"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                CartItem cartItem = cartItemService.findById(cartItemId);
                cartItem.setCount(quantity);
                cartItemService.update(cartItem);
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    private void deleteCartItem(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Cart userCart = cartService.findCartByUserId(userId);
                CartItem cartItem = cartItemService.findById(cartItemId);
                cartItemService.delete(userCart.removeCartItem(cartItem));
            }
        }catch (Exception e){
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

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Cart cart = cartService.findCartByUserId(userId);
                request.setAttribute("cartItems", cart.getCartItems()); //Trả về giá trị cho view
            }
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }
}

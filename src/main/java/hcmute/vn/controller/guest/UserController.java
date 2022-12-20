package hcmute.vn.controller.guest;

import hcmute.vn.entity.*;
import hcmute.vn.service.IFollowService;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.FollowServiceImpl;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.HashPassword;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/account", "/account/update", "/account/changePasswd", "/userFollow", "/followProduct", "/followStore"})
public class UserController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    IProductService productService = new ProductServiceImpl();
    IStoreService storeService = new StoreServiceImpl();
    IFollowService followService = new FollowServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("changePasswd")) {
            GetChangePasswd(request, response);
        } else if (url.contains("userFollow")) {
            userFollow(request, response);
        } else if (url.contains("followProduct")) {
            followProduct(request, response);
        } else if (url.contains("followStore")) {
            followStore(request, response);
        }
        else{
            findUser(request, response);
            if (!response.isCommitted()) {
                request.getRequestDispatcher("/views/user-template/bodyContent/account.jsp").forward(request, response);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("changePasswd")) {
            PostChangePasswd(request, response);
            findUser(request, response);
            if (!response.isCommitted()) {
                request.getRequestDispatcher("/views/user-template/bodyContent/account.jsp").forward(request, response);
            }
        }
        else if (url.contains("update")) {
            updateAccount(request, response);
            findUser(request, response);
            if (!response.isCommitted()) {
                request.getRequestDispatcher("/views/user-template/bodyContent/account.jsp").forward(request, response);
            }
        }
    }


    private void userFollow(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Users user = userService.findById(userId);
                List<UserFollowProduct> ufps = followService.findUFPByUId(userId);
                List<UserFollowStore> ufss = followService.findUFSByUId(userId);
                request.setAttribute("ufps", ufps);
                request.setAttribute("ufss", ufss);
                request.getRequestDispatcher("/views/user-template/bodyContent/follow.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }



    private void followStore(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Users user = userService.findById(userId);
                int storeId = Integer.parseInt(request.getParameter("storeId"));
                Store store = storeService.findStoresById(storeId);

                UserFollowStore existUserFollowStore = followService.findUFSByUIdAndPId(userId, storeId);
                if( existUserFollowStore == null) {
                    UserFollowStore userFollowStore = new UserFollowStore(store, user);
                    followService.followStore(user.addUserFollowStore(userFollowStore));
                } else {
                    followService.unfollowStore(existUserFollowStore);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }


    private void followProduct(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Users user = userService.findById(userId);
                int productId = Integer.parseInt(request.getParameter("productId"));
                Product product = productService.findProductById(productId);
                UserFollowProduct existUserFollowProduct = followService.findUFPByUIdAndPId(userId, productId);
                if (existUserFollowProduct == null) {
                    UserFollowProduct userFollowProduct = new UserFollowProduct(product, user);
                    followService.followProduct(user.addUserFollowProduct(userFollowProduct));
                } else {
                    followService.unfollowProduct(existUserFollowProduct);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }


    private boolean authUser(Users user, String password) {
        HashPassword pw = new HashPassword();
        String hashPass = pw.hash(password);
        return hashPass.equals(user.getHashedPassword()) ? true : false;
    }


    private void GetChangePasswd(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                request.getRequestDispatcher("/views/user-template/bodyContent/changePassword.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }
    private void PostChangePasswd(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Users user = userService.findById(userId);
                String password = request.getParameter("password");
                if (authUser(user, password)){
                    String newPassword = request.getParameter("newPassword");
                    HashPassword pw = new HashPassword();
                    String hashPass = pw.hash(newPassword);
                    user.setHashedPassword(hashPass);
                    userService.update(user);
                    request.setAttribute("updateMsg", "Thay đổi mật khẩu thành công");

                } else{
                    request.setAttribute("updateMsg", "Mật khẩu cũ không chính xác");
                    request.getRequestDispatcher("/views/user-template/bodyContent/changePassword.jsp").forward(request, response);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    private void findUser(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Users user = userService.findById(userId);
                request.setAttribute("user", user);
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Users user = userService.findById(userId);
                BeanUtils.populate(user, request.getParameterMap());
                userService.update(user);
                request.setAttribute("updateMsg", "Thay đổi thông tin thành oông !");
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }
}

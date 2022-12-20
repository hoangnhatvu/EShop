package hcmute.vn.controller.guest;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Review;
import hcmute.vn.entity.Store;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.IReviewService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.ReviewServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/search"})
public class SearchController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    IStoreService storeService = new StoreServiceImpl();
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            String searchString = request.getParameter("searchString");

            List<Product> productList = productService.findProductByName(searchString);
            List<Store> storeList = storeService.findStoresByName(searchString);
            List<Users> userList = userService.findUsersByName(searchString);

            request.setAttribute("productList", productList);
            request.setAttribute("storeList", storeList);
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/views/user/searchResult.jsp").forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

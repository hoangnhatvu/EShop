package hcmute.vn.controller.user;

import hcmute.vn.entity.*;
import hcmute.vn.service.ICategoryService;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.CategoryServiceImpl;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"","/contact", "/store"})
public class HomeController extends HttpServlet {
    ICategoryService categoryService = new CategoryServiceImpl();
    IProductService productService = new ProductServiceImpl();
    IStoreService storeService = new StoreServiceImpl();
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if(url.contains("contact")){
            contactPage(req, resp);
        } else if (url.contains("store")) {
            storePage(req, resp);
        } else {
            indexPage(req, resp);
        }
    }

    private void storePage(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int storeId = Integer.parseInt(req.getParameter("storeId"));
            Store store = storeService.findStoresById(storeId);
            List<Product> trendyProd = productService.findTrendyProd(storeId);
            List<Product> arrivalProd = productService.findArrivalProd(storeId);
            List<Product> products = productService.findProductByStoreId(storeId);

            req.setAttribute("store", store);
            req.setAttribute("trendyProd", trendyProd);
            req.setAttribute("arrivalProd", arrivalProd);
            req.setAttribute("products", products);
            req.getRequestDispatcher("/views/user-template/bodyContent/storeDetail.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void contactPage(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession(true);
            Users user = new Users();
            if (session.getAttribute("userId") != null) {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                user = userService.findById(userId);
            }
            req.setAttribute("user", user);
            req.getRequestDispatcher("/views/user-template/bodyContent/contact.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void indexPage(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("index");

            //lay category
            List<Category> categories = categoryService.findAll();
            System.out.println(categories);
            //lay trendy prod
            List<Product> trendyProd = productService.findTrendyProd();
            System.out.println(trendyProd);

            //lay arrival prod
            List<Product> arrivalProd = productService.findArrivalProd();
            System.out.println(arrivalProd);

            //lay top vendor
            List<Store> topVendor = storeService.findTopVendor();
            System.out.println(topVendor);

            HttpSession session = req.getSession();
            session.setAttribute("categories",categories);
            req.setAttribute("trendyProd", trendyProd);
            req.setAttribute("arrivalProd", arrivalProd);
            req.setAttribute("topVendor", topVendor);
            req.getRequestDispatcher("/views/user-template/index.jsp").forward(req, resp);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

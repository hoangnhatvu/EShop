package hcmute.vn.controller.guest;

import hcmute.vn.dao.ICategoryDao;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/product", "/product/detail", "/product/addToCart", "/product/review", "/product/addRview"})
public class ProductController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    ICartService cartService = new CartServiceImpl();
    ICartItemService cartItemService = new CartItemServiceImpl();
    IUserService userService =  new UserServiceImpl();
    IReviewService reviewService = new ReviewServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("addToCart")){
            addToCart(request, response);
        } else if (url.contains("review")){
            findProductReview(request, response);
        } else if (url.contains("detail")){
            productDetail(request, response);
        }
        else {
            findAll(request, response);
            request.getRequestDispatcher("/views/user-template/bodyContent/product.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("addRview")) {
            addReview(request, response);
        }
    }

    private void addReview(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Users users = userService.findById(userId);
                int prodId = Integer.parseInt(request.getParameter("prodId"));
                Product product = productService.findProductById(prodId);
                String content = request.getParameter("content");
                Review review = new Review(users, product, product.getStore(), content);
                reviewService.insert(review);
                response.sendRedirect(request.getContextPath()+"/product/detail?productId="+prodId);
            }
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    private void productDetail(HttpServletRequest request, HttpServletResponse response) {
        try {
            int prodId = Integer.parseInt(request.getParameter("productId"));
            Product product = productService.findProductById(prodId);
            List<Product> relatedProduct = productService.findRelatedProd(product);
            List<Review> reviews = reviewService.findReviewsByProdId(prodId);
            request.setAttribute("product", product);
            request.setAttribute("relatedProduct", relatedProduct);
            request.setAttribute("reviews", reviews);
            request.setAttribute("store", product.getStore());
            request.getRequestDispatcher("/views/user-template/bodyContent/productDetail.jsp").forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void findProductReview(HttpServletRequest request, HttpServletResponse response) {
        try {
            int prodId = Integer.parseInt(request.getParameter("productId"));
            List<Review> reviews = reviewService.findReviewsByProdId(prodId);
            System.out.println(reviews);
            request.setAttribute("reviews", reviews);
            request.getRequestDispatcher("/views/user/product.jsp").forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            if(session.getAttribute("userId") == null){
                response.sendRedirect(request.getContextPath()+"/login");
            }else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));

                int prodId = Integer.parseInt(request.getParameter("productId"));
                //Kiểm tra user có cart hay chưa nếu chưa thì tạo
                if (!cartService.existCart(userId)) {
                    Cart cart = new Cart(userService.findById(userId));
                    cartService.insert(cart);
                }
                Cart userCart = cartService.findCartByUserId(userId);
                Product product = productService.findProductById(prodId);
                CartItem cartItem = new CartItem(userCart, product, 1);
                //Kiểm tra sản phẩm đã tồn tại trong giỏ hàng chưa
                if (!cartItemService.existCartItem(cartItem)) {
                    cartItemService.insert(userCart.addCartItem(cartItem));
                }
                else{
                    CartItem existCartItem = cartItemService.findByProdId(cartItem);
                    existCartItem.setCount(existCartItem.getCount() + 1);
                    cartItemService.update(existCartItem);
                }
            }
        }
        catch  (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String indexPage = request.getParameter("index");
            if (indexPage == null || indexPage =="0") {
                indexPage = "1";
            }
            int indexp= Integer.parseInt(indexPage);

            int countP = 0;
            List<Product> products;
            if (request.getParameter("cateId") == null){
                 products = productService.findAll(indexp-1, 12);
                 countP = productService.count();
            }
            else{
                int cateId = Integer.valueOf(request.getParameter("cateId"));
                products = productService.findProductByCateId(cateId,indexp-1, 12);
                countP = productService.count(cateId);
            }
            int endPage = countP/12;
            if(countP % 12 !=0) {
                endPage ++;
            }
            request.setAttribute("products", products);
            request.setAttribute("countAll", countP);

            request.setAttribute("endP", endPage);
            request.setAttribute("tag", indexp);

            List<Category> listCategory = categoryService.findAll();

            request.setAttribute("categorys", listCategory);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Eror: " + e.getMessage());
        }
    }
}

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
import java.util.List;

@WebServlet(urlPatterns = {"/product", "/product/addToCart", "/product/review"})
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
        }
        else {
            findAll(request, response);
            request.getRequestDispatcher("/views/user/product.jsp").forward(request,response);
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
            int countP = productService.count();
            int endPage = countP/6;
            if(countP % 6 !=0) {
                endPage ++;
            }
            List<Product> products =
                    productService.findAll(indexp-1, 6);
            System.out.println(products);
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

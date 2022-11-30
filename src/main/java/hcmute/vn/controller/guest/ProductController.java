package hcmute.vn.controller.guest;

import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.entity.Category;
import hcmute.vn.entity.Product;
import hcmute.vn.service.ICategoryService;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.impl.CategoryServiceImpl;
import hcmute.vn.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/product", "/product/addToCart"})
public class ProductController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("addToCart")){
            addToCart(request, response);
        } else {
            findAll(request, response);
            request.getRequestDispatcher("/views/user/product.jsp").forward(request,response);
        }

    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) {
        int prodId = Integer.parseInt(request.getParameter("productId"));
        int userId = 1;
        //Kiểm tra user có cart hay chưa
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

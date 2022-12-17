package hcmute.vn.controller.user;

import hcmute.vn.entity.Category;
import hcmute.vn.service.ICategoryService;
import hcmute.vn.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {""})
public class HomeController extends HttpServlet {
    ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        indexpage(req, resp);
    }

    private void indexpage(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //lay category
            List<Category> categories = categoryService.findAll();


            //lay trendy prod

            //lay arrival prod

            //lay top vendor

            req.getRequestDispatcher("/views/user-template/index.jsp").forward(req, resp);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

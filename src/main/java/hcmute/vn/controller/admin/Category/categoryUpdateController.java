package hcmute.vn.controller.admin.Category;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Category;
import hcmute.vn.entity.Product;
import hcmute.vn.service.ICategoryService;
import hcmute.vn.service.impl.CategoryServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/categories/update" })
public class categoryUpdateController extends HttpServlet {

	ICategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khai báo biến productId

			String cateId = req.getParameter("id");

			// khởi tạo DAO

			// gọi hàm insert để thêm dữ liệu
			
			List<Category> cateList = categoryService.findAll();

			Category category = categoryService.findByCateId(Integer.parseInt(cateId));

			// thông báo

			req.setAttribute("category", category);
			req.setAttribute("categories", cateList);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/category/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			resp.setCharacterEncoding("UTF-8");

			// lấy dữ liệu từ jsp bằng BeanUtils

			Category category = new Category();

			BeanUtils.populate(category, req.getParameterMap());
			
			// Tao Category với id
			
			String cateId = req.getParameter("categoryId");
			
			Category category1 = categoryService.findByCateId(Integer.parseInt(cateId));
			
			//Cap nhat Date
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			category.setCreateAt(date);
			
								
			category.setCategory(category1);
			
			System.out.println("----------------------------------------");
			System.out.println(category.getId());
			System.out.println(category.getName());
			System.out.println(category.getCategory().getName());
			System.out.println(category.getCreateAt());
			System.out.println(category.getUpdateAt());
			System.out.println("----------------------------------------");

			
			
			


			categoryService.update(category);

			// thông báoF

			req.setAttribute("category", category);

			req.setAttribute("message", "Cập nhật thành công!");

			req.getRequestDispatcher("/views/admin/system/category/list.jsp");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: Không thể cập nhật");

		}

		resp.sendRedirect(req.getContextPath() + "/admin/categories/view");
	}
}

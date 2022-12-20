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
import hcmute.vn.util.Constant;
import hcmute.vn.util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/categories/add" })
public class CategoryAddController extends HttpServlet {
	ICategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Category category = new Category();

		// Lay danh sach category de chon root

		List<Category> listCate = categoryService.findAll();

		req.setAttribute("category", category);
		req.setAttribute("categories", listCate);

		req.getRequestDispatcher("/views/admin/system/category/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			req.setCharacterEncoding("UTF-8");

			// khỏi tạo đối tượng Model

			Category category = new Category();

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity

			BeanUtils.populate(category, req.getParameterMap());

			// Tao Category với id

			String cateId = req.getParameter("categoryId");

			Category category1 = categoryService.findByCateId(Integer.parseInt(cateId));

			// Cap nhat Date

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			category.setUpdateAt(date);

			category.setCreateAt(date);

			// gọi hàm insert để thêm dữ liệu

			categoryService.insert(category);

			// thông báo

			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		resp.sendRedirect(req.getContextPath() + "/admin/categories/view");
	}

}

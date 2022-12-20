package hcmute.vn.controller.admin.Style;

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
import hcmute.vn.entity.Style;
import hcmute.vn.service.IStyleService;
import hcmute.vn.service.impl.StyleServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/styles/add" })

public class StyleAddController extends HttpServlet {

	IStyleService styleService = new StyleServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Style style = new Style();


		req.setAttribute("style", style);


		req.getRequestDispatcher("/views/admin/system/style/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			req.setCharacterEncoding("UTF-8");

			// khỏi tạo đối tượng Model

			Style style = new Style();

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity

			BeanUtils.populate(style, req.getParameterMap());

		
			// Cap nhat Date

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			style.setCreateAt(date);

			// gọi hàm insert để thêm dữ liệu

			styleService.insert(style);

			// thông báo

			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		resp.sendRedirect(req.getContextPath() + "/admin/styles/view");
	}

}

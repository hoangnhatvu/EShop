package hcmute.vn.controller.admin.Commission;

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
import hcmute.vn.entity.Commission;
import hcmute.vn.service.ICommissionService;
import hcmute.vn.service.impl.CommissionServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/commissions/add" })
public class CommissionAddComtroller extends HttpServlet {
	ICommissionService commissionService = new CommissionServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Commission commission = new Commission();

		// Lay danh sach category de chon root

		req.setAttribute("com", commission);

		req.getRequestDispatcher("/views/admin/system/commission/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			req.setCharacterEncoding("UTF-8");

			// khỏi tạo đối tượng Model

			Commission commission = new Commission();

			String cost = req.getParameter("cost");

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity

			BeanUtils.populate(commission, req.getParameterMap());

			// Tao Category với id

			// Cap nhat Date

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

			commission.setCreateAt(date);

			// gọi hàm insert để thêm dữ liệu

			commission.setCost(Integer.parseInt(cost));

			commissionService.insert(commission);

			// thông báo

			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		resp.sendRedirect(req.getContextPath() + "/admin/categories/view");
	}
}

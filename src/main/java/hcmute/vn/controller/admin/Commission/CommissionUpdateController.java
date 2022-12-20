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

@WebServlet(urlPatterns = { "/admin/commissions/update" })
public class CommissionUpdateController extends HttpServlet {

	ICommissionService commissionService = new CommissionServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khai báo biến productId

			String id = req.getParameter("id");

			// khởi tạo DAO

			Commission commission = commissionService.findbyId(Integer.parseInt(id));

			// thông báo

			req.setAttribute("com", commission);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/commission/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			resp.setCharacterEncoding("UTF-8");

			// lấy dữ liệu từ jsp bằng BeanUtils

			Commission commission = new Commission();

			BeanUtils.populate(commission, req.getParameterMap());

			// Tao Category với id
			
			String cost = req.getParameter("cost");


			// Cap nhat Date

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			commission.setUpdateAt(date);
			
			commission.setCost(Integer.parseInt(cost));

			commissionService.update(commission);

			// thông báoF

			req.setAttribute("com", commission);

			req.setAttribute("message", "Cập nhật thành công!");

			req.getRequestDispatcher("/views/admin/system/commission/list.jsp");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: Không thể cập nhật");

		}

		resp.sendRedirect(req.getContextPath() + "/admin/commissions/view");
	}

}

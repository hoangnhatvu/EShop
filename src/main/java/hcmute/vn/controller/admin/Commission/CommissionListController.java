package hcmute.vn.controller.admin.Commission;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.dao.ICommissionDao;
import hcmute.vn.entity.Commission;
import hcmute.vn.service.ICommissionService;
import hcmute.vn.service.impl.CommissionServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/commissions/view" })
public class CommissionListController extends HttpServlet {

	ICommissionService commissionService = new CommissionServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Commission> list = commissionService.findAll();

			// trả về giá trị cho view

			req.setAttribute("commissions", list);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/commission/list.jsp").forward(req, resp);
	}
}

package hcmute.vn.controller.admin.Commission;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.service.ICommissionService;
import hcmute.vn.service.impl.CommissionServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/commissions/delete" })
public class CommissionDeleteController extends HttpServlet {

	ICommissionService commissionService = new CommissionServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// lấy dữ liệu trong jsp

			String id = req.getParameter("id");

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			commissionService.delete(Integer.parseInt(id));

			// thông báo

			req.setAttribute("message", "Đã xóa thành công");

			req.getRequestDispatcher("/views/admin/system/commission/list.jsp").forward(req, resp);

			resp.sendRedirect(req.getContextPath() + "/admin/commissions/view");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}
	}
}

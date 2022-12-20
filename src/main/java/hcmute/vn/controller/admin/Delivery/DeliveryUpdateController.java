package hcmute.vn.controller.admin.Delivery;

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
import hcmute.vn.entity.Delivery;
import hcmute.vn.service.IDeliveryService;
import hcmute.vn.service.impl.DeliveryServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/deliveries/update" })
public class DeliveryUpdateController extends HttpServlet {
	IDeliveryService deliveryService = new DeliveryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// khai báo biến productId

			String deliveryId = req.getParameter("id");

			// khởi tạo DAO

			// gọi hàm insert để thêm dữ liệu

			Delivery delivery = deliveryService.findbyId(Integer.parseInt(deliveryId));

			// thông báo

			req.setAttribute("delivery", delivery);

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		req.getRequestDispatcher("/views/admin/system/delivery/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			resp.setCharacterEncoding("UTF-8");

			// lấy dữ liệu từ jsp bằng BeanUtils

			Delivery delivery = new Delivery();

			BeanUtils.populate(delivery, req.getParameterMap());
			
			// doi string sang int
			
			String price =  req.getParameter("price");
			
			delivery.setPrice(Integer.parseInt(price));

	
			// Cap nhat Date

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			delivery.setUpdateAt(date);

			

			deliveryService.update(delivery);

			// thông báoF

			req.setAttribute("delivery", delivery);

			req.setAttribute("message", "Cập nhật thành công!");

			req.getRequestDispatcher("/views/admin/system/delivery/list.jsp");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("message", "Eror: Không thể cập nhật");

		}

		resp.sendRedirect(req.getContextPath() + "/admin/deliveries/view");
	}

}

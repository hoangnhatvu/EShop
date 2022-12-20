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

@WebServlet(urlPatterns = { "/admin/deliveries/add" })
public class DeliveryAddController extends HttpServlet {

	IDeliveryService deliveryService = new DeliveryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Delivery delivery = new Delivery();

		// Lay danh sach category de chon root

		List<Delivery> deliveryList = deliveryService.findAll();

		req.setAttribute("delivery", delivery);

		req.getRequestDispatcher("/views/admin/system/delivery/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			req.setCharacterEncoding("UTF-8");

			// khỏi tạo đối tượng Model

			Delivery delivery = new Delivery();

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity

			BeanUtils.populate(delivery, req.getParameterMap());

			// doi string sang int

			String price = req.getParameter("price");

			delivery.setPrice(Integer.parseInt(price));

			// Cap nhat Date

			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

			delivery.setCreateAt(date);

			// gọi hàm insert để thêm dữ liệu

			deliveryService.insert(delivery);

			// thông báo

			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		resp.sendRedirect(req.getContextPath() + "/admin/deliveries/view");
	}

}

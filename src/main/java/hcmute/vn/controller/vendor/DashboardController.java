package hcmute.vn.controller.vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.vn.entity.Store;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.StoreServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/dashboard"})
public class DashboardController extends HttpServlet {
	IStoreService storeService = new StoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		Store store = storeService.findById(Integer.parseInt(id));
		
		HttpSession session=req.getSession();
		
		session.setAttribute("storeId",store.getId().toString());
		
		req.setAttribute("store", store);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/dashboard.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}


package hcmute.vn.controller.vendor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.vn.entity.Staffs;
import hcmute.vn.entity.Store;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/staff"})
public class StaffListController extends HttpServlet {
	IStoreService storeService = new StoreServiceImpl();
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();		
		
		String storeId = (String)session.getAttribute("storeId");		
		String searching = (String)session.getAttribute("searching");
		
		if(storeId != null)
		{
			Store store = storeService.findById(Integer.parseInt(storeId));
			
			if(searching != null) {			
				List<Staffs> staffs = store.getStaffs();
				List<Staffs> staffList = new ArrayList<Staffs>();
				for (Staffs staff : staffs){
					if(searching.equals(staff.getUsers().getFirstName()))
					{
						staffList.add(staff);
					}
				}
				req.setAttribute("staffList", staffList);
				session.setAttribute("searching", null);	
			} else {
				List<Staffs> staffList = store.getStaffs();				
				req.setAttribute("staffList", staffList);
			}			
			
		}				
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/list_staff.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searching = req.getParameter("searching");		
		HttpSession session = req.getSession();	
		session.setAttribute("searching", searching);		
		
		resp.sendRedirect(req.getContextPath() + "/vendor/staff");
	}

}
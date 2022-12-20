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

import hcmute.vn.entity.Store;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/vendor/store"})
public class StoreListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	IStoreService storeService = new StoreServiceImpl();
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();		
		
		String ownerId = (String)session.getAttribute("ownerId");
		
		if(ownerId != null)
		{		
			if(session.getAttribute("searching") != null)
			{
				Users user = userService.findById(Integer.parseInt(ownerId));	
				String searching = (String)session.getAttribute("searching");
				List<Store> stores = user.getStores();
				List<Store> storeList = new ArrayList<Store>();
				
				for (Store store : stores){
					if(searching.equals(store.getName()))
					{
						storeList.add(store);
					}
					System.out.println(store.getName());
				}
				req.setAttribute("storeList", storeList);	
				session.setAttribute("searching", null);	
			}else {			
				Users user = userService.findById(Integer.parseInt(ownerId));	
				List<Store> storeList = user.getStores();
				req.setAttribute("storeList", storeList);	
			}
		}				
		
		req.getRequestDispatcher("/views/vendor/list_store.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searching = req.getParameter("searching");		
		HttpSession session = req.getSession();	
		session.setAttribute("searching", searching);		
		
		resp.sendRedirect(req.getContextPath() + "/vendor/store");
	}

}

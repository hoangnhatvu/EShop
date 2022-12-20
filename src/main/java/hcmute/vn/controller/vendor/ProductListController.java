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

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Store;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/product"})
public class ProductListController extends HttpServlet {
	IStoreService storeService = new StoreServiceImpl();
	IProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();		
		
		String storeId = (String)session.getAttribute("storeId");
		
		if(storeId != null)
		{			
			Store store = storeService.findById(Integer.parseInt(storeId));	
			String searching = (String)session.getAttribute("searching");
			if (searching != null)
			{
				List<Product> productList = new ArrayList<Product>();						
				List<Product> products = store.getProducts();
				
				for (Product product : products) {
					if (searching.contains(product.getName()))
					{
						productList.add(product);
					}
					System.out.println(product.getName());

				}
				req.setAttribute("productList", productList);
				session.setAttribute("searching", null);	

			} else {
				List<Product> productList = store.getProducts();
				req.setAttribute("productList", productList);
			}			
		}				
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/list_product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searching = req.getParameter("searching");		
		HttpSession session = req.getSession();	
		session.setAttribute("searching", searching);		
		
		resp.sendRedirect(req.getContextPath() + "/vendor/product");
	}

}
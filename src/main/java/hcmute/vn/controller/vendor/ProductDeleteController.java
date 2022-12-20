package hcmute.vn.controller.vendor;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Store;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.IUserService;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.service.impl.UserServiceImpl;
import hcmute.vn.util.Constant;

@MultipartConfig

@WebServlet(urlPatterns = { "/vendor/product-delete" })

public class ProductDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();
	IProductService productService = new ProductServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
 
		try {

			String productId = request.getParameter("id");			
			
			Product product = productService.findById(Integer.parseInt(productId));
			
			if (product.getListImage() != null) {

				String fileName = product.getListImage();

				File file = new File(Constant.DIR + "\\product\\" + fileName);

				if (file.delete()) {

					System.out.println("Đã xóa thành công");

				} else {

					System.out.println(Constant.DIR + "\\product\\" + fileName);

				}

			}
			
			HttpSession session = request.getSession();		
			
			String storeId = (String)session.getAttribute("storeId");
			
			Store store = storeService.findById(Integer.parseInt(storeId));
			
			product.getCategory().removeProduct(product);
			
			productService.delete(store.removeProduct(product).getId());
			
			response.sendRedirect(request.getContextPath() + "/vendor/product");

			request.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {		

	}
}
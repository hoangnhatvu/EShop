package hcmute.vn.controller.vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Category;
import hcmute.vn.entity.Product;
import hcmute.vn.entity.Store;
import hcmute.vn.service.ICategoryService;
import hcmute.vn.service.IProductService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.CategoryServiceImpl;
import hcmute.vn.service.impl.ProductServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.StringUtils;
import hcmute.vn.util.UploadUtils;

@MultipartConfig
@WebServlet(urlPatterns = {"/vendor/product-add"})
public class ProductAddController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	IStoreService storeService = new StoreServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	IProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categoryList = categoryService.findAll();
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/views/vendor/add_product.jsp").forward(request, response);		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SecurityException {
		
		try {
			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");		
			
			HttpSession session = request.getSession();
			
			String storeId = (String)session.getAttribute("storeId");
			
			Store store = storeService.findById(Integer.parseInt(storeId));
			
			Product product = new Product();

			BeanUtils.populate(product, request.getParameterMap());			

			String categoryId = request.getParameter("categoryId");		
			
			Category category = categoryService.findById(Integer.parseInt(categoryId));
			
			StringUtils remove = new StringUtils();
			
			String slug = remove.removeAccent(product.getName()) + System.currentTimeMillis();
			
			product.setSlug(slug);
			
			String fileName = "product" + System.currentTimeMillis();

			product.setListImage(UploadUtils.processUpload("listImage", request, Constant.DIR + "\\product\\", fileName));
			
			productService.create(store.addProduct(category.addProduct(product)));
			
			response.sendRedirect(request.getContextPath() + "/vendor/product");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
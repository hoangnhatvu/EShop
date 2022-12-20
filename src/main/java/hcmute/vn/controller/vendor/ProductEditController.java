package hcmute.vn.controller.vendor;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
import hcmute.vn.util.UploadUtils;

@MultipartConfig
@WebServlet(urlPatterns = { "/vendor/product-edit" })
public class ProductEditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ICategoryService categoryService = new CategoryServiceImpl();
	IProductService productService = new ProductServiceImpl();
	IStoreService storeService = new StoreServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		
		try {

			String productId = request.getParameter("id");
			
			Product product = productService.findById(Integer.parseInt(productId));
			
			request.setAttribute("product", product);
			
			List<Category> categoryList = categoryService.findAll();
			
			request.setAttribute("categoryList", categoryList);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

		request.getRequestDispatcher("/views/vendor/edit_product.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");			

			Product product = new Product();

			BeanUtils.populate(product, request.getParameterMap());

			String categoryId = request.getParameter("categoryId");		
			
			Category category = categoryService.findById(Integer.parseInt(categoryId));
			
			Product oldProduct = productService.findById(product.getId());

			// xử lý hình ảnh

			if (request.getPart("listImage").getSize() == 0) {

				product.setListImage(oldProduct.getListImage());

			} else {

				if (oldProduct.getListImage() != null) {

					// XOA ANH CU DI

					String fileName = oldProduct.getListImage();

					File file = new File(Constant.DIR + "\\product\\" + fileName);

					if (file.delete()) {

						System.out.println("Đã xóa thành công");

					} else {

						System.out.println(Constant.DIR + "\\product\\" + fileName);

					}

				}

				String fileName =Integer.toString(product.getId()) + System.currentTimeMillis();

				product.setListImage(UploadUtils.processUpload("listImage", request, Constant.DIR + "\\product\\", fileName));

			}
			Date updateTime = new Date();
			
			product.setUpdateAt(updateTime);
			
			product.setSlug(oldProduct.getSlug());
			
			product.setStore(oldProduct.getStore());
			
			oldProduct.getCategory().removeProduct(oldProduct);
			
			HttpSession session = request.getSession();
			
			String storeId = (String)session.getAttribute("storeId");
			
			Store store = storeService.findById(Integer.parseInt(storeId));
			
			store.addProduct(product);
			
			productService.update(category.addProduct(product));
			
			request.setAttribute("message", "Cập nhật thành công!");
			
			response.sendRedirect(request.getContextPath() + "/vendor/product");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}
	}
}
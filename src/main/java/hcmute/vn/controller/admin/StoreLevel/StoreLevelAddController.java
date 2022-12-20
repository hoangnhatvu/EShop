package hcmute.vn.controller.admin.StoreLevel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Store;
import hcmute.vn.entity.StoreLevel;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IStoreLevelService;
import hcmute.vn.service.IStoreService;
import hcmute.vn.service.impl.StoreLevelServiceImpl;
import hcmute.vn.service.impl.StoreServiceImpl;
import hcmute.vn.util.Constant;
import hcmute.vn.util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin/storelevels/add" })
public class StoreLevelAddController extends HttpServlet {

	IStoreLevelService storeLevelService = new StoreLevelServiceImpl();
	IStoreService storeService = new StoreServiceImpl();

	private List<Store> FilterIdFromStoreTable(List<Store> stores, List<StoreLevel> storeLevels) {

		List<Store> copyofStores = stores;

		copyofStores.toArray();

		storeLevels.toArray();

		try {

			for (int i = 0; i < copyofStores.size(); i++) {

				int id = copyofStores.get(i).getId();

				for (int j = 0; j < storeLevels.size(); j++) {
					if (storeLevels.get(j).getId() == copyofStores.get(i).getId())
						stores.remove(i);
				}

			}

			return copyofStores;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StoreLevel storelevel = new StoreLevel();

		List<StoreLevel> listStoreLevels = storeLevelService.findAll();

		// Lay Object cua Store

		List<Store> stores = storeService.findAll();

		List<Store> FilteredStores = FilterIdFromStoreTable(stores, listStoreLevels);

		req.setAttribute("storelevel", storelevel);
		req.setAttribute("availabeStore", FilteredStores);

		req.getRequestDispatcher("/views/admin/system/storeLevel/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			req.setCharacterEncoding("UTF-8");

			req.setCharacterEncoding("UTF-8");

			// Lay gia tri tu view
			String storeId = req.getParameter("storeId");
			
			System.out.println(storeId);

			String name = req.getParameter("name");

			String minPoint = req.getParameter("minPoint");

			String discount = req.getParameter("discount");
			
			// Khoi tao model Store de kiem store theo id
			
			Store store = new Store();
			
			store = storeService.findbyId(Integer.parseInt(storeId));
			
			System.out.println("------------------------");
			
			System.out.println(store.getId() + "   " + store.getName());
			
			System.out.println("------------------------");

			// Them properties vao model
			
			StoreLevel storeLevel = new StoreLevel(store, name, Integer.parseInt(minPoint), Integer.parseInt(discount));
			
			storeLevel.setStore(store);

			// gọi hàm insert để thêm dữ liệu

			storeLevelService.insert(storeLevel);

			// thông báo

			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

		resp.sendRedirect(req.getContextPath() + "/admin/products/view");
	}
}

package hcmute.vn.service.impl;

import hcmute.vn.dao.IProductDao;
import hcmute.vn.dao.impl.ProductDaoImpl;
import hcmute.vn.entity.Product;
import hcmute.vn.service.IProductService;

public class ProductServiceImpl implements IProductService{
	IProductDao productDao = new ProductDaoImpl();
	
	@Override
	public void create(Product product) {
		productDao.create(product);		
	}
	
	@Override
	public void update(Product product) {
		productDao.update(product);		
	}
	
	@Override
	public void delete(int productid) throws Exception {

		productDao.delete(productid);
	}
	
	@Override
	public Product findByName(String name) {
		return productDao.findByName(name);
	}
	
	@Override
	public Product findById(int productid) {
		return productDao.findById(productid);
	}
}

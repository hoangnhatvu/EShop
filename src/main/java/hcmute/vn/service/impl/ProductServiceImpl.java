package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.IProductDao;
import hcmute.vn.dao.impl.ProductDaoImpl;
import hcmute.vn.entity.Product;
import hcmute.vn.service.IProductService;

public class ProductServiceImpl implements IProductService{

	IProductDao productDao = new ProductDaoImpl();
	
	@Override
	public List<Product> findAll()
	{
		return productDao.findAll();
	}
	
	@Override
	public void update(Product product)
	{
		 productDao.update(product);
	}
	
	@Override
	public Product findbyId(int productId)
	{
		return productDao.findById(productId);
	}
	
	@Override
	public void delete(int prodId) throws Exception
	{
		 productDao.delete(prodId);
	}
	
	@Override
	public void insert(Product product)
	{
		productDao.insert(product);
	}

}

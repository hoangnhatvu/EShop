package hcmute.vn.service.impl;
<<<<<<< HEAD

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
=======
import java.util.List;
import hcmute.vn.dao.IProductDao;
import hcmute.vn.dao.impl.ProductDaoImpl;
import hcmute.vn.entity.Product;
import hcmute.vn.service.IProductService;

public class ProductServiceImpl implements IProductService{

	IProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> findProductByName(String searchString) {
        return productDao.findProductByName(searchString);
    }

    @Override
    public List<Product> findAll(int page, int pageSize) {
        return productDao.findAll(page, pageSize);
    }

    @Override
    public List<Product> findRelatedProd(Product product) {
        return productDao.findRelatedProd(product);
    }

    @Override
    public List<Product> findTrendyProd() { return productDao.findTrendyProd();}

    @Override
    public List<Product> findArrivalProd() { return productDao.findArrivalProd();}

    @Override
    public List<Product> findTrendyProd(int storeId) {
        return productDao.findTrendyProd(storeId);
    }

    @Override
    public List<Product> findArrivalProd(int storeId) {
        return productDao.findArrivalProd(storeId);
    }

    @Override
    public int count(int cateId) {
        return productDao.count(cateId);
    }
    @Override
    public int count() { return productDao.count();}

    @Override
    public Product findProductById(int prodId) {
        return productDao.findProductById(prodId);
    }

    @Override
    public List<Product> findProductByStoreId(int storeId) {
        return productDao.findProductByStoreId(storeId);
    }

    @Override
    public List<Product> findProductByCateId(int cateId, int page, int pageSize) {
        return productDao.findProductByCateId(cateId, page, pageSize);
    }
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

>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
}

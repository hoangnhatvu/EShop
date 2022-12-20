package hcmute.vn.service.impl;

import hcmute.vn.dao.IProductDao;
import hcmute.vn.dao.impl.ProductDaoImpl;
import hcmute.vn.entity.Product;
import hcmute.vn.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
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
}

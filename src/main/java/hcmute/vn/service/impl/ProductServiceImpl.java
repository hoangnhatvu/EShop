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
    public int count() {
        return productDao.count();
    }

    @Override
    public Product findProductById(int prodId) {
        return productDao.findProductById(prodId);
    }
}

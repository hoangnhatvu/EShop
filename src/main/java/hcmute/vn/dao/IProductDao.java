package hcmute.vn.dao;
import hcmute.vn.entity.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> findProductByName(String searchString);
    public List<Product> findAll(int page, int pageSize);
    public List<Product> findRelatedProd(Product product);
    public List<Product> findTrendyProd();
    public List<Product> findArrivalProd();
    public List<Product> findTrendyProd(int storeId);
    public List<Product> findArrivalProd(int storeId);
    public int count(int cateId);
    public int count();
    public Product findProductById(int prodId);
    public List<Product> findProductByStoreId(int prodId);

    public List<Product> findProductByCateId(int cateId, int page, int pageSize);
    }

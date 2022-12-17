package hcmute.vn.dao;
import hcmute.vn.entity.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> findProductByName(String searchString);
    public List<Product> findAll(int page, int pageSize);
    public List<Product> findTrendyProd();
    public List<Product> findArrivalProd();
    public int count();
    public Product findProductById(int prodId);
}

package hcmute.vn.dao;
<<<<<<< HEAD

import hcmute.vn.entity.Product;

public interface IProductDao {
	public void create(Product product);
	public void update(Product product);
	public Product findByName(String name);
	public Product findById(int productid);
	void delete(int productid) throws Exception;
=======
import java.util.List;
import hcmute.vn.entity.Product;

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
	List<Product> findAll();
	void update(Product product);
	Product findById(int productId);
	void delete(int prodId) throws Exception;
	void insert(Product product);
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
}

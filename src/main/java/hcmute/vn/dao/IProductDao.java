package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Product;

public interface IProductDao {

	List<Product> findAll();

	void update(Product product);

	Product findById(int productId);

	void delete(int prodId) throws Exception;

	void insert(Product product);

}

package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Product;

public interface IProductService {

	List<Product> findAll();

	void update(Product product);

	Product findbyId(int productId);

	void delete(int prodId) throws Exception;

	void insert(Product product);

}

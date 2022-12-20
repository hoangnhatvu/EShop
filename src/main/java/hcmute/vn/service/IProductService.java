package hcmute.vn.service;

import hcmute.vn.entity.Product;

public interface IProductService {
	public void create(Product product);
	public void update(Product product);
	public void delete(int productid) throws Exception;
	public Product findByName(String name);
	public Product findById(int productid);
}

package hcmute.vn.dao;

import hcmute.vn.entity.Product;

public interface IProductDao {
	public void create(Product product);
	public void update(Product product);
	public Product findByName(String name);
	public Product findById(int productid);
	void delete(int productid) throws Exception;
}

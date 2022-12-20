package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Category;

public interface ICategoryDao {

	void insert(Category category);

	void delete(int categoryId) throws Exception;

	public Category findById(int categoryId);

	void update(Category category);

	public List<Category> findAll();
	public int countProdByCateId(int cateId);

}

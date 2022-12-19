package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Category;

public interface ICategoryDao {

	void insert(Category category);

	void delete(int categoryId) throws Exception;

	Category findById(int categoryId);

	void update(Category category);

	List<Category> findAll();

}

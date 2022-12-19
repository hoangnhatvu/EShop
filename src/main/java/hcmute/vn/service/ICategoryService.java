package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Category;

public interface ICategoryService {

	void delete(int cateId) throws Exception;

	void insert(Category cate);

	void update(Category cate);

	List<Category> findAll();

	Category findByCateId(int cateId);


}

package hcmute.vn.service;


import java.util.List;

import hcmute.vn.entity.Category;

public interface ICategoryService {

	void delete(int cateId) throws Exception;

	void insert(Category cate);

	void update(Category cate);

	public List<Category> findAll();

	public Category findByCateId(int cateId);
	public int countProdByCateId(int cateId);
}

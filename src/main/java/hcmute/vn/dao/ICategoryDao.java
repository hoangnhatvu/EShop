package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Category;

public interface ICategoryDao {
<<<<<<< HEAD
	public List<Category> findAll();
	public Category findById(int categoryid);
=======

	void insert(Category category);

	void delete(int categoryId) throws Exception;

	public Category findById(int categoryId);

	void update(Category category);

	public List<Category> findAll();
	public int countProdByCateId(int cateId);
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git

}

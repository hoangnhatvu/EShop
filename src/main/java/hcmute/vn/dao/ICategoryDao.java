package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Category;

public interface ICategoryDao {
	public List<Category> findAll();
	public Category findById(int categoryid);

}

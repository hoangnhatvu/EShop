package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Category;

public interface ICategoryService {
	public List<Category> findAll();
	public Category findById(int categoryid);
}

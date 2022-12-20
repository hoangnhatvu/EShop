package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.dao.impl.CategoryDaoImpl;
import hcmute.vn.entity.Category;
import hcmute.vn.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	
	ICategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	
	@Override
	public Category findById(int categoryid) {
		return categoryDao.findById(categoryid);
	}
}

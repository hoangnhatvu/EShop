package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.dao.impl.CategoryDaoImpl;
import hcmute.vn.entity.Category;
import hcmute.vn.service.ICategoryService;

<<<<<<< HEAD
public class CategoryServiceImpl implements ICategoryService {
	
	ICategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	
	@Override
	public Category findById(int categoryid) {
		return categoryDao.findById(categoryid);
=======

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public int countProdByCateId(int cateId) {
        return categoryDao.countProdByCateId(cateId);
    }

	@Override
	public Category findByCateId(int cateId) {
		return categoryDao.findById(cateId);
	}


	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}


	@Override
	public void update(Category cate) {
		categoryDao.update(cate);
	}


	@Override
	public void insert(Category cate) {
		categoryDao.insert(cate);
	}


	@Override
	public void delete(int cateId) throws Exception {
		categoryDao.delete(cateId);
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
	}
}

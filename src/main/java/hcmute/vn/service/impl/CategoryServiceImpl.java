package hcmute.vn.service.impl;

import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.dao.impl.CategoryDaoImpl;
import hcmute.vn.entity.Category;
import hcmute.vn.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public int countProdByCateId(int cateId) {
        return categoryDao.countProdByCateId(cateId);
    }
}

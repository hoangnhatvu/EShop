package hcmute.vn.service.impl;

import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.dao.impl.ICategoryDaoImpl;
import hcmute.vn.entity.Category;
import hcmute.vn.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDao categoryDao = new ICategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}

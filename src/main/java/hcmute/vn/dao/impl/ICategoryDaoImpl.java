package hcmute.vn.dao.impl;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.entity.Category;
import hcmute.vn.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ICategoryDaoImpl implements ICategoryDao {
    @Override
    public List<Category> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Category> categories = (List<Category>) enma.createQuery("FROM Category C ORDER BY C.name").getResultList();
        return categories;
    }
}

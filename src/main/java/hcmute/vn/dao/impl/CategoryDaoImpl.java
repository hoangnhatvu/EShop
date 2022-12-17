package hcmute.vn.dao.impl;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    @Override
    public List<Category> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Category> categories = (List<Category>) enma.createQuery("FROM Category C").getResultList();
        return categories;
    }

    @Override
    public int countProdByCateId(int cateId) {
        EntityManager enma = JPAConfig.getEntityManager();
        int count = (int) enma.createQuery("FROM Product P WHERE P.categoryId =: cateId").setParameter("cateId", cateId).getResultList().size();
        return count;
    }

}

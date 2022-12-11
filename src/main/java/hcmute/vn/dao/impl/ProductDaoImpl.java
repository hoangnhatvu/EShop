package hcmute.vn.dao.impl;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IProductDao;
import hcmute.vn.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    @Override
    public List<Product> findProductByName(String searchString) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.name like :name").setParameter("name", "%" + searchString + "%").getResultList();
        return products;
    }

    public Product findProductById(int prodId) {
        EntityManager enma = JPAConfig.getEntityManager();
        Product product = (Product) enma.createQuery("FROM Product P WHERE P.id = :prodId").setParameter("prodId", prodId).getSingleResult();
        return product;
    }

    @Override
    public List<Product> findAll(int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P ORDER BY P.name").setFirstResult(page*pageSize).setMaxResults(pageSize).getResultList();
        return products;
    }

    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        int count = ((Long) enma.createQuery("SELECT count(P) FROM Product P").getSingleResult()).intValue();
        return count;
    }
}

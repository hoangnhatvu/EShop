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
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.name like :name and P.isSelling = true").setParameter("name", "%" + searchString + "%").getResultList();
        return products;
    }

    public Product findProductById(int prodId) {
        EntityManager enma = JPAConfig.getEntityManager();
        Product product = (Product) enma.createQuery("FROM Product P WHERE P.id = :prodId and P.isSelling = true").setParameter("prodId", prodId).getSingleResult();
        return product;
    }

    @Override
    public List<Product> findProductByStoreId(int storeId) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.store.id = :storeId and P.isSelling = true").setParameter("storeId", storeId).getResultList();
        return products;
    }

    public List<Product> findProductByCateId(int cateId, int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.categoryId = :cateId and P.isSelling = true ORDER BY P.name").setParameter("cateId", cateId).setFirstResult(page*pageSize).setMaxResults(pageSize).getResultList();
        return products;
    }

    @Override
    public List<Product> findAll(int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P ORDER BY P.name").setFirstResult(page*pageSize).setMaxResults(pageSize).getResultList();
        return products;
    }

    public List<Product> findRelatedProd(Product product) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.categoryId =: cateId and P.name like :name").setParameter("cateId", product.getCategoryId()).setParameter("name", "%"+product.getName().substring(0, 3)+"%").setMaxResults(4).getResultList();
        return products;
    }

    @Override
    public List<Product> findTrendyProd() {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.isSelling = true ORDER BY P.rating DESC").setMaxResults(8).getResultList();
        return products;
    }

    @Override
    public List<Product> findArrivalProd() {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.isSelling = true ORDER BY P.createAt DESC").setMaxResults(8).getResultList();
        return products;
    }

    @Override
    public List<Product> findTrendyProd(int storeId) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.store.id =: storeId and P.isSelling = true ORDER BY P.rating DESC").setParameter("storeId", storeId).setMaxResults(8).getResultList();
        return products;
    }

    @Override
    public List<Product> findArrivalProd(int storeId) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.store.id =: storeId and P.isSelling = true ORDER BY P.createAt DESC").setParameter("storeId", storeId).setMaxResults(8).getResultList();
        return products;
    }

    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        int count = ((Long) enma.createQuery("SELECT count(P) FROM Product P WHERE P.isSelling = true").getSingleResult()).intValue();
        return count;
    }
    @Override
    public int count(int cateId) {
        EntityManager enma = JPAConfig.getEntityManager();
        int count = ((Long) enma.createQuery("SELECT count(P) FROM Product P WHERE P.categoryId =:cateId and P.isSelling = true").setParameter("cateId", cateId).getSingleResult()).intValue();
        return count;
    }
}

package hcmute.vn.dao.impl;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.ICartDao;
import hcmute.vn.entity.Cart;
import hcmute.vn.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CartDaoImpl implements ICartDao {

    @Override
    public boolean existCart(int userId) {
        EntityManager enma = JPAConfig.getEntityManager();
        boolean cart = enma.createQuery("FROM Cart C WHERE C.users.id = :userId").setParameter("userId", userId).getResultList().size() > 0 ? true : false;
        return cart;
    }

    @Override
    public Cart findCartByUserId(int userId) {
        EntityManager enma = JPAConfig.getEntityManager();
        Cart cart = (Cart) enma.createQuery("FROM Cart C WHERE C.users.id = :userId").setParameter("userId", userId).getSingleResult();
        return cart;
    }

    @Override
    public void insert (Cart cart) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(cart);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }
}

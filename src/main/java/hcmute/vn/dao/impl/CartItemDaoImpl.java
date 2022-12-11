package hcmute.vn.dao.impl;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.ICartItemDao;
import hcmute.vn.entity.CartItem;
import hcmute.vn.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CartItemDaoImpl implements ICartItemDao {
    @Override
    public void insert(CartItem cartItem) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(cartItem);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }
    public void update(CartItem cartItem) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(cartItem);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    public void delete(CartItem cartItem) throws Exception{
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            CartItem cartItem1 = enma.find(CartItem.class, cartItem.getId());
            if (cartItem1 != null) {
                enma.remove(cartItem1);
            } else {
                throw new Exception("Không tìm thấy");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }
    public CartItem findById(int id){
        EntityManager enma = JPAConfig.getEntityManager();
        CartItem cartItem = (CartItem) enma.createQuery("FROM CartItem I WHERE I.id = :cartItemId").setParameter("cartItemId", id).getSingleResult();
        return cartItem;
    }
    public CartItem findByProdId (Product product) {
        EntityManager enma = JPAConfig.getEntityManager();
        CartItem cartItem = (CartItem) enma.createQuery("FROM CartItem I WHERE I.product = :product").setParameter("product", product).getSingleResult();
        return cartItem;
    }
    public boolean existCartItem(Product product) {
        EntityManager enma = JPAConfig.getEntityManager();
        boolean prod = enma.createQuery("FROM CartItem I WHERE I.product = :product").setParameter("product", product).getResultList().size() > 0 ? true : false;
        return prod;
    }
}

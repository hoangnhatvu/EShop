package hcmute.vn.dao.impl;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IReviewDao;
import hcmute.vn.entity.CartItem;
import hcmute.vn.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ReviewDaoImpl implements IReviewDao {
    @Override
    public List<Review> findReviewsByProdId(int prodId) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Review> reviews = (List<Review>) enma.createQuery("FROM Review R WHERE R.product.id = :id").setParameter("id", prodId).getResultList();
        return reviews;
    }

    @Override
    public void insert(Review review) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(review);
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

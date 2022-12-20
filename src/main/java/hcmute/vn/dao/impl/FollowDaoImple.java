package hcmute.vn.dao.impl;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IFollowDao;
import hcmute.vn.entity.UserFollowProduct;
import hcmute.vn.entity.UserFollowStore;
import hcmute.vn.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;

public class FollowDaoImple implements IFollowDao {
    public UserFollowProduct findUFPByUIdAndPId(int uId, int pId){
        UserFollowProduct ufp = null;
        try {
            EntityManager enma = JPAConfig.getEntityManager();
            ufp = (UserFollowProduct) enma.createQuery("FROM UserFollowProduct U WHERE U.users.id = :uid and U.product.id = :pid").setParameter("uid", uId).setParameter("pid", pId).getSingleResult();
        } catch (NoResultException nre){
            nre.printStackTrace();
        }
        return ufp;
    }

    public UserFollowStore findUFSByUIdAndPId(int uId, int sId){
        UserFollowStore ufs = null;
        try {
            EntityManager enma = JPAConfig.getEntityManager();
            ufs = (UserFollowStore) enma.createQuery("FROM UserFollowStore U WHERE U.users.id = :uid and U.store.id = :sid").setParameter("uid", uId).setParameter("sid", sId).getSingleResult();
        } catch (NoResultException nre){
            nre.printStackTrace();
        }
        return ufs;
    }

    public List<UserFollowProduct> findUFPByUId(int uId){
        List<UserFollowProduct> ufp = null;
        try {
            EntityManager enma = JPAConfig.getEntityManager();
            ufp = (List<UserFollowProduct>) enma.createQuery("FROM UserFollowProduct U WHERE U.users.id = :uid").setParameter("uid", uId).getResultList();
        } catch (NoResultException nre){
            nre.printStackTrace();
        }
        return ufp;
    }

    public List<UserFollowStore> findUFSByUId(int uId){
        List<UserFollowStore> ufs = null;
        try {
            EntityManager enma = JPAConfig.getEntityManager();
            ufs = (List<UserFollowStore>) enma.createQuery("FROM UserFollowStore U WHERE U.users.id = :uid").setParameter("uid", uId).getResultList();
        } catch (NoResultException nre){
            nre.printStackTrace();
        }
        return ufs;
    }


    public void followStore(UserFollowStore userFollowStore) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(userFollowStore);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }
    public void unfollowStore(UserFollowStore userFollowStore) throws Exception{
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            UserFollowStore userFollowStore1 = enma.find(UserFollowStore.class, userFollowStore.getId());
            if (userFollowStore1 != null) {
                enma.remove(userFollowStore1);
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
    public void followProduct(UserFollowProduct userFollowProduct) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(userFollowProduct);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }
    public void unfollowProduct(UserFollowProduct userFollowProduct) throws Exception{
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            UserFollowProduct userFollowProduct1 = enma.find(UserFollowProduct.class, userFollowProduct.getId());
            if (userFollowProduct1 != null) {
                enma.remove(userFollowProduct1);
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
}

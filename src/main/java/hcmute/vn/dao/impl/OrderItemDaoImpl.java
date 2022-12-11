package hcmute.vn.dao.impl;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IOrderItemDao;
import hcmute.vn.entity.OrderItem;
import hcmute.vn.entity.Orders;
import hcmute.vn.entity.Store;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class OrderItemDaoImpl implements IOrderItemDao {
    @Override
    public void insert(OrderItem orderItem) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(orderItem);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void delete(OrderItem orderItem) throws Exception{
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            OrderItem orderItem1 = enma.find(OrderItem.class, orderItem.getId());
            if (orderItem1 != null) {
                enma.remove(orderItem1);
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


    @Override
    public OrderItem findById(int id) {
        EntityManager enma = JPAConfig.getEntityManager();
        OrderItem orderItem = (OrderItem) enma.createQuery("FROM OrderItem I WHERE I.id =:id").setParameter("id", id).getSingleResult();
        return orderItem;
    }

    @Override
    public List<OrderItem> findByOrder(Orders orders) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<OrderItem> orderItems = (List<OrderItem>) enma.createQuery("FROM OrderItem I WHERE I.orders =:orders").setParameter("orders", orders).getResultList();
        return orderItems;
    }

    @Override
    public List<OrderItem> findByStore(Store store) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<OrderItem> orderItems = (List<OrderItem>) enma.createQuery("FROM OrderItem I WHERE I.store =:store").setParameter("store", store).getResultList();
        return orderItems;
    }
}

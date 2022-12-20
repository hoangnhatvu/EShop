package hcmute.vn.dao.impl;
<<<<<<< HEAD

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IOrderDao;
import hcmute.vn.entity.Orders;

public class OrderDaoImpl implements IOrderDao {
	public void update(Orders order) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(order);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}
	
	public void delete(int orderid) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Orders Order = enma.find(Orders.class, orderid);

			if (Order != null) {

				enma.remove(Order);

			} else {

				throw new Exception("Không tìm thấy");

			}

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}
	
	public Orders findById(int orderid) {
		EntityManager enma = JPAConfig.getEntityManager();

		Orders order = enma.find(Orders.class, orderid);

		return order;
	}
=======
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IOrderDao;
import hcmute.vn.entity.Commission;
import hcmute.vn.entity.Delivery;
import hcmute.vn.entity.Orders;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public List<Orders> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Orders> query = enma.createNamedQuery("Orders.findAll", Orders.class);

		return query.getResultList();

	}
    @Override
    public Orders findbyId(int id) {
        EntityManager enma = JPAConfig.getEntityManager();
        Orders orders = (Orders) enma.createQuery("FROM Orders O WHERE O.id = :Id").setParameter("Id", id).getSingleResult();
        return orders;
    }

    @Override
    public List<Orders> findbyUserId(int id) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Orders> orders = (List<Orders>) enma.createQuery("FROM Orders O WHERE O.users.id = :Id").setParameter("Id", id).getResultList();
        return orders;
    }

    public List<Commission> findCommision(){
        EntityManager enma = JPAConfig.getEntityManager();
        List<Commission> commissions = (List<Commission>) enma.createQuery("FROM Commission C order by C.name").getResultList();
        return commissions;
    }

    public List<Delivery> findDelivery(){
        EntityManager enma = JPAConfig.getEntityManager();
        List<Delivery> commissions = (List<Delivery>) enma.createQuery("FROM Delivery D order by D.name").getResultList();
        return commissions;
    }

    public Commission findCommisionById(int id){
        EntityManager enma = JPAConfig.getEntityManager();
        Commission commissions = (Commission) enma.createQuery("FROM Commission C WHERE C.id =:id").setParameter("id", id).getSingleResult();
        return commissions;
    }

    public Delivery findDeliveryById(int id){
        EntityManager enma = JPAConfig.getEntityManager();
        Delivery commissions = (Delivery) enma.createQuery("FROM Delivery D WHERE D.id = :id").setParameter("id", id).getSingleResult();
        return commissions;
    }

    @Override
    public void insert (Orders order) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(order);
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
    public void update(Orders order) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(order);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    public void delete(Orders order) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Orders existOrder = enma.find(Orders.class, order.getId());
            if (existOrder != null) {
                enma.remove(existOrder);
            } else {
                throw new Exception("Không tìm thấy");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
}

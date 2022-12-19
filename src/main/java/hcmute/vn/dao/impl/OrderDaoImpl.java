package hcmute.vn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IOrderDao;
import hcmute.vn.entity.Delivery;
import hcmute.vn.entity.Orders;
import hcmute.vn.entity.Product;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public List<Orders> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Orders> query = enma.createNamedQuery("Orders.findAll", Orders.class);

		return query.getResultList();

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

		} finally {

			enma.close();

		}

	}

	@Override
	public Orders findById(int id) {

		EntityManager enma = JPAConfig.getEntityManager();

		Orders order = enma.find(Orders.class, id);

		return order;

	}

	@Override
	public void insert(Orders order) {

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

}

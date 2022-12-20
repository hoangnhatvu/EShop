package hcmute.vn.dao.impl;

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
}

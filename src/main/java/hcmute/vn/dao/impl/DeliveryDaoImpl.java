package hcmute.vn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IDeliveryDao;
import hcmute.vn.entity.Delivery;

public class DeliveryDaoImpl implements IDeliveryDao {

	@Override
	public List<Delivery> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Delivery> query = enma.createNamedQuery("Delivery.findAll", Delivery.class);

		return query.getResultList();

	}

	@Override
	public void update(Delivery delivery) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(delivery);

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
	public Delivery findById(int deliveryId) {

		EntityManager enma = JPAConfig.getEntityManager();

		Delivery delivery = enma.find(Delivery.class, deliveryId);

		return delivery;

	}

	@Override
	public void delete(int deliveryId) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Delivery delivery = enma.find(Delivery.class, deliveryId);

			if (delivery != null) {

				enma.remove(delivery);

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

	@Override
	public void insert(Delivery delivery) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(delivery);

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

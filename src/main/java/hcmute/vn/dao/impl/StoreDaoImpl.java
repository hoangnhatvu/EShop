package hcmute.vn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IStoreDao;
import hcmute.vn.entity.Store;


public class StoreDaoImpl implements IStoreDao {
	public void insert(Store store) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(store);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}
	}
	public List<Store> findAll() {

		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Store> query = enma.createNamedQuery("Store.findAll", Store.class);

		return query.getResultList();

	}
}

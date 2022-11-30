package hcmute.vn.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IStoreDao;
import hcmute.vn.entity.Product;
import hcmute.vn.entity.Store;

import java.util.List;


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

	@Override
	public List<Store> findStoresByName(String searchString) {
		EntityManager enma = JPAConfig.getEntityManager();
		List<Store> stores = (List<Store>) enma.createQuery("FROM Store S WHERE S.name like :name").setParameter("name", "%" + searchString + "%").getResultList();
		return stores;
	}
}

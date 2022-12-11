package hcmute.vn.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IStoreDao;
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
	public List<Store> findAll() {

		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Store> query = enma.createNamedQuery("Store.findAll", Store.class);

		return query.getResultList();

	}

	@Override
	public List<Store> findStoresByName(String searchString) {
		EntityManager enma = JPAConfig.getEntityManager();
		List<Store> stores = (List<Store>) enma.createQuery("FROM Store S WHERE S.name like :name").setParameter("name", "%" + searchString + "%").getResultList();
		return stores;
	}

	public Store findStoresById(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		Store store = (Store) enma.createQuery("FROM Store S WHERE S.id =:id").setParameter("id",id).getSingleResult();
		return store;
	}
}

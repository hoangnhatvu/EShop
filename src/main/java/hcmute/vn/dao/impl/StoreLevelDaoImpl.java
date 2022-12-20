package hcmute.vn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IStoreLevelDao;
import hcmute.vn.entity.StoreLevel;

public class StoreLevelDaoImpl implements IStoreLevelDao {

	@Override
	public List<StoreLevel> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<StoreLevel> query = enma.createNamedQuery("StoreLevel.findAll", StoreLevel.class);

		return query.getResultList();

	}

	@Override
	public void update(StoreLevel storeLevel) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(storeLevel);

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
	public StoreLevel findById(int id) {

		EntityManager enma = JPAConfig.getEntityManager();

		StoreLevel storeLevel = enma.find(StoreLevel.class, id);

		return storeLevel;

	}

	@Override
	public void delete(int id) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			StoreLevel storeLevel = enma.find(StoreLevel.class, id);

			if (storeLevel != null) {

				enma.remove(storeLevel);

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
	public void insert(StoreLevel storeLevel) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(storeLevel);

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

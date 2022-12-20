package hcmute.vn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IUserLevelDao;
import hcmute.vn.entity.UserLevel;

public class UserLevelDaoImpl implements IUserLevelDao {

	@Override
	public List<UserLevel> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<UserLevel> query = enma.createNamedQuery("UserLevel.findAll", UserLevel.class);

		return query.getResultList();

	}

	@Override
	public void update(UserLevel userLevel) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(userLevel);

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
	public UserLevel findById(int id) {

		EntityManager enma = JPAConfig.getEntityManager();

		UserLevel userLevel = enma.find(UserLevel.class, id);

		return userLevel;

	}

	@Override
	public void delete(int id) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			UserLevel storeLevel = enma.find(UserLevel.class, id);

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
	public void insert(UserLevel userLevel) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(userLevel);

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

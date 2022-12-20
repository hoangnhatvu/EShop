package hcmute.vn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.ICommissionDao;
import hcmute.vn.entity.Commission;

public class CommissionDaoImpl implements ICommissionDao {

	@Override
	public List<Commission> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Commission> query = enma.createNamedQuery("Commission.findAll", Commission.class);

		return query.getResultList();

	}

	@Override
	public void update(Commission commission) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(commission);

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
	public Commission findById(int id) {

		EntityManager enma = JPAConfig.getEntityManager();

		Commission commission = enma.find(Commission.class, id);

		return commission;

	}

	@Override
	public void delete(int id) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Commission commission = enma.find(Commission.class, id);

			if (commission != null) {

				enma.remove(commission);

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
	public void insert(Commission commission) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(commission);

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

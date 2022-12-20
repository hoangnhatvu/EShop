package hcmute.vn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IStyleDao;
import hcmute.vn.entity.Style;

public class StyleDaoImpl implements IStyleDao{
	
	
	@Override
	public List<Style> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Style> query = enma.createNamedQuery("Style.findAll", Style.class);

		return query.getResultList();

	}

	@Override
	public void update(Style style) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(style);

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
	public Style findById(int styleId) {

		EntityManager enma = JPAConfig.getEntityManager();

		Style style = enma.find(Style.class, styleId);

		return style;

	}

	
	@Override
	public void delete(int styleId) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Style style = enma.find(Style.class, styleId);

			if (style != null) {

				enma.remove(style);

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
	public void insert(Style style) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(style);

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

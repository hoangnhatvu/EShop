package hcmute.vn.dao.impl;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.entity.Category;

public class CategoryDaoImpl implements ICategoryDao{
	public List<Category> findAll() {

		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);

		return query.getResultList();

	}
	
	public Category findById(int categoryid) {
		EntityManager enma = JPAConfig.getEntityManager();

		Category category = enma.find(Category.class, categoryid);

		return category;
	}
=======

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.entity.Category;

public class CategoryDaoImpl implements ICategoryDao{


	@Override
	public List<Category> findAll()
	{
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);

		return query.getResultList();

	}


	@Override
	public void update(Category category) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(category);

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
	public Category findById(int categoryId) {

		EntityManager enma = JPAConfig.getEntityManager();

		Category category = enma.find(Category.class, categoryId);

		return category;

	}


	@Override
	public void delete(int categoryId) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Category category = enma.find(Category.class, categoryId);

			if (category != null) {

				enma.remove(category);

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
	public void insert(Category category) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(category);

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
    public int countProdByCateId(int cateId) {
        EntityManager enma = JPAConfig.getEntityManager();
        int count = (int) enma.createQuery("FROM Product P WHERE P.categoryId =: cateId").setParameter("cateId", cateId).getResultList().size();
        return count;
    }

>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
}

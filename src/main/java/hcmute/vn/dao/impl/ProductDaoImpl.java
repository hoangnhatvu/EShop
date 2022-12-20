package hcmute.vn.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IProductDao;
import hcmute.vn.entity.Product;

public class ProductDaoImpl implements IProductDao {
	public void create(Product product) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(product);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}
	
	public void update(Product product) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(product);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}
	
	public void delete(int productid) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Product product = enma.find(Product.class, productid);

			if (product != null) {

				enma.remove(product);

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
	
	public Product findByName(String name) {

		EntityManager enma = JPAConfig.getEntityManager();

		Product product = (Product)enma.createQuery("FROM Product O WHERE O.email = :name").setParameter("name", name).getSingleResult();				

		return product;
	}
	
	public Product findById(int productid) {
		EntityManager enma = JPAConfig.getEntityManager();

		Product product = enma.find(Product.class, productid);

		return product;
	}

}

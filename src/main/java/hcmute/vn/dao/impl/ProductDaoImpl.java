package hcmute.vn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IProductDao;
import hcmute.vn.entity.Product;





public class ProductDaoImpl implements IProductDao{
	
	@Override
	public List<Product> findAll()
	{
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);

		return query.getResultList();
		
	}
	
	@Override
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
	
	@Override
	public Product findById(int productId) {

		EntityManager enma = JPAConfig.getEntityManager();

		Product product = enma.find(Product.class, productId);

		return product;

	}
	
	@Override
	public void delete(int prodId) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Product product = enma.find(Product.class, prodId);

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
	
	@Override
	public void insert(Product product) {

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

}

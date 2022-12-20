package hcmute.vn.dao.impl;
<<<<<<< HEAD

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
=======
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IProductDao;
import hcmute.vn.entity.Product;

public class ProductDaoImpl implements IProductDao{
    @Override
    public List<Product> findProductByName(String searchString) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.name like :name and P.isSelling = true").setParameter("name", "%" + searchString + "%").getResultList();
        return products;
    }

    public Product findProductById(int prodId) {
        EntityManager enma = JPAConfig.getEntityManager();
        Product product = (Product) enma.createQuery("FROM Product P WHERE P.id = :prodId and P.isSelling = true").setParameter("prodId", prodId).getSingleResult();
        return product;
    }

    @Override
    public List<Product> findProductByStoreId(int storeId) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.store.id = :storeId and P.isSelling = true").setParameter("storeId", storeId).getResultList();
        return products;
    }

    public List<Product> findProductByCateId(int cateId, int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.categoryId = :cateId and P.isSelling = true ORDER BY P.name").setParameter("cateId", cateId).setFirstResult(page*pageSize).setMaxResults(pageSize).getResultList();
        return products;
    }

    @Override
    public List<Product> findAll(int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P ORDER BY P.name").setFirstResult(page*pageSize).setMaxResults(pageSize).getResultList();
        return products;
    }

    public List<Product> findRelatedProd(Product product) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.categoryId =: cateId and P.name like :name").setParameter("cateId", product.getCategoryId()).setParameter("name", "%"+product.getName().substring(0, 3)+"%").setMaxResults(4).getResultList();
        return products;
    }

    @Override
    public List<Product> findTrendyProd() {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.isSelling = true ORDER BY P.rating DESC").setMaxResults(8).getResultList();
        return products;
    }

    @Override
    public List<Product> findArrivalProd() {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.isSelling = true ORDER BY P.createAt DESC").setMaxResults(8).getResultList();
        return products;
    }

    @Override
    public List<Product> findTrendyProd(int storeId) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.store.id =: storeId and P.isSelling = true ORDER BY P.rating DESC").setParameter("storeId", storeId).setMaxResults(8).getResultList();
        return products;
    }

    @Override
    public List<Product> findArrivalProd(int storeId) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<Product> products = (List<Product>) enma.createQuery("FROM Product P WHERE P.store.id =: storeId and P.isSelling = true ORDER BY P.createAt DESC").setParameter("storeId", storeId).setMaxResults(8).getResultList();
        return products;
    }

    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        int count = ((Long) enma.createQuery("SELECT count(P) FROM Product P WHERE P.isSelling = true").getSingleResult()).intValue();
        return count;
    }
    @Override
    public int count(int cateId) {
        EntityManager enma = JPAConfig.getEntityManager();
        int count = ((Long) enma.createQuery("SELECT count(P) FROM Product P WHERE P.categoryId =:cateId and P.isSelling = true").setParameter("cateId", cateId).getSingleResult()).intValue();
        return count;
    }
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

>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
	}

}

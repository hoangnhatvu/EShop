package hcmute.vn.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IUserDao;
import hcmute.vn.entity.*;

import java.util.List;
import hcmute.vn.entity.Product;
import hcmute.vn.entity.Users;

public class UserDaoImpl implements IUserDao {
	
	public void createAccount(Users user) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(user);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}
	
	public void update(Users user) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(user);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}
	
	public void delete(int userid) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Users user = enma.find(Users.class, userid);

			if (user != null) {

				enma.remove(user);

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
	
	public Users findByEmail(String email) {
		Users user = null;
		try {
			EntityManager enma = JPAConfig.getEntityManager();
			user = (Users)enma.createQuery("FROM Users U WHERE U.email = :email").setParameter("email", email).getSingleResult();
			return user;
		} catch (NoResultException e){
			e.printStackTrace();
		}
		finally {
			return user;
		}
	}

	@Override
	public List<Users> findUsersByName(String searchString) {
		EntityManager enma = JPAConfig.getEntityManager();
		List<Users> users = (List<Users>) enma.createQuery("FROM Users U WHERE U.firstName like :name or U.lastName like :name").setParameter("name", "%" + searchString + "%").getResultList();
		return users;
	}

	public Users findById(int userid) {
		Users user = null;
		try {
			EntityManager enma = JPAConfig.getEntityManager();
			user = enma.find(Users.class, userid);
			return user;
		} catch (NoResultException e){
			e.printStackTrace();
		}
		finally {
			return user;
		}
	}

	@Override
	public List<Users> findAll()
	{
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Users> query = enma.createNamedQuery("Users.findAll", Users.class);

		return query.getResultList();

	}

	@Override
	public void update(Users user) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(user);

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
	public void insert(Users user) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(user);

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
	public void delete(int userId) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Users user = enma.find(Users.class, userId);

			if (user != null) {

				enma.remove(user);

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

}

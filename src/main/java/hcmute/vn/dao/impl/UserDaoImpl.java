package hcmute.vn.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IUserDao;
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
	
	public Users findByEmail(String email) {

		EntityManager enma = JPAConfig.getEntityManager();

		Users user = (Users)enma.createQuery("FROM Users U WHERE U.email = :email").setParameter("email", email).getSingleResult();				

		return user;
	}
	
	public Users findById(int userid) {
		EntityManager enma = JPAConfig.getEntityManager();

		Users user = enma.find(Users.class, userid);

		return user;
	}

}

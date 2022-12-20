package hcmute.vn.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.IStaffDao;
import hcmute.vn.entity.Staffs;

public class StaffDaoImpl implements IStaffDao {
	public void createStaff(Staffs staff) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(staff);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}
	
	public Staffs findById(int staffId) {
		EntityManager enma = JPAConfig.getEntityManager();

		Staffs staff = enma.find(Staffs.class, staffId);

		return staff;
	}

}

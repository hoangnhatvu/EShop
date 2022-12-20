package hcmute.vn.service.impl;

import hcmute.vn.dao.IStaffDao;
import hcmute.vn.dao.impl.StaffDaoImpl;
import hcmute.vn.entity.Staffs;
import hcmute.vn.service.IStaffService;

public class StaffServiceImpl implements IStaffService {
	IStaffDao staffDao = new StaffDaoImpl();
	
	@Override
	public void createStaff(Staffs staff) {
		staffDao.createStaff(staff);		
	}
	
	@Override
	public Staffs findById(int staffId) {
		return staffDao.findById(staffId);
	}
}

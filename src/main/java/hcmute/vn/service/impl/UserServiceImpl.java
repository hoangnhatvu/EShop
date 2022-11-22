package hcmute.vn.service.impl;

import hcmute.vn.dao.IUserDao;
import hcmute.vn.dao.impl.UserDaoImpl;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public void createAccount(Users user) {
		userDao.createAccount(user);		
	}
	
	@Override
	public Users findByEmail(String email) {
		return userDao.findByEmail(email);
	}
}

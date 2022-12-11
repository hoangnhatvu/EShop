package hcmute.vn.service.impl;

import hcmute.vn.dao.IUserDao;
import hcmute.vn.dao.impl.UserDaoImpl;
import hcmute.vn.entity.UserFollowProduct;
import hcmute.vn.entity.UserFollowStore;
import hcmute.vn.entity.Users;
import hcmute.vn.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService{
	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public void createAccount(Users user) {
		userDao.createAccount(user);		
	}



	@Override
	public void update(Users user) {
		userDao.update(user);
	}

	@Override
	public Users findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<Users> findUsersByName(String searchString) {
		return userDao.findUsersByName(searchString);
	}

	@Override
	public Users findById(int userid) {
		return userDao.findById(userid);
	}
}

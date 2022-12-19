package hcmute.vn.service.impl;

import java.util.List;

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
	
	@Override
	public Users findById(int userid) {
		return userDao.findById(userid);
	}
	
	@Override
	public List<Users> findAll()
	{
		return userDao.findAll();
	}
	
	@Override
	public void update(Users user)
	{
		 userDao.update(user);
	}
	
	@Override
	public void insert(Users user)
	{
		userDao.update(user);
	}
	
	@Override
	public void delete(int userId) throws Exception
	{
		userDao.delete(userId);
	}
	
}

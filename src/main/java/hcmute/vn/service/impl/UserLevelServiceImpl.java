package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.IUserLevelDao;
import hcmute.vn.dao.impl.UserLevelDaoImpl;
import hcmute.vn.entity.UserLevel;
import hcmute.vn.service.IUserLevelService;

public class UserLevelServiceImpl implements IUserLevelService {

	IUserLevelDao userLevelDao = new UserLevelDaoImpl();

	@Override
	public UserLevel findById(int id) {
		return userLevelDao.findById(id);
	}

	@Override
	public List<UserLevel> findAll() {
		return userLevelDao.findAll();
	}

	@Override
	public void update(UserLevel userLevel) {
		userLevelDao.update(userLevel);
	}

	@Override
	public void insert(UserLevel userLevel) {
		userLevelDao.update(userLevel);
	}

	@Override
	public void delete(int id) throws Exception {
		userLevelDao.delete(id);
	}

}

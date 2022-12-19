package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.UserLevel;

public interface IUserLevelService {

	void delete(int id) throws Exception;

	void insert(UserLevel userLevel);

	void update(UserLevel userLevel);

	List<UserLevel> findAll();

	UserLevel findById(int id);

}

package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.UserLevel;

public interface IUserLevelDao {

	void insert(UserLevel userLevel);

	void delete(int id) throws Exception;

	UserLevel findById(int id);

	void update(UserLevel userLevel);

	List<UserLevel> findAll();

}

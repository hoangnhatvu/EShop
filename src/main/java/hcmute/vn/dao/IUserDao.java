package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Users;

public interface IUserDao {
	public void createAccount(Users user);
	public Users findByEmail(String email);
	public Users findById(int userid);
	List<Users> findAll();
	void update(Users user);
	void insert(Users user);
	void delete(int userId) throws Exception;
}

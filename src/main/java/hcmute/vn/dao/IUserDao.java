package hcmute.vn.dao;

import hcmute.vn.entity.Users;

public interface IUserDao {
	public void createAccount(Users user);
	public void update(Users user);
	public Users findByEmail(String email);
	public Users findById(int userid);
	void delete(int userid) throws Exception;
}

package hcmute.vn.dao;

import hcmute.vn.entity.Users;

public interface IUserDao {
	public void createAccount(Users user);
	public Users findByEmail(String email);
	public Users findById(int userid);
}

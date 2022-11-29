package hcmute.vn.service;

import hcmute.vn.entity.Users;

public interface IUserService {
	public void createAccount(Users user);
	public Users findByEmail(String email);
	public Users findById(int userid);
}

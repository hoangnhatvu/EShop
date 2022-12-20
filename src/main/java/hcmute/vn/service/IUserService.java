package hcmute.vn.service;

import hcmute.vn.entity.Users;

public interface IUserService {
	public void createAccount(Users user);
	public void update(Users user);
	public void delete(int userid) throws Exception;
	public Users findByEmail(String email);
	public Users findById(int userid);
}

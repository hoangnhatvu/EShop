package hcmute.vn.dao;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Users;

import java.util.List;

public interface IUserDao {
	public void createAccount(Users user);
	public Users findByEmail(String email);
	public List<Users> findUsersByName(String searchString);

}

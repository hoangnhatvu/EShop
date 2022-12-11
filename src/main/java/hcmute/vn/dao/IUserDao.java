package hcmute.vn.dao;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.UserFollowProduct;
import hcmute.vn.entity.UserFollowStore;
import hcmute.vn.entity.Users;

import java.util.List;

public interface IUserDao {
	public void createAccount(Users user);

	public void update(Users user);
	public Users findByEmail(String email);
	public List<Users> findUsersByName(String searchString);
	public Users findById(int userid);
}

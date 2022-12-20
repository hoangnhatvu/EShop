package hcmute.vn.service;
import hcmute.vn.entity.Users;
import java.util.List;

public interface IUserService {
	public void createAccount(Users user);
	public void update(Users user);
	public void delete(int userid) throws Exception;
	public Users findByEmail(String email);
	public List<Users> findUsersByName(String searchString);
	public Users findById(int userid);
	List<Users> findAll();
	void update(Users user);
	void insert(Users user);
	void delete(int userId) throws Exception;
}

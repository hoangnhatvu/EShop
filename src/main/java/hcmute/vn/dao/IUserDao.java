package hcmute.vn.dao;
import hcmute.vn.entity.Users;
import java.util.List;

public interface IUserDao {
	public void createAccount(Users user);
	public Users findByEmail(String email);
	public List<Users> findUsersByName(String searchString);
	public Users findById(int userid);
	List<Users> findAll();
	void update(Users user);
	void insert(Users user);
	void delete(int userId) throws Exception;
}

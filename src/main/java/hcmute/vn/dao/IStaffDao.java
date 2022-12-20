package hcmute.vn.dao;
import hcmute.vn.entity.Staffs;

public interface IStaffDao {
	public void createStaff(Staffs staff);
	public Staffs findById(int staffId);
}
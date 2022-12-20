package hcmute.vn.service;
import hcmute.vn.entity.Staffs;

public interface IStaffService {
	public void createStaff(Staffs staff);
	public Staffs findById(int staffId);
}

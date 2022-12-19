package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Commission;

public interface ICommissionDao {

	void insert(Commission commission);

	void delete(int id) throws Exception;

	Commission findById(int id);

	void update(Commission commission);

	List<Commission> findAll();

}

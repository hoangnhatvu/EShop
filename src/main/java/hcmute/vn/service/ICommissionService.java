package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Commission;

public interface ICommissionService {

	void insert(Commission commission);

	void delete(int id) throws Exception;

	Commission findbyId(int id);

	void update(Commission commission);

	List<Commission> findAll();

}

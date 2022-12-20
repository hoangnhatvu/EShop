package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.StoreLevel;

public interface IStoreLevelDao {

	void insert(StoreLevel storeLevel);

	void delete(int id) throws Exception;

	StoreLevel findById(int id);

	void update(StoreLevel storeLevel);

	List<StoreLevel> findAll();

}

package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Store;

public interface IStoreDao {
	public void insert(Store store);
	public List<Store> findAll();
	void delete(int storeId) throws Exception;
	void update(Store store);
	Store findById(int storeId);
}

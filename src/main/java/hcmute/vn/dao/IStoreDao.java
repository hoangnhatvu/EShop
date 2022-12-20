package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Store;

public interface IStoreDao {
	public void insert(Store store);
	public List<Store> findAll();
	public Store findById(int storeid);
	public void update(Store store);
	public List<Store> findByName(String name);
	void delete(int storeid) throws Exception;
}

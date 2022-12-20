package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Store;

public interface IStoreDao {
	public void insert(Store store);
	public List<Store> findAll();
	public List<Store> findTopVendor();

	List<Store> findStoresByName(String searchString);
	public Store findStoresById(int id);
}

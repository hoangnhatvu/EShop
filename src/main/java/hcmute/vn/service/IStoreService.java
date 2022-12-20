package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Store;

public interface IStoreService {
	public void insert(Store store);
	public List<Store> findAll();
	public Store findById(int storeid);
	public void update(Store store);
	public void delete(int storeid) throws Exception;
	public List<Store> findByName(String name);
}

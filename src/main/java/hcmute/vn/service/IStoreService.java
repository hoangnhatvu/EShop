package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Store;

public interface IStoreService {
	public void insert(Store store);
	public List<Store> findAll();
}

package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.IStoreDao;
import hcmute.vn.dao.impl.StoreDaoImpl;
import hcmute.vn.entity.Store;
import hcmute.vn.service.IStoreService;

public class StoreServiceImpl implements IStoreService{
	
	IStoreDao storeDao = new StoreDaoImpl();
	
	@Override
	public void insert(Store store) {
		storeDao.insert(store);
	}
	
	@Override
	public List<Store> findAll() {
		return storeDao.findAll();
	}
}

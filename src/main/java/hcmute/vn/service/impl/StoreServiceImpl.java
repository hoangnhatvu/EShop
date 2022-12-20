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
	
	@Override
	public Store findById(int storeid) {
		return storeDao.findById(storeid);
	}
	
	@Override
	public void update(Store store) {
		storeDao.update(store);		
	}
	
	@Override
	public void delete(int storeid) throws Exception {

		storeDao.delete(storeid);
	}
	
	@Override
	public List<Store> findByName(String name) {
		return storeDao.findByName(name);
	}
}

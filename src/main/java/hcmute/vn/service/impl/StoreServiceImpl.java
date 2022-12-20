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
	public List<Store> findStoresByName(String searchString) {
		return storeDao.findStoresByName(searchString);
	}

	@Override
	public Store findStoresById(int id) {
		return storeDao.findStoresById(id);
	}

	@Override
	public List<Store> findAll() {
		return storeDao.findAll();
	}

	@Override
	public List<Store> findTopVendor() {
		return storeDao.findTopVendor();
	}
	@Override
	public Store findbyId(int storeId)
	{
		return storeDao.findById(storeId);
	}
	@Override
	public void update(Store store)
	{
		storeDao.update(store);
	}
	@Override
	public void delete(int storeId) throws Exception
	{
		storeDao.delete(storeId);
	}
}

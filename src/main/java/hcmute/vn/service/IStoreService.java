package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Store;

public interface IStoreService {
	public void insert(Store store);
	public List<Store> findAll();
<<<<<<< HEAD
	public Store findById(int storeid);
	public void update(Store store);
	public void delete(int storeid) throws Exception;
	public List<Store> findByName(String name);
=======
	public List<Store> findTopVendor();

	public List<Store> findStoresByName(String searchString);
	public Store findStoresById(int id);
	void delete(int storeId) throws Exception;
	void update(Store store);
	Store findbyId(int storeId);
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
}

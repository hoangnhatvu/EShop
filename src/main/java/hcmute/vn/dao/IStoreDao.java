package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Store;

public interface IStoreDao {
	public void insert(Store store);
	public List<Store> findAll();
<<<<<<< HEAD
	public Store findById(int storeid);
	public void update(Store store);
	public List<Store> findByName(String name);
	void delete(int storeid) throws Exception;
=======
	public List<Store> findTopVendor();
	List<Store> findStoresByName(String searchString);
	public Store findStoresById(int id);
	void delete(int storeId) throws Exception;
	void update(Store store);
	Store findById(int storeId);
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
}

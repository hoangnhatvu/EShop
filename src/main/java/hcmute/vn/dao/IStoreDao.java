package hcmute.vn.dao;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Store;

import java.util.List;

public interface IStoreDao {
	public void insert(Store store);
	public List<Store> findStoresByName(String searchString);

}

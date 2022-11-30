package hcmute.vn.service;

import hcmute.vn.entity.Product;
import hcmute.vn.entity.Store;

import java.util.List;

public interface IStoreService {
	public void insert(Store store);
	public List<Store> findStoresByName(String searchString);

}

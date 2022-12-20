package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.StoreLevel;

public interface IStoreLevelService {

	void insert(StoreLevel storeLevel);

	void delete(int storeLevelId) throws Exception;

	StoreLevel findbyId(int storeLevelId);

	void update(StoreLevel storeLevel);

	List<StoreLevel> findAll();

}

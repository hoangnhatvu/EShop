package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.IStoreLevelDao;
import hcmute.vn.dao.impl.StoreLevelDaoImpl;
import hcmute.vn.entity.StoreLevel;
import hcmute.vn.service.IStoreLevelService;

public class StoreLevelServiceImpl implements IStoreLevelService {

	IStoreLevelDao storeLevelDao = new StoreLevelDaoImpl();

	@Override
	public List<StoreLevel> findAll() {
		return storeLevelDao.findAll();
	}

	@Override
	public void update(StoreLevel storeLevel) {
		storeLevelDao.update(storeLevel);
	}

	
	@Override
	public StoreLevel findbyId(int storeLevelId) {
		return storeLevelDao.findById(storeLevelId);
	}

	
	@Override
	public void delete(int storeLevelId) throws Exception {
		storeLevelDao.delete(storeLevelId);
	}

	
	@Override
	public void insert(StoreLevel storeLevel) {
		storeLevelDao.insert(storeLevel);
	}

}

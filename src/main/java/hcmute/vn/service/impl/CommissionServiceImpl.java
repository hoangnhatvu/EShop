package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.ICommissionDao;
import hcmute.vn.dao.impl.CommissionDaoImpl;
import hcmute.vn.entity.Commission;
import hcmute.vn.service.ICommissionService;

public class CommissionServiceImpl implements ICommissionService {

	ICommissionDao commissionDao = new CommissionDaoImpl();

	@Override
	public List<Commission> findAll() {
		return commissionDao.findAll();
	}

	@Override
	public void update(Commission commission) {
		commissionDao.update(commission);
	}

	@Override
	public Commission findbyId(int id) {
		return commissionDao.findById(id);
	}

	@Override
	public void delete(int id) throws Exception {
		commissionDao.delete(id);
	}

	@Override
	public void insert(Commission commission) {
		commissionDao.insert(commission);
	}

}

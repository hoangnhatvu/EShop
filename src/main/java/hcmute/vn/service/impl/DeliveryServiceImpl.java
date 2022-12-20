package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.IDeliveryDao;
import hcmute.vn.dao.impl.DeliveryDaoImpl;
import hcmute.vn.entity.Delivery;
import hcmute.vn.service.IDeliveryService;

public class DeliveryServiceImpl implements IDeliveryService {

	IDeliveryDao deliveryDao = new DeliveryDaoImpl();

	@Override
	public List<Delivery> findAll() {
		return deliveryDao.findAll();
	}

	@Override
	public void update(Delivery delivery) {
		deliveryDao.update(delivery);
	}

	@Override
	public Delivery findbyId(int deliveryId) {
		return deliveryDao.findById(deliveryId);
	}

	@Override
	public void delete(int deliveryId) throws Exception {
		deliveryDao.delete(deliveryId);
	}

	@Override
	public void insert(Delivery delivery) {
		deliveryDao.insert(delivery);
	}

}

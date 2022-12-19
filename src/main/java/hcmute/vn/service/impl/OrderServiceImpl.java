package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.IOrderDao;
import hcmute.vn.dao.impl.OrderDaoImpl;
import hcmute.vn.entity.Orders;
import hcmute.vn.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	IOrderDao orderDao = new OrderDaoImpl();

	@Override
	public List<Orders> findAll() {
		return orderDao.findAll();
	}

	@Override
	public void update(Orders order) {
		orderDao.update(order);
	}

	@Override
	public Orders findbyId(int id) {
		return orderDao.findById(id);
	}
	
	
	@Override
	public void insert(Orders order)
	{
		orderDao.insert(order);
	}

}

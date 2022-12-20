package hcmute.vn.service.impl;

import hcmute.vn.dao.IOrderDao;
import hcmute.vn.dao.impl.OrderDaoImpl;
import hcmute.vn.entity.Orders;
import hcmute.vn.service.IOrderService;

public class OrderServiceImpl implements IOrderService{
	IOrderDao orderDao = new OrderDaoImpl();
	
	@Override
	public void update(Orders order) {
		orderDao.update(order);		
	}
	
	@Override
	public void delete(int orderid) throws Exception {
		orderDao.delete(orderid);
	}
	
	@Override
	public Orders findById(int orderid) {
		return orderDao.findById(orderid);
	}
}

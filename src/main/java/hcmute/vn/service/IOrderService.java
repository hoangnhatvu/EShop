package hcmute.vn.service;

import hcmute.vn.entity.Orders;

public interface IOrderService {
	public void update(Orders order);
	public Orders findById(int orderid);
	public void delete(int orderid) throws Exception;

}

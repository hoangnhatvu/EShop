package hcmute.vn.dao;

import hcmute.vn.entity.Orders;

public interface IOrderDao {
	public void update(Orders order);
	public Orders findById(int orderid);
	void delete(int orderid) throws Exception;

}

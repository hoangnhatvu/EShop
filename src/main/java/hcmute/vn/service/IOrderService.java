package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Orders;

public interface IOrderService {

	void insert(Orders order);

	Orders findbyId(int id);

	void update(Orders order);

	List<Orders> findAll();

}

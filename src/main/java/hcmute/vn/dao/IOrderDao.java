package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Orders;

public interface IOrderDao {

	Orders findById(int id);

	void update(Orders order);

	List<Orders> findAll();

	void insert(Orders order);

}

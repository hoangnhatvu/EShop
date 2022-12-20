package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Delivery;

public interface IDeliveryDao {

	void insert(Delivery delivery);

	void delete(int deliveryId) throws Exception;

	Delivery findById(int deliveryId);

	void update(Delivery delivery);

	List<Delivery> findAll();

}

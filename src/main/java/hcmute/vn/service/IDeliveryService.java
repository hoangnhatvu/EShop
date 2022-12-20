package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Delivery;

public interface IDeliveryService {

	void insert(Delivery delivery);

	void delete(int deliveryId) throws Exception;

	Delivery findbyId(int deliveryId);

	void update(Delivery delivery);

	List<Delivery> findAll();

}

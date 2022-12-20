package hcmute.vn.service.impl;
import java.util.List;
import hcmute.vn.dao.IOrderDao;
import hcmute.vn.dao.impl.OrderDaoImpl;
import hcmute.vn.entity.Commission;
import hcmute.vn.entity.Delivery;
import hcmute.vn.entity.Orders;
import hcmute.vn.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	IOrderDao orderDao = new OrderDaoImpl();

	@Override
	public List<Orders> findAll() {
		return orderDao.findAll();
	}
    @Override
    public Orders findbyId(int id) {
        return orderDao.findbyId(id);
    }

    @Override
    public List<Orders> findbyUserId(int id) {
        return orderDao.findbyUserId(id);
    }
    public List<Commission> findCommision() {return orderDao.findCommision();}
    public List<Delivery> findDelivery() {return orderDao.findDelivery();}

    public Commission findCommisionById(int id) {return orderDao.findCommisionById(id);}

    public Delivery findDeliveryById(int id) {return  orderDao.findDeliveryById(id);}

    @Override
    public void insert(Orders order) {
        orderDao.insert(order);
    }

    @Override
    public void update(Orders order) {
        orderDao.update(order);
    }

    @Override
    public void delete(Orders order) throws Exception {
        orderDao.delete(order);
    }

}

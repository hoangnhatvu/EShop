package hcmute.vn.service.impl;

import hcmute.vn.dao.IOrderItemDao;
import hcmute.vn.dao.impl.OrderItemDaoImpl;
import hcmute.vn.entity.OrderItem;
import hcmute.vn.entity.Orders;
import hcmute.vn.entity.Store;
import hcmute.vn.service.IOrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements IOrderItemService {
    IOrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public void insert(OrderItem orderItem) {
        orderItemDao.insert(orderItem);
    }

    @Override
    public void delete(OrderItem orderItem) throws Exception {
        orderItemDao.delete(orderItem);
    }

    @Override
    public OrderItem findById(int id) {
        return orderItemDao.findById(id);
    }

    @Override
    public List<OrderItem> findByOrder(Orders orders) {
        return orderItemDao.findByOrder(orders);
    }

    @Override
    public List<OrderItem> findByStore(Store store) {
        return orderItemDao.findByStore(store);
    }
}

package hcmute.vn.service;

import hcmute.vn.entity.OrderItem;
import hcmute.vn.entity.Orders;
import hcmute.vn.entity.Store;

import java.util.List;

public interface IOrderItemService {
    public void insert(OrderItem orderItem);
    public void delete(OrderItem orderItem) throws Exception;
    public OrderItem findById(int id);
    public List<OrderItem> findByOrder (Orders orders);
    public List<OrderItem> findByStore (Store store);
}

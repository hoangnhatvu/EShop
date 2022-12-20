package hcmute.vn.dao;

<<<<<<< HEAD
import hcmute.vn.entity.Orders;

public interface IOrderDao {
	public void update(Orders order);
	public Orders findById(int orderid);
	void delete(int orderid) throws Exception;
=======
import hcmute.vn.entity.Commission;
import hcmute.vn.entity.Delivery;
import hcmute.vn.entity.Orders;
import java.util.List;

public interface IOrderDao {
    public Orders findbyId (int id);
    public List<Orders> findbyUserId (int id);
    public List<Commission> findCommision();
    public List<Delivery> findDelivery();
    public Commission findCommisionById(int id);
    public Delivery findDeliveryById(int id);
    public void insert (Orders order);
    public void update (Orders order);
    public void delete (Orders order) throws Exception;
	List<Orders> findAll();
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git

}

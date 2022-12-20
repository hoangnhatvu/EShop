package hcmute.vn.entity;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
=======
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Orders", schema = "dbo", catalog = "EShop")
@NamedQuery(name = "Orders.findAll", query = "SELECT d FROM Orders d")
public class Orders implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Commission commission;
	private Delivery delivery;
	private Store store;
	private Users users;
	private String address;
<<<<<<< HEAD
	private Integer phone;
	private Boolean status;
=======
	private int phone;
	private String status;
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
	private Boolean idPaidBefore;
<<<<<<< HEAD
	private Integer amountFromUser;
	private Integer amountFromStore;
	private Integer amountToStore;
	private Integer amountToGd;
=======
	private int amountFromUser;
	private int amountFromStore;
	private int amountToStore;
	private int amountToGd;
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
	private Date createAt;
	private Date updateAt;
<<<<<<< HEAD
	private List<OrderItem> orderItems;
=======
	private List<OrderItem> orderItems = new ArrayList<>();
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git

	public Orders() {
		this.status = "not precessed";
		this.createAt = new Date();
	}

<<<<<<< HEAD
	public Orders(Commission commission, Delivery delivery, Store store, Users users, String address, Integer phone,
			Boolean status, Integer amountFromUser, Integer amountFromStore, Integer amountToStore,
			Integer amountToGd) {
=======
	public Orders(Commission commission, Delivery delivery, Store store, Users users, String address, int phone,
			String status, int amountFromUser, int amountFromStore, int amountToStore,
			int amountToGd) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.commission = commission;
		this.delivery = delivery;
		this.store = store;
		this.users = users;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.amountFromUser = amountFromUser;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToGd = amountToGd;
	}

<<<<<<< HEAD
	public Orders(Commission commission, Delivery delivery, Store store, Users users, String address, Integer phone,
			Boolean status, Boolean idPaidBefore, Integer amountFromUser, Integer amountFromStore,
			Integer amountToStore, Integer amountToGd, Date createAt, Date updateAt, List<OrderItem> orderItems) {
=======
	public Orders(Commission commission, Delivery delivery, Users users, String address, int phone, int amountFromUser) {
		this.commission = commission;
		this.delivery = delivery;
		this.users = users;
		this.address = address;
		this.phone = phone;
		this.amountFromUser = amountFromUser;
		this.status = "not precessed";
		this.createAt = new Date();
	}

	public Orders(Commission commission, Delivery delivery, Store store, Users users, String address, int phone,
			String status, Boolean idPaidBefore, int amountFromUser, int amountFromStore,
			int amountToStore, int amountToGd, Date createAt, Date updateAt, List<OrderItem> orderItems) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.commission = commission;
		this.delivery = delivery;
		this.store = store;
		this.users = users;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.idPaidBefore = idPaidBefore;
		this.amountFromUser = amountFromUser;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToGd = amountToGd;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.orderItems = orderItems;
	}

	public Orders(Commission commission, Delivery delivery, Users users, String address, int phone,
				  String status, Boolean idPaidBefore, int amountFromUser, List<OrderItem> orderItems) {
		this.commission = commission;
		this.delivery = delivery;
		this.users = users;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.idPaidBefore = idPaidBefore;
		this.amountFromUser = amountFromUser;
		this.updateAt = new Date();
		this.orderItems = orderItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commission_id", nullable = false)
	public Commission getCommission() {
		return this.commission;
	}

	public void setCommission(Commission commission) {
		this.commission = commission;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delivere_id", nullable = false)
	public Delivery getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone", nullable = false)
	public int getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@Column(name = "status", nullable = false)
<<<<<<< HEAD
	public Boolean getStatus() {
=======
	public String getStatus() {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		return this.status;
	}

<<<<<<< HEAD
	public void setStatus(Boolean status) {
=======
	public void setStatus(String status) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.status = status;
	}

	@Column(name = "id_paidBefore")
	public Boolean getIdPaidBefore() {
		return this.idPaidBefore;
	}

	public void setIdPaidBefore(Boolean idPaidBefore) {
		this.idPaidBefore = idPaidBefore;
	}

	@Column(name = "amountFromUser", nullable = false, precision = 5)
<<<<<<< HEAD
	public Integer getAmountFromUser() {
=======
	public int getAmountFromUser() {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		return this.amountFromUser;
	}

<<<<<<< HEAD
	public void setAmountFromUser(Integer amountFromUser) {
=======
	public void setAmountFromUser(int amountFromUser) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.amountFromUser = amountFromUser;
	}

	@Column(name = "amountFromStore", nullable = false, precision = 5)
<<<<<<< HEAD
	public Integer getAmountFromStore() {
=======
	public int getAmountFromStore() {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		return this.amountFromStore;
	}

<<<<<<< HEAD
	public void setAmountFromStore(Integer amountFromStore) {
=======
	public void setAmountFromStore(int amountFromStore) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.amountFromStore = amountFromStore;
	}

	@Column(name = "amountToStore", nullable = false, precision = 5)
<<<<<<< HEAD
	public Integer getAmountToStore() {
=======
	public int getAmountToStore() {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		return this.amountToStore;
	}

<<<<<<< HEAD
	public void setAmountToStore(Integer amountToStore) {
=======
	public void setAmountToStore(int amountToStore) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.amountToStore = amountToStore;
	}

	@Column(name = "amountToGD", nullable = false, precision = 5)
<<<<<<< HEAD
	public Integer getAmountToGd() {
=======
	public int getAmountToGd() {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		return this.amountToGd;
	}

<<<<<<< HEAD
	public void setAmountToGd(Integer amountToGd) {
=======
	public void setAmountToGd(int amountToGd) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.amountToGd = amountToGd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createAt", length = 10)
	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updateAt", length = 10)
	public Date getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

<<<<<<< HEAD
	@OneToMany(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "orders")
=======
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public OrderItem addOrderItem(OrderItem orderItem) {
		getOrderItems().add(orderItem);
		orderItem.setOrders(this);
		return orderItem;
	}
	public OrderItem removeOrderItem(OrderItem orderItem) {
		getOrderItems().remove(orderItem);
		orderItem.setOrders(null);
		return orderItem;
	}
}

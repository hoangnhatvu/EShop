package hcmute.vn.entity;
// Generated Nov 17, 2022, 12:16:28 AM by Hibernate Tools 4.3.6.Final

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name = "Orders", schema = "dbo", catalog = "EShop")
@NamedQuery(name = "Orders.findAll", query = "SELECT d FROM Orders d")
public class Orders implements java.io.Serializable {

	private Integer id;
	private Commission commission;
	private Delivery delivery;
	private Store store;
	private Users users;
	private String address;
	private int phone;
	private String status;
	private Boolean idPaidBefore;
	private BigDecimal amountFromUser;
	private BigDecimal amountFromStore;
	private BigDecimal amountToStore;
	private BigDecimal amountToGd;
	private Date createAt;
	private Date updateAt;
	private List<OrderItem> orderItems = new ArrayList<>();

	public Orders() {
		this.status = "not precessed";
		this.createAt = new Date();
	}

	public Orders(Commission commission, Delivery delivery, Store store, Users users, String address, int phone,
			String status, BigDecimal amountFromUser, BigDecimal amountFromStore, BigDecimal amountToStore,
			BigDecimal amountToGd) {
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

	public Orders(Commission commission, Delivery delivery, Users users, String address, int phone, BigDecimal amountFromUser) {
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
			String status, Boolean idPaidBefore, BigDecimal amountFromUser, BigDecimal amountFromStore,
			BigDecimal amountToStore, BigDecimal amountToGd, Date createAt, Date updateAt, List<OrderItem> orderItems) {
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
				  String status, Boolean idPaidBefore, BigDecimal amountFromUser, List<OrderItem> orderItems) {
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

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
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
	public BigDecimal getAmountFromUser() {
		return this.amountFromUser;
	}

	public void setAmountFromUser(BigDecimal amountFromUser) {
		this.amountFromUser = amountFromUser;
	}

	@Column(name = "amountFromStore", nullable = false, precision = 5)
	public BigDecimal getAmountFromStore() {
		return this.amountFromStore;
	}

	public void setAmountFromStore(BigDecimal amountFromStore) {
		this.amountFromStore = amountFromStore;
	}

	@Column(name = "amountToStore", nullable = false, precision = 5)
	public BigDecimal getAmountToStore() {
		return this.amountToStore;
	}

	public void setAmountToStore(BigDecimal amountToStore) {
		this.amountToStore = amountToStore;
	}

	@Column(name = "amountToGD", nullable = false, precision = 5)
	public BigDecimal getAmountToGd() {
		return this.amountToGd;
	}

	public void setAmountToGd(BigDecimal amountToGd) {
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
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

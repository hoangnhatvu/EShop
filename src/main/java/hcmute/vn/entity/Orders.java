package hcmute.vn.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders", schema = "dbo", catalog = "EShop")
public class Orders implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Commission commission;
	private Delivery delivery;
	private Store store;
	private Users users;
	private String address;
	private Integer phone;
	private Boolean status;
	private Boolean idPaidBefore;
	private Integer amountFromUser;
	private Integer amountFromStore;
	private Integer amountToStore;
	private Integer amountToGd;
	private Date createAt;
	private Date updateAt;
	private List<OrderItem> orderItems;

	public Orders() {
	}

	public Orders(Commission commission, Delivery delivery, Store store, Users users, String address, Integer phone,
			Boolean status, Integer amountFromUser, Integer amountFromStore, Integer amountToStore,
			Integer amountToGd) {
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

	public Orders(Commission commission, Delivery delivery, Store store, Users users, String address, Integer phone,
			Boolean status, Boolean idPaidBefore, Integer amountFromUser, Integer amountFromStore,
			Integer amountToStore, Integer amountToGd, Date createAt, Date updateAt, List<OrderItem> orderItems) {
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
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
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
	public Integer getAmountFromUser() {
		return this.amountFromUser;
	}

	public void setAmountFromUser(Integer amountFromUser) {
		this.amountFromUser = amountFromUser;
	}

	@Column(name = "amountFromStore", nullable = false, precision = 5)
	public Integer getAmountFromStore() {
		return this.amountFromStore;
	}

	public void setAmountFromStore(Integer amountFromStore) {
		this.amountFromStore = amountFromStore;
	}

	@Column(name = "amountToStore", nullable = false, precision = 5)
	public Integer getAmountToStore() {
		return this.amountToStore;
	}

	public void setAmountToStore(Integer amountToStore) {
		this.amountToStore = amountToStore;
	}

	@Column(name = "amountToGD", nullable = false, precision = 5)
	public Integer getAmountToGd() {
		return this.amountToGd;
	}

	public void setAmountToGd(Integer amountToGd) {
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

	@OneToMany(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "orders")
	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}

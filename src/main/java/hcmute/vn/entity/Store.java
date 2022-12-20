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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Store", schema = "dbo", catalog = "EShop", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedQuery(name = "Store.findAll", query = "SELECT c FROM Store c")
public class Store implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Users users;
	private String name;
	private String bio;
	private Integer staffIds;
	private Boolean isActive;
	private Boolean isOpen;
	private String avatar;
	private Integer rating;
	private Integer EWallet;
	private Date createdAt;
	private Date updateAt;
	private List<UserFollowStore> userFollowStores;
	private List<Orders> orderses;
	private List<Product> products;
	private List<Cart> carts;
	private StoreLevel storeLevel;
	private List<Staffs> staffs;
	private List<Transactions> transactionses;

	public Store() {
		isOpen=true;
		rating = 0;
		createdAt = new Date();
		updateAt = new Date();		
	}

	public Store(Users users, String name, String bio) {
		this.users = users;
		this.name = name;
		this.bio = bio;
	}

	public Store(Users users, String name, String bio, Integer staffIds, Boolean isActive, Boolean isOpen,
			String avatar, Integer rating, Integer EWallet, Date createdAt, Date updateAt, List<Staffs> staffs,
			List<UserFollowStore> userFollowStores, List<Orders> orderses, List<Product> products, List<Cart> carts,
			StoreLevel storeLevel, List<Transactions> transactionses) {
		this.users = users;
		this.name = name;
		this.bio = bio;
		this.staffIds = staffIds;
		this.isActive = isActive;
		this.isOpen = isOpen;
		this.avatar = avatar;
		this.rating = rating;
		this.EWallet = EWallet;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.staffs = staffs;
		this.userFollowStores = userFollowStores;
		this.orderses = orderses;
		this.products = products;
		this.carts = carts;
		this.storeLevel = storeLevel;
		this.transactionses = transactionses;
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
	@JoinColumn(name = "ownerId", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "name", unique = true, nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "bio", nullable = false)
	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Column(name = "staffIds")
	public Integer getStaffIds() {
		return this.staffIds;
	}

	public void setStaffIds(Integer staffIds) {
		this.staffIds = staffIds;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "isOpen")
	public Boolean getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	@Column(name = "avatar", length = 100)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "rating")
	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Column(name = "e_wallet", precision = 10)
	public Integer getEWallet() {
		return this.EWallet;
	}

	public void setEWallet(Integer EWallet) {
		this.EWallet = EWallet;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdAt", length = 10)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updateAt", length = 10)
	public Date getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	public List<UserFollowStore> getUserFollowStores() {
		return this.userFollowStores;
	}
	
	public void setUserFollowStores(List<UserFollowStore> userFollowStores) {
		this.userFollowStores = userFollowStores;
	}
	
	@OneToMany(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "store")
	public List<Staffs> getStaffs() {
		return this.staffs;
	}	
	
	public void setStaffs(List<Staffs> staffs) {
		this.staffs = staffs;
	}
	
	@OneToMany(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "store")
	public List<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(List<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "store")
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "store")
	public StoreLevel getStoreLevel() {
		return this.storeLevel;
	}

	public void setStoreLevel(StoreLevel storeLevel) {
		this.storeLevel = storeLevel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	public List<Transactions> getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(List<Transactions> transactionses) {
		this.transactionses = transactionses;
	}
	
	public Staffs addStaff(Staffs staff) {

		getStaffs().add(staff);

		staff.setStore(this);

		return staff;

	}

	public Staffs removeStaff(Staffs staff) {

		getStaffs().remove(staff);

		staff.setStore(null);

		return staff;

	}
	
	public Product addProduct(Product product) {

		getProducts().add(product);

		product.setStore(this);

		return product;

	}

	public Product removeProduct(Product product) {

		getProducts().remove(product);

		product.setStore(null);

		return product;

	}
	
	public Orders addOrder(Orders order) {

		getOrderses().add(order);

		order.setStore(this);

		return order;

	}

	public Orders removeOrder(Orders order) {

		getOrderses().remove(order);

		order.setStore(null);

		return order;

	}

}

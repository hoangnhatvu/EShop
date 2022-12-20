package hcmute.vn.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ownerId", nullable = false)
	private Users users;
	@Column(name = "name", unique = true, nullable = false, length = 100)
	private String name;
	@Column(name = "bio", nullable = false)
	private String bio;
	@Column(name = "staffIds")
	private int staffIds;
	@Column(name = "isActive")
	private Boolean isActive;
	@Column(name = "isOpen")
	private Boolean isOpen;
	@Column(name = "avatar", length = 100)
	private String avatar;
	@Column(name = "rating")
	private int rating;
	@Column(name = "e_wallet", precision = 10)
	private BigDecimal EWallet;
	@Temporal(TemporalType.DATE)
	@Column(name = "createdAt", length = 10)
	private Date createdAt;
	@Temporal(TemporalType.DATE)
	@Column(name = "updateAt", length = 10)
	private Date updateAt;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	private List<UserFollowStore> userFollowStores;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	private List<Orders> orderses;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	private List<Product> products;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
	private List<Cart> carts;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "store")
	@JoinColumn(name = "storelevelId", nullable = true)
	private StoreLevel storeLevel;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
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

	public Store(Users users, String name, String bio, int staffIds, Boolean isActive, Boolean isOpen,
			String avatar, int rating, BigDecimal EWallet, Date createdAt, Date updateAt,
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
		this.userFollowStores = userFollowStores;
		this.orderses = orderses;
		this.products = products;
		this.carts = carts;
		this.storeLevel = storeLevel;
		this.transactionses = transactionses;
	}

	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getStaffIds() {
		return this.staffIds;
	}

	public void setStaffIds(int staffIds) {
		this.staffIds = staffIds;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public BigDecimal getEWallet() {
		return this.EWallet;
	}

	public void setEWallet(BigDecimal EWallet) {
		this.EWallet = EWallet;
	}

	
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	public Date getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	
	public List<UserFollowStore> getUserFollowStores() {
		return this.userFollowStores;
	}

	public void setUserFollowStores(List<UserFollowStore> userFollowStores) {
		this.userFollowStores = userFollowStores;
	}

	public List<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(List<Orders> orderses) {
		this.orderses = orderses;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public StoreLevel getStoreLevel() {
		return this.storeLevel;
	}

	public void setStoreLevel(StoreLevel storeLevel) {
		this.storeLevel = storeLevel;
	}

	public List<Transactions> getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(List<Transactions> transactionses) {
		this.transactionses = transactionses;
	}
	

}

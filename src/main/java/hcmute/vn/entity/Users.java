package hcmute.vn.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Users", schema = "dbo", catalog = "EShop", uniqueConstraints = { @UniqueConstraint(columnNames = "slug"),
		@UniqueConstraint(columnNames = "email") })
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String firstName;
	private String lastName;
	private String slug;
	private String idCard;
	private String email;
	private String phone;
	private Boolean isEmailActive;
	private Boolean isPhoneActive;
	private String hashedPassword;
	private Integer role;
	private String addresses;
	private String avatar;
	private String cover;
	private Integer point;
	private BigDecimal EWallet;
	private Date createAt;
	private Date updateAt;
	private List<Transactions> transactionses;
	private List<UserFollowProduct> userFollowProducts;
	private List<Cart> carts;
	private List<Orders> orderses;
	private List<Store> stores;
	private List<UserFollowStore> userFollowStores;
	private UserLevel userLevel;

	public Users() {
		isEmailActive = true;
		isPhoneActive = true;
		role = 3;
		point = 0;
		createAt = new Date();
		updateAt = new Date();
	}

	public Users(String firstName, String lastName, String hashedPassword) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hashedPassword = hashedPassword;
	}

	public Users(String firstName, String lastName, String slug, String idCard,
			String email, String phone, Boolean isEmailActive, Boolean isPhoneActive, String hashedPassword,
			Integer role, String addresses, String avatar, String cover, Integer point, BigDecimal EWallet,
			Date createAt, Date updateAt, List<Transactions> transactionses, List<UserFollowProduct> userFollowProducts,
			List<Cart> carts, List<Orders> orderses, List<Store> stores, List<UserFollowStore> userFollowStores,
			UserLevel userLevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.slug = slug;
		this.idCard = idCard;
		this.email = email;
		this.phone = phone;
		this.isEmailActive = isEmailActive;
		this.isPhoneActive = isPhoneActive;
		this.hashedPassword = hashedPassword;
		this.role = role;
		this.addresses = addresses;
		this.avatar = avatar;
		this.cover = cover;
		this.point = point;
		this.EWallet = EWallet;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.transactionses = transactionses;
		this.userFollowProducts = userFollowProducts;
		this.carts = carts;
		this.orderses = orderses;
		this.stores = stores;
		this.userFollowStores = userFollowStores;
		this.userLevel = userLevel;
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

	@Column(name = "firstName", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = false)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "slug", unique = true)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "id_card")
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Email(message = "Email không hợp lệ")
	@NotEmpty
	@Column(name = "email", unique = true)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 30)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "isEmailActive")
	public Boolean getIsEmailActive() {
		return this.isEmailActive;
	}

	public void setIsEmailActive(Boolean isEmailActive) {
		this.isEmailActive = isEmailActive;
	}

	@Column(name = "isPhoneActive")
	public Boolean getIsPhoneActive() {
		return this.isPhoneActive;
	}

	public void setIsPhoneActive(Boolean isPhoneActive) {
		this.isPhoneActive = isPhoneActive;
	}

	@NotEmpty
	@Column(name = "hashed_password", nullable = false)
	public Serializable getHashedPassword() {
		return this.hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	@Column(name = "role")
	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Column(name = "addresses")
	public Serializable getAddresses() {
		return this.addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	@Column(name = "avatar", length = 100)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "cover", length = 100)
	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Column(name = "point")
	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Column(name = "e_wallet", precision = 10)
	public BigDecimal getEWallet() {
		return this.EWallet;
	}

	public void setEWallet(BigDecimal EWallet) {
		this.EWallet = EWallet;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public List<Transactions> getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(List<Transactions> transactionses) {
		this.transactionses = transactionses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public List<UserFollowProduct> getUserFollowProducts() {
		return this.userFollowProducts;
	}

	public void setUserFollowProducts(List<UserFollowProduct> userFollowProducts) {
		this.userFollowProducts = userFollowProducts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public List<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(List<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public List<Store> getStores() {
		return this.stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public List<UserFollowStore> getUserFollowStores() {
		return this.userFollowStores;
	}

	public void setUserFollowStores(List<UserFollowStore> userFollowStores) {
		this.userFollowStores = userFollowStores;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "users")
	public UserLevel getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}
	
	public Store addStore(Store store) {

		getStores().add(store);

		store.setUsers(this);

		return store;

	}

	public Store removeStore(Store store) {

		getStores().remove(store);

		store.setUsers(null);

		return store;

	}

}

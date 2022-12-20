package hcmute.vn.entity;

<<<<<<< HEAD
=======
import java.io.Serializable;
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Product", schema = "dbo", catalog = "EShop", uniqueConstraints = @UniqueConstraint(columnNames = "slug"))
public class Product implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Store store;
	private String name;
<<<<<<< HEAD
	private String slug; 
	private String desciption;
	private Integer price;
	private Integer promotionalPrice;
	private Integer quantity;
=======
	private String slug;
	private String desciption;
	private int price;
	private int promotionalPrice;
	private int quantity;
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
	private Integer slod;
	private Boolean isActive;
	private Boolean isSelling;
	private String listImage;
<<<<<<< HEAD
	private Category category;
=======
	private Integer categoryId;
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
	private String styleValueIds;
	private Integer rating;
	private Date createAt;
	private Date updateAt;
	private List<UserFollowProduct> userFollowProducts;
	private List<CartItem> cartItems;
	private List<OrderItem> orderItems;

	public Product() {
		this.slod = 0;
		this.promotionalPrice = 0;
		this.isSelling = true;
		this.rating = 0;
		this.createAt = new Date();
		this.updateAt = new Date();
	}

<<<<<<< HEAD
	public Product(String name, String desciption, Integer price, Integer promotionalPrice,
			Integer quantity) {
=======
	public Product(String name, String desciption, int price, int promotionalPrice,
			int quantity) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.name = name;
		this.desciption = desciption;
		this.price = price;
		this.promotionalPrice = promotionalPrice;
		this.quantity = quantity;
	}

<<<<<<< HEAD
	public Product(Store store, String name, String slug, String desciption, Integer price,
			Integer promotionalPrice, Integer quantity, Integer slod, Boolean isActive, Boolean isSelling,
			String listImage, Category category, String styleValueIds, Integer rating, Date createAt,
			Date updateAt, List<UserFollowProduct> userFollowProducts, List<CartItem> cartItems,
			List<OrderItem> orderItems) {
=======
	public Product(Store store, String name, String slug, String desciption, int price,
			int promotionalPrice, int quantity, Integer slod, Boolean isActive, Boolean isSelling,
			String listImage, Integer categoryId, String styleValueIds, Integer rating, Date createAt,
			Date updateAt, Set<UserFollowProduct> userFollowProducts, Set<CartItem> cartItems,
			Set<OrderItem> orderItems) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.store = store;
		this.name = name;
		this.slug = slug;
		this.desciption = desciption;
		this.price = price;
		this.promotionalPrice = promotionalPrice;
		this.quantity = quantity;
		this.slod = slod;
		this.isActive = isActive;
		this.isSelling = isSelling;
		this.listImage = listImage;
		this.category = category;
		this.styleValueIds = styleValueIds;
		this.rating = rating;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.userFollowProducts = userFollowProducts;
		this.cartItems = cartItems;
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
	@JoinColumn(name = "storeId")
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "slug", unique = true)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "desciption", nullable = false)
	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	@Column(name = "price", nullable = false, precision = 10)
<<<<<<< HEAD
	public Integer getPrice() {
=======
	public int getPrice() {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		return this.price;
	}

<<<<<<< HEAD
	public void setPrice(Integer price) {
=======
	public void setPrice(int price) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.price = price;
	}

	@Column(name = "promotionalPrice", nullable = false, precision = 10)
<<<<<<< HEAD
	public Integer getPromotionalPrice() {
=======
	public int getPromotionalPrice() {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		return this.promotionalPrice;
	}

<<<<<<< HEAD
	public void setPromotionalPrice(Integer promotionalPrice) {
=======
	public void setPromotionalPrice(int promotionalPrice) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.promotionalPrice = promotionalPrice;
	}

	@Column(name = "quantity", nullable = false)
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "slod")
	public Integer getSlod() {
		return this.slod;
	}

	public void setSlod(Integer slod) {
		this.slod = slod;
	}

	@Column(name = "is_active")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "is_selling")
	public Boolean getIsSelling() {
		return this.isSelling;
	}

	public void setIsSelling(Boolean isSelling) {
		this.isSelling = isSelling;
	}

	@Column(name = "listImage")
	public String getListImage() {
		return this.listImage;
	}

	public void setListImage(String listImage) {
		this.listImage = listImage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "style_valueIds")
	public String getStyleValueIds() {
		return this.styleValueIds;
	}

	public void setStyleValueIds(String styleValueIds) {
		this.styleValueIds = styleValueIds;
	}

	@Column(name = "rating")
	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<UserFollowProduct> getUserFollowProducts() {
		return this.userFollowProducts;
	}

	public void setUserFollowProducts(List<UserFollowProduct> userFollowProducts) {
		this.userFollowProducts = userFollowProducts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<CartItem> getCartItems() {
		return this.cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}

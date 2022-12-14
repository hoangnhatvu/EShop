package hcmute.vn.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OrderItem", schema = "dbo", catalog = "EShop")
public class OrderItem implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Orders orders;
	private Product product;
	private Style style;
	private int count;
	private Date createAt;
	private Date updateAt;
	private Store store;
	private int amountFromStore;
	private int amountToStore;
	private int amountToGd;

	public OrderItem() {
	}

	public OrderItem(Product product, int count, Store store, int amountFromStore, int amountToStore,
					 int amountToGd) {
		this.product = product;
		this.count = count;
		this.store = store;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToGd = amountToGd;
		this.createAt = new Date();
	}

	public OrderItem(Orders orders, Product product, Style style, int count, Date createAt, Date updateAt,Store store, int amountFromStore,
					 int amountToStore, int amountToGd) {
		this.orders = orders;
		this.product = product;
		this.style = style;
		this.count = count;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.store = store;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToGd = amountToGd;
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
	@JoinColumn(name = "order_id", nullable = false)
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "styleValue_ids", nullable = false)
	public Style getStyle() {
		return this.style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Column(name = "count", nullable = false)
	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "amountFromStore", nullable = false, precision = 5)
	public int getAmountFromStore() {
		return this.amountFromStore;
	}

	public void setAmountFromStore(int amountFromStore) {
		this.amountFromStore = amountFromStore;
	}

	@Column(name = "amountToStore", nullable = false, precision = 5)
	public int getAmountToStore() {
		return this.amountToStore;
	}

	public void setAmountToStore(int amountToStore) {
		this.amountToStore = amountToStore;
	}

	@Column(name = "amountToGD", nullable = false, precision = 5)
	public int getAmountToGd() {
		return this.amountToGd;
	}

	public void setAmountToGd(int amountToGd) {
		this.amountToGd = amountToGd;
	}

}

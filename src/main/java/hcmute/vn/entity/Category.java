package hcmute.vn.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Category", schema = "dbo", catalog = "EShop", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedQuery(name = "Category.findAll", query = "SELECT b FROM Category b")

public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String image;
	private Boolean isDeleted;
	private Date createAt;
	private Date updateAt;
	private List<Style> styles;
	private List<Product> products;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Category(String name, String image, Boolean isDeleted, Date createAt,
			Date updateAt, List<Style> styles, List<Product> products) {
		this.name = name;
		this.image = image;
		this.isDeleted = isDeleted;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.styles = styles;
		this.products = products;
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

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "is_deleted")
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public List<Style> getStyles() {
		return this.styles;
	}

	public void setStyles(List<Style> styles) {
		this.styles = styles;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Product addProduct(Product product) {

		getProducts().add(product);

		product.setCategory(this);

		return product;

	}

	public Product removeProduct(Product product) {

		getProducts().remove(product);

		product.setCategory(null);

		return product;

	}

}

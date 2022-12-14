package hcmute.vn.entity;

import java.io.Serializable;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Delivery", schema = "dbo", catalog = "EShop", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d")
public class Delivery implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String desciption;
	private int price;
	private Boolean isDeleted;
	private Date createAt;
	private Date updateAt;
	private List<Orders> orderses = null;

	public Delivery() {
	}

	public Delivery(String name, String desciption, int price) {
		this.name = name;
		this.desciption = desciption;
		this.price = price;
	}

	public Delivery(String name, String desciption, int price, Boolean isDeleted, Date createAt,
<<<<<<< HEAD
			Date updateAt, Set<Orders> orderses) {
=======
			Date updateAt, List<Orders> orderses) {
>>>>>>> branch 'master' of https://github.com/hoangnhatvu/EShop.git
		this.name = name;
		this.desciption = desciption;
		this.price = price;
		this.isDeleted = isDeleted;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.orderses = orderses;
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

	@Column(name = "desciption", nullable = false)
	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	@Column(name = "price", nullable = false)
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
	public List<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(List<Orders> orderses) {
		this.orderses = orderses;
	}

}

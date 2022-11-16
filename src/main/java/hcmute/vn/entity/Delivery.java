package hcmute.vn.entity;
// Generated Nov 17, 2022, 12:16:28 AM by Hibernate Tools 4.3.6.Final

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Delivery generated by hbm2java
 */
@Entity
@Table(name = "Delivery", schema = "dbo", catalog = "EShop", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Delivery implements java.io.Serializable {

	private Integer id;
	private Serializable name;
	private Serializable desciption;
	private int price;
	private Boolean isDeleted;
	private Date createAt;
	private Date updateAt;
	private Set<Orders> orderses = new HashSet<Orders>(0);

	public Delivery() {
	}

	public Delivery(Serializable name, Serializable desciption, int price) {
		this.name = name;
		this.desciption = desciption;
		this.price = price;
	}

	public Delivery(Serializable name, Serializable desciption, int price, Boolean isDeleted, Date createAt,
			Date updateAt, Set<Orders> orderses) {
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
	public Serializable getName() {
		return this.name;
	}

	public void setName(Serializable name) {
		this.name = name;
	}

	@Column(name = "desciption", nullable = false)
	public Serializable getDesciption() {
		return this.desciption;
	}

	public void setDesciption(Serializable desciption) {
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
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}
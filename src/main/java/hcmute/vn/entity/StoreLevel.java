package hcmute.vn.entity;
// Generated Nov 17, 2022, 12:16:28 AM by Hibernate Tools 4.3.6.Final

import java.io.Serializable;
import java.math.int;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * StoreLevel generated by hbm2java
 */
@Entity
@Table(name = "StoreLevel", schema = "dbo", catalog = "EShop")
@NamedQuery(name = "StoreLevel.findAll", query = "SELECT s FROM StoreLevel s")

public class StoreLevel implements java.io.Serializable {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "store"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Store store;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "minPoint", nullable = false)
	private int minPoint;
	
	@Column(name = "discount", nullable = false, precision = 10)
	private int discount;
	
	@Column(name = "is_delete")
	private Boolean isDelete;
	@Temporal(TemporalType.DATE)
	@Column(name = "createAt", length = 10)
	private Date createAt;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "updateAt", length = 10)
	private Date updateAt;

	public StoreLevel() {
	}

	public StoreLevel(Store store, String name, int minPoint, int discount) {
		this.store = store;
		this.name = name;
		this.minPoint = minPoint;
		this.discount = discount;
	}

	public StoreLevel(Store store, String name, int minPoint, int discount, Boolean isDelete,
			Date createAt, Date updateAt) {
		this.store = store;
		this.name = name;
		this.minPoint = minPoint;
		this.discount = discount;
		this.isDelete = isDelete;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
		this.id = store.getId();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinPoint() {
		return this.minPoint;
	}

	public void setMinPoint(int minPoint) {
		this.minPoint = minPoint;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	
	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
	public Date getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

}
package hcmute.vn.entity;
// Generated Nov 17, 2022, 12:16:28 AM by Hibernate Tools 4.3.6.Final

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * UserLevel generated by hbm2java
 */
@Entity
@Table(name = "UserLevel", schema = "dbo", catalog = "EShop", uniqueConstraints = {
		@UniqueConstraint(columnNames = "minPoint"), @UniqueConstraint(columnNames = "name") })
@NamedQuery(name = "UserLevel.findAll", query = "SELECT U FROM UserLevel U")

public class UserLevel implements java.io.Serializable {
	
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "users"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Users users;
	@Column(name = "name", unique = true, nullable = false)

	private String name;
	@Column(name = "minPoint", unique = true, nullable = false)

	private int minPoint;
	@Column(name = "discount", nullable = false, precision = 5)

	private int discount;
	@Column(name = "is_deleted")

	private Boolean isDeleted;
	@Temporal(TemporalType.DATE)
	@Column(name = "createAt", length = 10)
	private Date createAt;
	@Temporal(TemporalType.DATE)
	@Column(name = "updateAt", length = 10)
	private Date updateAt;

	public UserLevel() {
	}

	public UserLevel(Users users, String name, int minPoint, int discount) {
		this.users = users;
		this.name = name;
		this.minPoint = minPoint;
		this.discount = discount;
	}

	public UserLevel(Users users, String name, int minPoint, int discount, Boolean isDeleted,
			Date createAt, Date updateAt) {
		this.users = users;
		this.name = name;
		this.minPoint = minPoint;
		this.discount = discount;
		this.isDeleted = isDeleted;
		this.createAt = createAt;
		this.updateAt = updateAt;
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

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

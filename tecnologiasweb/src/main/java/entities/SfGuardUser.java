package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sf_guard_user database table.
 * 
 */
@Entity
@Table(name="sf_guard_user")
@NamedQuery(name="SfGuardUser.findAll", query="SELECT s FROM SfGuardUser s")
public class SfGuardUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String algorithm;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_super_admin")
	private Boolean isSuperAdmin;

	@Column(name="last_login")
	private Timestamp lastLogin;

	private String password;

	private String salt;

	private String username;

	public SfGuardUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlgorithm() {
		return this.algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsSuperAdmin() {
		return this.isSuperAdmin;
	}

	public void setIsSuperAdmin(Boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
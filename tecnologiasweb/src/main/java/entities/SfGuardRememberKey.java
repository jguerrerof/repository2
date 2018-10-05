package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sf_guard_remember_key database table.
 * 
 */
@Entity
@Table(name="sf_guard_remember_key")
@NamedQuery(name="SfGuardRememberKey.findAll", query="SELECT s FROM SfGuardRememberKey s")
public class SfGuardRememberKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SfGuardRememberKeyPK id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="remember_key")
	private String rememberKey;

	public SfGuardRememberKey() {
	}

	public SfGuardRememberKeyPK getId() {
		return this.id;
	}

	public void setId(SfGuardRememberKeyPK id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getRememberKey() {
		return this.rememberKey;
	}

	public void setRememberKey(String rememberKey) {
		this.rememberKey = rememberKey;
	}

}
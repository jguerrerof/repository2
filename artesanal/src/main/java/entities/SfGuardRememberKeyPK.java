package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sf_guard_remember_key database table.
 * 
 */
@Embeddable
public class SfGuardRememberKeyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false)
	private Integer userId;

	@Column(name="ip_address")
	private String ipAddress;

	public SfGuardRememberKeyPK() {
	}
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getIpAddress() {
		return this.ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SfGuardRememberKeyPK)) {
			return false;
		}
		SfGuardRememberKeyPK castOther = (SfGuardRememberKeyPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.ipAddress.equals(castOther.ipAddress);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.ipAddress.hashCode();
		
		return hash;
	}
}
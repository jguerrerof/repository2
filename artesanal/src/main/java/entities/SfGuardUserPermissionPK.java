package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sf_guard_user_permission database table.
 * 
 */
@Embeddable
public class SfGuardUserPermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false)
	private Integer userId;

	@Column(name="permission_id", insertable=false, updatable=false)
	private Integer permissionId;

	public SfGuardUserPermissionPK() {
	}
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPermissionId() {
		return this.permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SfGuardUserPermissionPK)) {
			return false;
		}
		SfGuardUserPermissionPK castOther = (SfGuardUserPermissionPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.permissionId.equals(castOther.permissionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.permissionId.hashCode();
		
		return hash;
	}
}
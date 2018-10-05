package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sf_guard_group_permission database table.
 * 
 */
@Embeddable
public class SfGuardGroupPermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="group_id", insertable=false, updatable=false)
	private Integer groupId;

	@Column(name="permission_id", insertable=false, updatable=false)
	private Integer permissionId;

	public SfGuardGroupPermissionPK() {
	}
	public Integer getGroupId() {
		return this.groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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
		if (!(other instanceof SfGuardGroupPermissionPK)) {
			return false;
		}
		SfGuardGroupPermissionPK castOther = (SfGuardGroupPermissionPK)other;
		return 
			this.groupId.equals(castOther.groupId)
			&& this.permissionId.equals(castOther.permissionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupId.hashCode();
		hash = hash * prime + this.permissionId.hashCode();
		
		return hash;
	}
}
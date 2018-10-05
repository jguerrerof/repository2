package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sf_guard_user_group database table.
 * 
 */
@Embeddable
public class SfGuardUserGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false)
	private Integer userId;

	@Column(name="group_id", insertable=false, updatable=false)
	private Integer groupId;

	public SfGuardUserGroupPK() {
	}
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGroupId() {
		return this.groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SfGuardUserGroupPK)) {
			return false;
		}
		SfGuardUserGroupPK castOther = (SfGuardUserGroupPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.groupId.equals(castOther.groupId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.groupId.hashCode();
		
		return hash;
	}
}
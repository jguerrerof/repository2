package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sf_guard_user_group database table.
 * 
 */
@Entity
@Table(name="sf_guard_user_group")
@NamedQuery(name="SfGuardUserGroup.findAll", query="SELECT s FROM SfGuardUserGroup s")
public class SfGuardUserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SfGuardUserGroupPK id;

	public SfGuardUserGroup() {
	}

	public SfGuardUserGroupPK getId() {
		return this.id;
	}

	public void setId(SfGuardUserGroupPK id) {
		this.id = id;
	}

}
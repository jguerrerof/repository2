package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sf_guard_user_permission database table.
 * 
 */
@Entity
@Table(name="sf_guard_user_permission")
@NamedQuery(name="SfGuardUserPermission.findAll", query="SELECT s FROM SfGuardUserPermission s")
public class SfGuardUserPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SfGuardUserPermissionPK id;

	public SfGuardUserPermission() {
	}

	public SfGuardUserPermissionPK getId() {
		return this.id;
	}

	public void setId(SfGuardUserPermissionPK id) {
		this.id = id;
	}

}
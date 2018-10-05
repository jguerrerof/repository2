package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sf_guard_group_permission database table.
 * 
 */
@Entity
@Table(name="sf_guard_group_permission")
@NamedQuery(name="SfGuardGroupPermission.findAll", query="SELECT s FROM SfGuardGroupPermission s")
public class SfGuardGroupPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SfGuardGroupPermissionPK id;

	public SfGuardGroupPermission() {
	}

	public SfGuardGroupPermissionPK getId() {
		return this.id;
	}

	public void setId(SfGuardGroupPermissionPK id) {
		this.id = id;
	}

}
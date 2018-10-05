package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sf_guard_group database table.
 * 
 */
@Entity
@Table(name="sf_guard_group")
@NamedQuery(name="SfGuardGroup.findAll", query="SELECT s FROM SfGuardGroup s")
public class SfGuardGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String description;

	private String name;

	public SfGuardGroup() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
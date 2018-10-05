package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@NamedQuery(name="Asistencia.findAll", query="SELECT a FROM Asistencia a")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="acta_asistencia_id")
	private Integer actaAsistenciaId;

	private Boolean asistencia;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="created_by")
	private String createdBy;

	private String observaciones;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="usuario_id")
	private Integer usuarioId;

	public Asistencia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActaAsistenciaId() {
		return this.actaAsistenciaId;
	}

	public void setActaAsistenciaId(Integer actaAsistenciaId) {
		this.actaAsistenciaId = actaAsistenciaId;
	}

	public Boolean getAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(Boolean asistencia) {
		this.asistencia = asistencia;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

}
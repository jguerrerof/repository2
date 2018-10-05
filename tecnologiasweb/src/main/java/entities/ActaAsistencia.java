package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the acta_asistencia database table.
 * 
 */
@Entity
@Table(name="acta_asistencia")
@NamedQuery(name="ActaAsistencia.findAll", query="SELECT a FROM ActaAsistencia a")
public class ActaAsistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean activa;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String observaciones;

	@Column(name="paralelo_id")
	private Integer paraleloId;

	@Column(name="tipo_asistencia_id")
	private Integer tipoAsistenciaId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="updated_by")
	private String updatedBy;

	public ActaAsistencia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActiva() {
		return this.activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getParaleloId() {
		return this.paraleloId;
	}

	public void setParaleloId(Integer paraleloId) {
		this.paraleloId = paraleloId;
	}

	public Integer getTipoAsistenciaId() {
		return this.tipoAsistenciaId;
	}

	public void setTipoAsistenciaId(Integer tipoAsistenciaId) {
		this.tipoAsistenciaId = tipoAsistenciaId;
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

}
package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the logged_actions database table.
 * 
 */
@Entity
@Table(name="logged_actions")
@NamedQuery(name="LoggedAction.findAll", query="SELECT l FROM LoggedAction l")
public class LoggedAction implements Serializable {
	private static final long serialVersionUID = 1L;

	private String action;

	@Column(name="action_tstamp")
	private Timestamp actionTstamp;

	@Id
	private Integer id;

	@Column(name="new_data")
	private String newData;

	@Column(name="original_data")
	private String originalData;

	private String query;

	@Column(name="schema_name")
	private String schemaName;

	@Column(name="table_name")
	private String tableName;

	@Column(name="user_name")
	private String userName;

	private String usuario;

	public LoggedAction() {
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Timestamp getActionTstamp() {
		return this.actionTstamp;
	}

	public void setActionTstamp(Timestamp actionTstamp) {
		this.actionTstamp = actionTstamp;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNewData() {
		return this.newData;
	}

	public void setNewData(String newData) {
		this.newData = newData;
	}

	public String getOriginalData() {
		return this.originalData;
	}

	public void setOriginalData(String originalData) {
		this.originalData = originalData;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getSchemaName() {
		return this.schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
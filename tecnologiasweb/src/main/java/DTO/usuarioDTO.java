package main.java.DTO;

import java.util.List;

public class usuarioDTO {
	
	

	public String usuarioId;
	
	
	public String identificacion;
	public String username;
	public String sfguarduserid;
	
	public String nombres;
	public String apellidos;
	public String apellido1;
	public String apellido2;
    public String permisos;
    public String fechaCreacion;
    public String fechaUltimoAcceso;
    public List<String> permisosvarios;
    
    public String tablasacceso=""; 
    
    public List<permisosDTO> listadoPermisos;
     
    public boolean color=false; 
    
    
	public usuarioDTO(String usuarioId, String username, String identificacion,String nombres, String apellidos,String permisos,List<String> permisosvarios,String fechaCreacion,String fechaUltimoAcceso){
		
		this.usuarioId=usuarioId;
		this.username=username;
		this.identificacion=identificacion;
		this.nombres=nombres;
		this.apellidos=apellidos;
		 this.permisos=permisos;
		 this.permisosvarios=permisosvarios;
		 this.fechaCreacion=fechaCreacion;
		 this.fechaUltimoAcceso=fechaUltimoAcceso;
	}
	
	 
		
	
    
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombre) {
		this.nombres = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}
	public void setFechaUltimoAcceso(String fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getSfguarduserid() {
		return sfguarduserid;
	}


	public void setSfguarduserid(String sfguarduserid) {
		this.sfguarduserid = sfguarduserid;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public List<String> getPermisosvarios() {
		return permisosvarios;
	}


	public void setPermisosvarios(List<String> permisosvarios) {
		this.permisosvarios = permisosvarios;
	}



	public boolean isColor() {
		return color;
	}



	public void setColor(boolean color) {
		this.color = color;
	}





	public String getTablasacceso() {
		return tablasacceso;
	}





	public void setTablasacceso(String tablasacceso) {
		this.tablasacceso = tablasacceso;
	}





	public List<permisosDTO> getListadoPermisos() {
		return listadoPermisos;
	}





	public void setListadoPermisos(List<permisosDTO> listadoPermisos) {
		this.listadoPermisos = listadoPermisos;
	}


 
	

}

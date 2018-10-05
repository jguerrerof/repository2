package main.java.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="actualizo_datos")
	private Boolean actualizoDatos;

	@Column(name="anio_graduacion")
	private Integer anioGraduacion;

	private String apellidos;

	private String becas;

	@Column(name="cargo_adm_academico")
	private String cargoAdmAcademico;

	@Column(name="carnet_conadis")
	private Boolean carnetConadis;

	@Column(name="carrera_anterior")
	private String carreraAnterior;

	@Column(name="carrera_id")
	private Integer carreraId;

	@Column(name="categoria_prof_id")
	private Integer categoriaProfId;

	private String celular;

	@Column(name="ciudad_colegio_id")
	private Integer ciudadColegioId;

	@Column(name="ciudad_graduacion")
	private String ciudadGraduacion;

	@Column(name="ciudad_id")
	private Integer ciudadId;

	@Column(name="ciudad_nacimiento_id")
	private Integer ciudadNacimientoId;

	@Column(name="codigo_alumno")
	private Integer codigoAlumno;

	@Column(name="codigo_profesor")
	private Integer codigoProfesor;

	@Column(name="colegio_id")
	private Integer colegioId;

	@Column(name="colegio_procedencia")
	private String colegioProcedencia;

	private String conferencias;

	private String consultorias;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="datos_revisados")
	private Boolean datosRevisados;

	private String deportes;

	@Column(name="direccion_contacto")
	private String direccionContacto;

	@Column(name="direccion_domicilio")
	private String direccionDomicilio;

	@Column(name="direccion_madre")
	private String direccionMadre;

	@Column(name="direccion_padre")
	private String direccionPadre;

	@Column(name="direccion_referencia")
	private String direccionReferencia;

	@Column(name="direccion_trabajo")
	private String direccionTrabajo;

	private String disertaciones;

	@Column(name="dispone_beca")
	private Boolean disponeBeca;

	private String email;

	@Column(name="email_universidad")
	private String emailUniversidad;

	@Column(name="es_egresado")
	private Boolean esEgresado;

	@Column(name="es_graduado")
	private Boolean esGraduado;

	@Column(name="es_profesional")
	private Boolean esProfesional;

	private String especialidad;

	private String especializaciones;

	private Boolean estado;

	@Column(name="estado_alumno")
	private String estadoAlumno;

	@Column(name="estado_civil_id")
	private Integer estadoCivilId;

	@Column(name="estudia_otra_carrera")
	private Boolean estudiaOtraCarrera;

	@Column(name="etnia_id")
	private Integer etniaId;

	@Column(name="experiencia_laboral")
	private String experienciaLaboral;

	@Column(name="facultad_id")
	private Integer facultadId;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_convalidacion")
	private Date fechaConvalidacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_graduacion")
	private Date fechaGraduacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_revisado")
	private Date fechaRevisado;

	private String foto;

	@Column(name="gastos_mensuales")
	private double gastosMensuales;

	private String grados;

	@Column(name="grupo_poblacional_id")
	private Integer grupoPoblacionalId;

	@Column(name="habilidades_tecnicas")
	private String habilidadesTecnicas;

	private String honores;

	@Column(name="horas_academicas")
	private Integer horasAcademicas;

	@Column(name="horas_administrativas")
	private Integer horasAdministrativas;

	@Column(name="horas_investigacion")
	private Integer horasInvestigacion;

	@Column(name="horas_total_dedicadas")
	private Integer horasTotalDedicadas;

	private String identificacion;

	@Column(name="infraestructura_id")
	private Integer infraestructuraId;

	@Column(name="ingreso_madre")
	private double ingresoMadre;

	@Column(name="ingreso_padre")
	private double ingresoPadre;

	@Column(name="ingresos_id")
	private Integer ingresosId;

	private String intereses;

	private String investigaciones;

	@Column(name="jornada_id")
	private Integer jornadaId;

	@Column(name="ldap_id")
	private Integer ldapId;

	@Column(name="learnloop_id")
	private Integer learnloopId;

	private String lecturas;

	private String lenguajes;

	private String licencias;

	@Column(name="llenar_encuesta_graduado")
	private Boolean llenarEncuestaGraduado;

	@Column(name="lugar_nacimiento")
	private String lugarNacimiento;

	private String matricula;

	private Boolean matriculado;

	private String nacionalidad;

	@Column(name="nivel_alumno")
	private Integer nivelAlumno;

	@Column(name="nivel_formacion_id")
	private Integer nivelFormacionId;

	@Column(name="nivel_t3n_id")
	private Integer nivelT3nId;

	@Column(name="nivel_t4n_id")
	private Integer nivelT4nId;

	@Column(name="no_registrado")
	private Boolean noRegistrado;

	@Column(name="nombre_contacto")
	private String nombreContacto;

	@Column(name="nombre_madre")
	private String nombreMadre;

	@Column(name="nombre_padre")
	private String nombrePadre;

	@Column(name="nombre_referencia")
	private String nombreReferencia;

	private String nombres;

	@Column(name="nota_grado")
	private String notaGrado;

	@Column(name="numero_carnet")
	private String numeroCarnet;

	@Column(name="numero_hijos")
	private Integer numeroHijos;

	@Column(name="numero_miembro_familia")
	private Integer numeroMiembroFamilia;

	@Column(name="numero_veces_quedado")
	private Integer numeroVecesQuedado;

	@Column(name="observacion_graduado")
	private String observacionGraduado;

	@Column(name="observacion_materia")
	private String observacionMateria;

	private String observaciones;

	@Column(name="ocupacion_madre")
	private String ocupacionMadre;

	@Column(name="ocupacion_padre")
	private String ocupacionPadre;

	@Column(name="pago_matricula")
	private Boolean pagoMatricula;

	@Column(name="pais_id")
	private Integer paisId;

	@Column(name="pais_t3n")
	private String paisT3n;

	@Column(name="pais_t4n")
	private String paisT4n;

	@Column(name="parentesco_referencia")
	private String parentescoReferencia;

	@Column(name="password_email")
	private String passwordEmail;

	@Column(name="perdio_subsidio")
	private Boolean perdioSubsidio;

	private String perfil;

	@Column(name="porcentaje_discapacidad")
	private double porcentajeDiscapacidad;

	private String premios;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="profesion_id")
	private Integer profesionId;

	@Column(name="profesor_tutor")
	private Boolean profesorTutor;

	@Column(name="promedio_graduacion")
	private double promedioGraduacion;

	@Column(name="provincia_colegio_id")
	private Integer provinciaColegioId;

	@Column(name="provincia_id")
	private Integer provinciaId;

	@Column(name="provincia_nacimiento_id")
	private Integer provinciaNacimientoId;

	private String publicaciones;

	@Column(name="registro_conesup_t3n")
	private String registroConesupT3n;

	@Column(name="registro_conesup_t4n")
	private String registroConesupT4n;

	@Column(name="revisado_por")
	private String revisadoPor;

	private String rol;

	@Column(name="rol_id")
	private Integer rolId;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	private String seminarios;

	@Column(name="sexo_id")
	private Integer sexoId;

	@Column(name="sf_guard_user_id")
	private Integer sfGuardUserId;

	private double sueldo;

	private String talleres;

	@Column(name="telefono_contacto")
	private String telefonoContacto;

	@Column(name="telefono_domicilio")
	private String telefonoDomicilio;

	@Column(name="telefono_madre")
	private String telefonoMadre;

	@Column(name="telefono_padre")
	private String telefonoPadre;

	@Column(name="telefono_referencia")
	private String telefonoReferencia;

	@Column(name="telefono_trabajo")
	private String telefonoTrabajo;

	private String tesis;

	@Column(name="tiempo_trabajo")
	private String tiempoTrabajo;

	@Column(name="tiene_hijos")
	private String tieneHijos;

	@Column(name="tipo_alumno")
	private Integer tipoAlumno;

	@Column(name="tipo_becas_id")
	private Integer tipoBecasId;

	@Column(name="tipo_colegio_id")
	private Integer tipoColegioId;

	@Column(name="tipo_discapacidad_id")
	private Integer tipoDiscapacidadId;

	@Column(name="tipo_horario")
	private String tipoHorario;

	@Column(name="tipo_sangre_id")
	private Integer tipoSangreId;

	@Column(name="tipo_sanguineo")
	private String tipoSanguineo;

	@Column(name="tipo_vivienda_id")
	private Integer tipoViviendaId;

	@Column(name="titulo_3_nivel")
	private String titulo3Nivel;

	@Column(name="titulo_4_nivel")
	private String titulo4Nivel;

	@Column(name="titulo_bachiller")
	private String tituloBachiller;

	@Column(name="titulo_universitario_anterior")
	private String tituloUniversitarioAnterior;

	private String trabaja;

	@Column(name="ultimo_anio_anterior")
	private String ultimoAnioAnterior;

	@Column(name="universidad_anterior")
	private String universidadAnterior;

	@Column(name="universidad_id")
	private Integer universidadId;

	@Column(name="universidad_t3n")
	private String universidadT3n;

	@Column(name="universidad_t4n")
	private String universidadT4n;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="validar_continuidad")
	private Boolean validarContinuidad;

	@Column(name="validar_email")
	private Boolean validarEmail;

	@Column(name="zona_id")
	private Integer zonaId;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActualizoDatos() {
		return this.actualizoDatos;
	}

	public void setActualizoDatos(Boolean actualizoDatos) {
		this.actualizoDatos = actualizoDatos;
	}

	public Integer getAnioGraduacion() {
		return this.anioGraduacion;
	}

	public void setAnioGraduacion(Integer anioGraduacion) {
		this.anioGraduacion = anioGraduacion;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getBecas() {
		return this.becas;
	}

	public void setBecas(String becas) {
		this.becas = becas;
	}

	public String getCargoAdmAcademico() {
		return this.cargoAdmAcademico;
	}

	public void setCargoAdmAcademico(String cargoAdmAcademico) {
		this.cargoAdmAcademico = cargoAdmAcademico;
	}

	public Boolean getCarnetConadis() {
		return this.carnetConadis;
	}

	public void setCarnetConadis(Boolean carnetConadis) {
		this.carnetConadis = carnetConadis;
	}

	public String getCarreraAnterior() {
		return this.carreraAnterior;
	}

	public void setCarreraAnterior(String carreraAnterior) {
		this.carreraAnterior = carreraAnterior;
	}

	public Integer getCarreraId() {
		return this.carreraId;
	}

	public void setCarreraId(Integer carreraId) {
		this.carreraId = carreraId;
	}

	public Integer getCategoriaProfId() {
		return this.categoriaProfId;
	}

	public void setCategoriaProfId(Integer categoriaProfId) {
		this.categoriaProfId = categoriaProfId;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getCiudadColegioId() {
		return this.ciudadColegioId;
	}

	public void setCiudadColegioId(Integer ciudadColegioId) {
		this.ciudadColegioId = ciudadColegioId;
	}

	public String getCiudadGraduacion() {
		return this.ciudadGraduacion;
	}

	public void setCiudadGraduacion(String ciudadGraduacion) {
		this.ciudadGraduacion = ciudadGraduacion;
	}

	public Integer getCiudadId() {
		return this.ciudadId;
	}

	public void setCiudadId(Integer ciudadId) {
		this.ciudadId = ciudadId;
	}

	public Integer getCiudadNacimientoId() {
		return this.ciudadNacimientoId;
	}

	public void setCiudadNacimientoId(Integer ciudadNacimientoId) {
		this.ciudadNacimientoId = ciudadNacimientoId;
	}

	public Integer getCodigoAlumno() {
		return this.codigoAlumno;
	}

	public void setCodigoAlumno(Integer codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public Integer getCodigoProfesor() {
		return this.codigoProfesor;
	}

	public void setCodigoProfesor(Integer codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}

	public Integer getColegioId() {
		return this.colegioId;
	}

	public void setColegioId(Integer colegioId) {
		this.colegioId = colegioId;
	}

	public String getColegioProcedencia() {
		return this.colegioProcedencia;
	}

	public void setColegioProcedencia(String colegioProcedencia) {
		this.colegioProcedencia = colegioProcedencia;
	}

	public String getConferencias() {
		return this.conferencias;
	}

	public void setConferencias(String conferencias) {
		this.conferencias = conferencias;
	}

	public String getConsultorias() {
		return this.consultorias;
	}

	public void setConsultorias(String consultorias) {
		this.consultorias = consultorias;
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

	public Boolean getDatosRevisados() {
		return this.datosRevisados;
	}

	public void setDatosRevisados(Boolean datosRevisados) {
		this.datosRevisados = datosRevisados;
	}

	public String getDeportes() {
		return this.deportes;
	}

	public void setDeportes(String deportes) {
		this.deportes = deportes;
	}

	public String getDireccionContacto() {
		return this.direccionContacto;
	}

	public void setDireccionContacto(String direccionContacto) {
		this.direccionContacto = direccionContacto;
	}

	public String getDireccionDomicilio() {
		return this.direccionDomicilio;
	}

	public void setDireccionDomicilio(String direccionDomicilio) {
		this.direccionDomicilio = direccionDomicilio;
	}

	public String getDireccionMadre() {
		return this.direccionMadre;
	}

	public void setDireccionMadre(String direccionMadre) {
		this.direccionMadre = direccionMadre;
	}

	public String getDireccionPadre() {
		return this.direccionPadre;
	}

	public void setDireccionPadre(String direccionPadre) {
		this.direccionPadre = direccionPadre;
	}

	public String getDireccionReferencia() {
		return this.direccionReferencia;
	}

	public void setDireccionReferencia(String direccionReferencia) {
		this.direccionReferencia = direccionReferencia;
	}

	public String getDireccionTrabajo() {
		return this.direccionTrabajo;
	}

	public void setDireccionTrabajo(String direccionTrabajo) {
		this.direccionTrabajo = direccionTrabajo;
	}

	public String getDisertaciones() {
		return this.disertaciones;
	}

	public void setDisertaciones(String disertaciones) {
		this.disertaciones = disertaciones;
	}

	public Boolean getDisponeBeca() {
		return this.disponeBeca;
	}

	public void setDisponeBeca(Boolean disponeBeca) {
		this.disponeBeca = disponeBeca;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailUniversidad() {
		return this.emailUniversidad;
	}

	public void setEmailUniversidad(String emailUniversidad) {
		this.emailUniversidad = emailUniversidad;
	}

	public Boolean getEsEgresado() {
		return this.esEgresado;
	}

	public void setEsEgresado(Boolean esEgresado) {
		this.esEgresado = esEgresado;
	}

	public Boolean getEsGraduado() {
		return this.esGraduado;
	}

	public void setEsGraduado(Boolean esGraduado) {
		this.esGraduado = esGraduado;
	}

	public Boolean getEsProfesional() {
		return this.esProfesional;
	}

	public void setEsProfesional(Boolean esProfesional) {
		this.esProfesional = esProfesional;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getEspecializaciones() {
		return this.especializaciones;
	}

	public void setEspecializaciones(String especializaciones) {
		this.especializaciones = especializaciones;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getEstadoAlumno() {
		return this.estadoAlumno;
	}

	public void setEstadoAlumno(String estadoAlumno) {
		this.estadoAlumno = estadoAlumno;
	}

	public Integer getEstadoCivilId() {
		return this.estadoCivilId;
	}

	public void setEstadoCivilId(Integer estadoCivilId) {
		this.estadoCivilId = estadoCivilId;
	}

	public Boolean getEstudiaOtraCarrera() {
		return this.estudiaOtraCarrera;
	}

	public void setEstudiaOtraCarrera(Boolean estudiaOtraCarrera) {
		this.estudiaOtraCarrera = estudiaOtraCarrera;
	}

	public Integer getEtniaId() {
		return this.etniaId;
	}

	public void setEtniaId(Integer etniaId) {
		this.etniaId = etniaId;
	}

	public String getExperienciaLaboral() {
		return this.experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public Integer getFacultadId() {
		return this.facultadId;
	}

	public void setFacultadId(Integer facultadId) {
		this.facultadId = facultadId;
	}

	public Date getFechaConvalidacion() {
		return this.fechaConvalidacion;
	}

	public void setFechaConvalidacion(Date fechaConvalidacion) {
		this.fechaConvalidacion = fechaConvalidacion;
	}

	public Date getFechaGraduacion() {
		return this.fechaGraduacion;
	}

	public void setFechaGraduacion(Date fechaGraduacion) {
		this.fechaGraduacion = fechaGraduacion;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRevisado() {
		return this.fechaRevisado;
	}

	public void setFechaRevisado(Date fechaRevisado) {
		this.fechaRevisado = fechaRevisado;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public double getGastosMensuales() {
		return this.gastosMensuales;
	}

	public void setGastosMensuales(double gastosMensuales) {
		this.gastosMensuales = gastosMensuales;
	}

	public String getGrados() {
		return this.grados;
	}

	public void setGrados(String grados) {
		this.grados = grados;
	}

	public Integer getGrupoPoblacionalId() {
		return this.grupoPoblacionalId;
	}

	public void setGrupoPoblacionalId(Integer grupoPoblacionalId) {
		this.grupoPoblacionalId = grupoPoblacionalId;
	}

	public String getHabilidadesTecnicas() {
		return this.habilidadesTecnicas;
	}

	public void setHabilidadesTecnicas(String habilidadesTecnicas) {
		this.habilidadesTecnicas = habilidadesTecnicas;
	}

	public String getHonores() {
		return this.honores;
	}

	public void setHonores(String honores) {
		this.honores = honores;
	}

	public Integer getHorasAcademicas() {
		return this.horasAcademicas;
	}

	public void setHorasAcademicas(Integer horasAcademicas) {
		this.horasAcademicas = horasAcademicas;
	}

	public Integer getHorasAdministrativas() {
		return this.horasAdministrativas;
	}

	public void setHorasAdministrativas(Integer horasAdministrativas) {
		this.horasAdministrativas = horasAdministrativas;
	}

	public Integer getHorasInvestigacion() {
		return this.horasInvestigacion;
	}

	public void setHorasInvestigacion(Integer horasInvestigacion) {
		this.horasInvestigacion = horasInvestigacion;
	}

	public Integer getHorasTotalDedicadas() {
		return this.horasTotalDedicadas;
	}

	public void setHorasTotalDedicadas(Integer horasTotalDedicadas) {
		this.horasTotalDedicadas = horasTotalDedicadas;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Integer getInfraestructuraId() {
		return this.infraestructuraId;
	}

	public void setInfraestructuraId(Integer infraestructuraId) {
		this.infraestructuraId = infraestructuraId;
	}

	public double getIngresoMadre() {
		return this.ingresoMadre;
	}

	public void setIngresoMadre(double ingresoMadre) {
		this.ingresoMadre = ingresoMadre;
	}

	public double getIngresoPadre() {
		return this.ingresoPadre;
	}

	public void setIngresoPadre(double ingresoPadre) {
		this.ingresoPadre = ingresoPadre;
	}

	public Integer getIngresosId() {
		return this.ingresosId;
	}

	public void setIngresosId(Integer ingresosId) {
		this.ingresosId = ingresosId;
	}

	public String getIntereses() {
		return this.intereses;
	}

	public void setIntereses(String intereses) {
		this.intereses = intereses;
	}

	public String getInvestigaciones() {
		return this.investigaciones;
	}

	public void setInvestigaciones(String investigaciones) {
		this.investigaciones = investigaciones;
	}

	public Integer getJornadaId() {
		return this.jornadaId;
	}

	public void setJornadaId(Integer jornadaId) {
		this.jornadaId = jornadaId;
	}

	public Integer getLdapId() {
		return this.ldapId;
	}

	public void setLdapId(Integer ldapId) {
		this.ldapId = ldapId;
	}

	public Integer getLearnloopId() {
		return this.learnloopId;
	}

	public void setLearnloopId(Integer learnloopId) {
		this.learnloopId = learnloopId;
	}

	public String getLecturas() {
		return this.lecturas;
	}

	public void setLecturas(String lecturas) {
		this.lecturas = lecturas;
	}

	public String getLenguajes() {
		return this.lenguajes;
	}

	public void setLenguajes(String lenguajes) {
		this.lenguajes = lenguajes;
	}

	public String getLicencias() {
		return this.licencias;
	}

	public void setLicencias(String licencias) {
		this.licencias = licencias;
	}

	public Boolean getLlenarEncuestaGraduado() {
		return this.llenarEncuestaGraduado;
	}

	public void setLlenarEncuestaGraduado(Boolean llenarEncuestaGraduado) {
		this.llenarEncuestaGraduado = llenarEncuestaGraduado;
	}

	public String getLugarNacimiento() {
		return this.lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Boolean getMatriculado() {
		return this.matriculado;
	}

	public void setMatriculado(Boolean matriculado) {
		this.matriculado = matriculado;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Integer getNivelAlumno() {
		return this.nivelAlumno;
	}

	public void setNivelAlumno(Integer nivelAlumno) {
		this.nivelAlumno = nivelAlumno;
	}

	public Integer getNivelFormacionId() {
		return this.nivelFormacionId;
	}

	public void setNivelFormacionId(Integer nivelFormacionId) {
		this.nivelFormacionId = nivelFormacionId;
	}

	public Integer getNivelT3nId() {
		return this.nivelT3nId;
	}

	public void setNivelT3nId(Integer nivelT3nId) {
		this.nivelT3nId = nivelT3nId;
	}

	public Integer getNivelT4nId() {
		return this.nivelT4nId;
	}

	public void setNivelT4nId(Integer nivelT4nId) {
		this.nivelT4nId = nivelT4nId;
	}

	public Boolean getNoRegistrado() {
		return this.noRegistrado;
	}

	public void setNoRegistrado(Boolean noRegistrado) {
		this.noRegistrado = noRegistrado;
	}

	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getNombreMadre() {
		return this.nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public String getNombrePadre() {
		return this.nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getNombreReferencia() {
		return this.nombreReferencia;
	}

	public void setNombreReferencia(String nombreReferencia) {
		this.nombreReferencia = nombreReferencia;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNotaGrado() {
		return this.notaGrado;
	}

	public void setNotaGrado(String notaGrado) {
		this.notaGrado = notaGrado;
	}

	public String getNumeroCarnet() {
		return this.numeroCarnet;
	}

	public void setNumeroCarnet(String numeroCarnet) {
		this.numeroCarnet = numeroCarnet;
	}

	public Integer getNumeroHijos() {
		return this.numeroHijos;
	}

	public void setNumeroHijos(Integer numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public Integer getNumeroMiembroFamilia() {
		return this.numeroMiembroFamilia;
	}

	public void setNumeroMiembroFamilia(Integer numeroMiembroFamilia) {
		this.numeroMiembroFamilia = numeroMiembroFamilia;
	}

	public Integer getNumeroVecesQuedado() {
		return this.numeroVecesQuedado;
	}

	public void setNumeroVecesQuedado(Integer numeroVecesQuedado) {
		this.numeroVecesQuedado = numeroVecesQuedado;
	}

	public String getObservacionGraduado() {
		return this.observacionGraduado;
	}

	public void setObservacionGraduado(String observacionGraduado) {
		this.observacionGraduado = observacionGraduado;
	}

	public String getObservacionMateria() {
		return this.observacionMateria;
	}

	public void setObservacionMateria(String observacionMateria) {
		this.observacionMateria = observacionMateria;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOcupacionMadre() {
		return this.ocupacionMadre;
	}

	public void setOcupacionMadre(String ocupacionMadre) {
		this.ocupacionMadre = ocupacionMadre;
	}

	public String getOcupacionPadre() {
		return this.ocupacionPadre;
	}

	public void setOcupacionPadre(String ocupacionPadre) {
		this.ocupacionPadre = ocupacionPadre;
	}

	public Boolean getPagoMatricula() {
		return this.pagoMatricula;
	}

	public void setPagoMatricula(Boolean pagoMatricula) {
		this.pagoMatricula = pagoMatricula;
	}

	public Integer getPaisId() {
		return this.paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	public String getPaisT3n() {
		return this.paisT3n;
	}

	public void setPaisT3n(String paisT3n) {
		this.paisT3n = paisT3n;
	}

	public String getPaisT4n() {
		return this.paisT4n;
	}

	public void setPaisT4n(String paisT4n) {
		this.paisT4n = paisT4n;
	}

	public String getParentescoReferencia() {
		return this.parentescoReferencia;
	}

	public void setParentescoReferencia(String parentescoReferencia) {
		this.parentescoReferencia = parentescoReferencia;
	}

	public String getPasswordEmail() {
		return this.passwordEmail;
	}

	public void setPasswordEmail(String passwordEmail) {
		this.passwordEmail = passwordEmail;
	}

	public Boolean getPerdioSubsidio() {
		return this.perdioSubsidio;
	}

	public void setPerdioSubsidio(Boolean perdioSubsidio) {
		this.perdioSubsidio = perdioSubsidio;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public double getPorcentajeDiscapacidad() {
		return this.porcentajeDiscapacidad;
	}

	public void setPorcentajeDiscapacidad(double porcentajeDiscapacidad) {
		this.porcentajeDiscapacidad = porcentajeDiscapacidad;
	}

	public String getPremios() {
		return this.premios;
	}

	public void setPremios(String premios) {
		this.premios = premios;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public Integer getProfesionId() {
		return this.profesionId;
	}

	public void setProfesionId(Integer profesionId) {
		this.profesionId = profesionId;
	}

	public Boolean getProfesorTutor() {
		return this.profesorTutor;
	}

	public void setProfesorTutor(Boolean profesorTutor) {
		this.profesorTutor = profesorTutor;
	}

	public double getPromedioGraduacion() {
		return this.promedioGraduacion;
	}

	public void setPromedioGraduacion(double promedioGraduacion) {
		this.promedioGraduacion = promedioGraduacion;
	}

	public Integer getProvinciaColegioId() {
		return this.provinciaColegioId;
	}

	public void setProvinciaColegioId(Integer provinciaColegioId) {
		this.provinciaColegioId = provinciaColegioId;
	}

	public Integer getProvinciaId() {
		return this.provinciaId;
	}

	public void setProvinciaId(Integer provinciaId) {
		this.provinciaId = provinciaId;
	}

	public Integer getProvinciaNacimientoId() {
		return this.provinciaNacimientoId;
	}

	public void setProvinciaNacimientoId(Integer provinciaNacimientoId) {
		this.provinciaNacimientoId = provinciaNacimientoId;
	}

	public String getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(String publicaciones) {
		this.publicaciones = publicaciones;
	}

	public String getRegistroConesupT3n() {
		return this.registroConesupT3n;
	}

	public void setRegistroConesupT3n(String registroConesupT3n) {
		this.registroConesupT3n = registroConesupT3n;
	}

	public String getRegistroConesupT4n() {
		return this.registroConesupT4n;
	}

	public void setRegistroConesupT4n(String registroConesupT4n) {
		this.registroConesupT4n = registroConesupT4n;
	}

	public String getRevisadoPor() {
		return this.revisadoPor;
	}

	public void setRevisadoPor(String revisadoPor) {
		this.revisadoPor = revisadoPor;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Integer getRolId() {
		return this.rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSeminarios() {
		return this.seminarios;
	}

	public void setSeminarios(String seminarios) {
		this.seminarios = seminarios;
	}

	public Integer getSexoId() {
		return this.sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
	}

	public Integer getSfGuardUserId() {
		return this.sfGuardUserId;
	}

	public void setSfGuardUserId(Integer sfGuardUserId) {
		this.sfGuardUserId = sfGuardUserId;
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getTalleres() {
		return this.talleres;
	}

	public void setTalleres(String talleres) {
		this.talleres = talleres;
	}

	public String getTelefonoContacto() {
		return this.telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getTelefonoDomicilio() {
		return this.telefonoDomicilio;
	}

	public void setTelefonoDomicilio(String telefonoDomicilio) {
		this.telefonoDomicilio = telefonoDomicilio;
	}

	public String getTelefonoMadre() {
		return this.telefonoMadre;
	}

	public void setTelefonoMadre(String telefonoMadre) {
		this.telefonoMadre = telefonoMadre;
	}

	public String getTelefonoPadre() {
		return this.telefonoPadre;
	}

	public void setTelefonoPadre(String telefonoPadre) {
		this.telefonoPadre = telefonoPadre;
	}

	public String getTelefonoReferencia() {
		return this.telefonoReferencia;
	}

	public void setTelefonoReferencia(String telefonoReferencia) {
		this.telefonoReferencia = telefonoReferencia;
	}

	public String getTelefonoTrabajo() {
		return this.telefonoTrabajo;
	}

	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}

	public String getTesis() {
		return this.tesis;
	}

	public void setTesis(String tesis) {
		this.tesis = tesis;
	}

	public String getTiempoTrabajo() {
		return this.tiempoTrabajo;
	}

	public void setTiempoTrabajo(String tiempoTrabajo) {
		this.tiempoTrabajo = tiempoTrabajo;
	}

	public String getTieneHijos() {
		return this.tieneHijos;
	}

	public void setTieneHijos(String tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

	public Integer getTipoAlumno() {
		return this.tipoAlumno;
	}

	public void setTipoAlumno(Integer tipoAlumno) {
		this.tipoAlumno = tipoAlumno;
	}

	public Integer getTipoBecasId() {
		return this.tipoBecasId;
	}

	public void setTipoBecasId(Integer tipoBecasId) {
		this.tipoBecasId = tipoBecasId;
	}

	public Integer getTipoColegioId() {
		return this.tipoColegioId;
	}

	public void setTipoColegioId(Integer tipoColegioId) {
		this.tipoColegioId = tipoColegioId;
	}

	public Integer getTipoDiscapacidadId() {
		return this.tipoDiscapacidadId;
	}

	public void setTipoDiscapacidadId(Integer tipoDiscapacidadId) {
		this.tipoDiscapacidadId = tipoDiscapacidadId;
	}

	public String getTipoHorario() {
		return this.tipoHorario;
	}

	public void setTipoHorario(String tipoHorario) {
		this.tipoHorario = tipoHorario;
	}

	public Integer getTipoSangreId() {
		return this.tipoSangreId;
	}

	public void setTipoSangreId(Integer tipoSangreId) {
		this.tipoSangreId = tipoSangreId;
	}

	public String getTipoSanguineo() {
		return this.tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public Integer getTipoViviendaId() {
		return this.tipoViviendaId;
	}

	public void setTipoViviendaId(Integer tipoViviendaId) {
		this.tipoViviendaId = tipoViviendaId;
	}

	public String getTitulo3Nivel() {
		return this.titulo3Nivel;
	}

	public void setTitulo3Nivel(String titulo3Nivel) {
		this.titulo3Nivel = titulo3Nivel;
	}

	public String getTitulo4Nivel() {
		return this.titulo4Nivel;
	}

	public void setTitulo4Nivel(String titulo4Nivel) {
		this.titulo4Nivel = titulo4Nivel;
	}

	public String getTituloBachiller() {
		return this.tituloBachiller;
	}

	public void setTituloBachiller(String tituloBachiller) {
		this.tituloBachiller = tituloBachiller;
	}

	public String getTituloUniversitarioAnterior() {
		return this.tituloUniversitarioAnterior;
	}

	public void setTituloUniversitarioAnterior(String tituloUniversitarioAnterior) {
		this.tituloUniversitarioAnterior = tituloUniversitarioAnterior;
	}

	public String getTrabaja() {
		return this.trabaja;
	}

	public void setTrabaja(String trabaja) {
		this.trabaja = trabaja;
	}

	public String getUltimoAnioAnterior() {
		return this.ultimoAnioAnterior;
	}

	public void setUltimoAnioAnterior(String ultimoAnioAnterior) {
		this.ultimoAnioAnterior = ultimoAnioAnterior;
	}

	public String getUniversidadAnterior() {
		return this.universidadAnterior;
	}

	public void setUniversidadAnterior(String universidadAnterior) {
		this.universidadAnterior = universidadAnterior;
	}

	public Integer getUniversidadId() {
		return this.universidadId;
	}

	public void setUniversidadId(Integer universidadId) {
		this.universidadId = universidadId;
	}

	public String getUniversidadT3n() {
		return this.universidadT3n;
	}

	public void setUniversidadT3n(String universidadT3n) {
		this.universidadT3n = universidadT3n;
	}

	public String getUniversidadT4n() {
		return this.universidadT4n;
	}

	public void setUniversidadT4n(String universidadT4n) {
		this.universidadT4n = universidadT4n;
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

	public Boolean getValidarContinuidad() {
		return this.validarContinuidad;
	}

	public void setValidarContinuidad(Boolean validarContinuidad) {
		this.validarContinuidad = validarContinuidad;
	}

	public Boolean getValidarEmail() {
		return this.validarEmail;
	}

	public void setValidarEmail(Boolean validarEmail) {
		this.validarEmail = validarEmail;
	}

	public Integer getZonaId() {
		return this.zonaId;
	}

	public void setZonaId(Integer zonaId) {
		this.zonaId = zonaId;
	}

}
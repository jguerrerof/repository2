package main.java.controllers;
 
 
import java.sql.Connection;




import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
 
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

import main.java.DTO.usuarioDTO;
import main.java.utils.JPAUtil;
import main.java.utils.UtilidadesVarias;
import main.java.utils.pruebaDAO;
 
 

@ManagedBean(name="loginBean")
public class loginBean { 

	  
	private int usuarioActivosLogin=0;
 
	private String nombreUsuario;
	
	 

	private String passWeb;

	private boolean visible;

	public String usname;
	 
	public String nombre;
	
	public String apell;
	
	private String param="0";
	
	public boolean authCorrecta=false;
	
	public String anioActivo="";
	public String periodoActivo="";
	
	private Map<String,List<String>> usuario_permisosGralLogin = new HashMap<String, List<String>>();
	
	
	public String urlIngresoInfo;

	public HtmlOutputText text = new HtmlOutputText();
	
	private int admisionActivos=0;	
	
	private String admisionActivosStr="Roles";	
 
	
 
	 
	/* public loginBean() {	
		 
		System.out.println("aki en el inicio de login beeeeean NUEVO NUEVO 123");
		 
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean")!=null)
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		 
		/*CcmgUsuariosAplicativo usuario2 = new CcmgUsuariosAplicativo();
		usuario2.setCodigoUsuario("");		 
		setUsuario(usuario2);		
		setPassWeb(""); 		
		setNombre("");
		setApell("");*/
		//return "inicio";  
	//} 
	

	public String cambiarClave() {
		return "cambioClave?faces-redirect=true";
	}
	 
	
	public String misivision() {
		return "misionvision?faces-redirect=true";
	}
	 
	
	public String loginpantalla() {
		return "login?faces-redirect=true";
	}
	 
	 
	  
	public String login() {
		
		
		java.util.Date today = new java.util.Date();
		String dia = UtilidadesVarias.getDayFromDate(today);
		String mes = UtilidadesVarias.getMonthFromDate(today);
		String anio = UtilidadesVarias.getYearFromDate(today);
		
		setAnioActivo(anio);
		setPeriodo("1");
		if(mes!=null){
			if(mes.equals(""))
			{
			  int p=new Integer(mes).intValue();
			  if(p>9)
				  setPeriodo("2");
			}
		}
		
		
		System.out.println("inicio del sistema - inciio"+anio+mes);
		
		String link="";
		
		System.out.println("get nombre artesanal:"+ getNombreUsuario());
		
		/* FacesContext context = FacesContext.getCurrentInstance();
         
	        context.addMessage(FacesMessage.SEVERITY_INFO.toString(), new FacesMessage("Successful",  "Your message: " + "holass") );*/
		
		String username=getNombreUsuario();
		String pass=getPassWeb();

				
			FacesContext context = FacesContext.getCurrentInstance();
			
			if(getNombreUsuario().equals("") || getPassWeb().equals(""))
				{
				context.addMessage(null, new FacesMessage("Verifique el Usuario y Clave ingresado",  "Debe ingresar su usuario y clave de acceso") );
				
				}
			else
				{
				
								
			    try { 
			    	
			    	/*String activedirectory="";			    	
			    	EntityManager emf = new JPAUtil().getEntityManager();
					Map<String, Object> properEmf = new HashMap<String, Object>();
					properEmf = emf.getProperties();
					if (properEmf != null) activedirectory = properEmf.get("javax.persistence.jdbc.activedirectory").toString();
				 				    	
			    	ActiveDirectoryAuthentication authentication = new ActiveDirectoryAuthentication(activedirectory);//10.2.0.2//OU=oulaica,DC=local,DC=ulvr,DC=edu,DC=ec 
			        boolean authResult = authentication.authenticate(username, pass);*/
			        
			        if(true){
			        	link= "dashboard?faces-redirect=true";	
			        	admisionActivos=0;
			        	admisionActivosStr="Roles (0)";
			        	 setAuthCorrecta(true);
			        	/* usuariostodos("2");
			        	  variosRolesEst();
			        	 int h=getAdmisionActivos();
			        	 if(h>0) admisionActivosStr="Roles ("+new Integer(h).toString()+")";
			        		 
			        	 */
			        }
			        else
			        {			        	
			        	context.addMessage(null, new FacesMessage("Verifique que su usuario y clave estén correctas.",  "Debe ingresar su usuario y clave de acceso.") );
			        }			        
			        System.out.print(link + "Auth login bean: ");
			    } catch (Exception e) {
			    	System.out.println("catch del login ");
			        e.printStackTrace();
			        
			        System.out.println("cause:"+e.getCause());
			        
			        
			        context.addMessage(null, new FacesMessage("Verifique que su usuario y clave estén correctas o que su usuario no haya expirado",  "Debe ingresar su usuario y clave de acceso") );
			    }
				
				
				}
			
	        return link;
	    
		   
			// return "welcome";	
		
	}
	 
	 

	public List<usuarioDTO> variosRolesEst(){
		
		List<usuarioDTO> list = new ArrayList<usuarioDTO>();	   
 
		 
		EntityManager emf = new JPAUtil().getEntityManager();
		try {					 
			Map<String, Object> properEmf = new HashMap<String, Object>();
			properEmf = emf.getProperties();
			System.out.println("prop-->"+properEmf);
			String url = ""; 
			String usr = "";   
			String pass = "";
			if (properEmf != null) {
				url = properEmf.get("javax.persistence.jdbc.url").toString(); 
				usr = properEmf.get("javax.persistence.jdbc.user").toString();
				pass = properEmf.get("javax.persistence.jdbc.password").toString();
			}			   
		emf.close();		 
		Connection conn = DriverManager.getConnection(url, usr, pass);		
		Statement stmt = conn.createStatement();
		 String query="SELECT t.descrip FROM tabla@eeq t WHERE t.nomtabla like 'TIPCL'";	
		 
		 
		 query="select distinct(u.id),u.nombres,u.apellidos,sgu.username,u.identificacion,count(*) "+
			   "from sf_guard_user sgu, sf_guard_user_permission p,usuario u, sf_guard_permission per "+
			   "where sgu.id=p.user_id "+
			   "and p.permission_id NOT in (2) "+
			   "and sgu.is_active=true "+
			   "and u.sf_guard_user_id=sgu.id "+
			   "and u.sf_guard_user_id=p.user_id "+ 
			   "and per.id=p.permission_id "+
			   "group by u.id,u.nombres,u.apellidos,sgu.username,u.identificacion order by 6 desc";
		 
		  
		 query="select distinct(u.id),u.nombres,u.apellidos,sgu.username,u.identificacion "+
		 "from sf_guard_user sgu, sf_guard_user_permission p,usuario u, sf_guard_permission per "+ 
		 "where sgu.id=p.user_id  "+
		 "and p.permission_id in (1,3,14,32,33,34,36,37,38,39,40,41) "+
		 "and sgu.is_active=true  "+
		 "and u.sf_guard_user_id=sgu.id  "+
		 "and u.sf_guard_user_id=p.user_id  "+
		 "and per.id=p.permission_id  "+
		 "and sgu.id in ( "+
		 "select distinct(sgu.id)  "+
		 "from sf_guard_user sgu, sf_guard_user_permission p,usuario u, sf_guard_permission per  "+
		 "where sgu.id=p.user_id  "+
		 "and p.permission_id in (2)  "+
		 "and sgu.is_active=true  "+
		 "and u.sf_guard_user_id=sgu.id  "+
		 "and u.sf_guard_user_id=p.user_id  "+
		 "and per.id=p.permission_id  "+
		 ") "+
		 "order by sgu.username ";
		 
		 boolean primera=true;
				  
		 
		ResultSet rs = stmt.executeQuery(query);  		 
		while(rs.next())
		{ 	
			String nombre="";
			String apellidos="";
			String cantidad="";
			String username="";
			String identificacion="";
			 
			if(rs.getObject(2)!=null)	nombre=rs.getObject(2).toString();			
			if(rs.getObject(3)!=null)	apellidos=rs.getObject(3).toString();
			if(rs.getObject(4)!=null)	username=rs.getObject(4).toString();
			if(rs.getObject(5)!=null)	identificacion=rs.getObject(5).toString();
		 
			
			List<String> perm = new ArrayList<String>();			
			if(usuario_permisosGralLogin.get(identificacion)!=null)	{
				perm=usuario_permisosGralLogin.get(identificacion);
				if(perm.contains("admision") || perm.contains("admin")  ) admisionActivos++;
			}
			
	  
				
			 
					usuarioDTO tempo = new usuarioDTO("usuario",username,identificacion,nombre,apellidos,"",perm,"","");
					 
					
					 list.add(tempo);
				 
			 
			 
		}
		
		 
		 
		 
		
		if(!conn.isClosed())	 conn.close();
		
		if(emf.isOpen())		 emf.close();
		 
	}catch (Exception e) {
		// TODO: handle exception
		
		System.out.println("erroooor C rol estudiantes ->"+e.toString());
		if(emf.isOpen())		 emf.close();
		
	}
				
		 return list;
		
	}
	
	
/*
	   public List<usuarioDTO> usuariostodos(String permisoEstudiante) {	   
		   	   
		   List<usuarioDTO> list = new ArrayList<usuarioDTO>();	   
	 
		   List<usuarioDTO> usuarios_final = new ArrayList<usuarioDTO>();
		   EntityManager emf = new JPAUtil().getEntityManager();
			try {					 
				Map<String, Object> properEmf = new HashMap<String, Object>();
				properEmf = emf.getProperties();
				
				String url = ""; 
				String usr = "";   
				String pass = "";
				if (properEmf != null) {
					url = properEmf.get("javax.persistence.jdbc.url").toString(); 
					usr = properEmf.get("javax.persistence.jdbc.user").toString();
					pass = properEmf.get("javax.persistence.jdbc.password").toString();
				}			   
			emf.close();		
			Connection conn = DriverManager.getConnection(url, usr, pass);		
			Statement stmt = conn.createStatement();
			 String query="SELECT t.descrip FROM tabla@eeq t WHERE t.nomtabla like 'TIPCL'";				 
			 query="select u.identificacion,u.nombres, u.apellidos,p.name,sgu.created_at,sgu.last_login,sgu.username "+
					"from sf_guard_user sgu, sf_guard_user_permission sgup,usuario u,sf_guard_permission p "+					 
					 "where sgu.id=sgup.user_id and sgu.is_active=true and p.id=sgup.permission_id "+
					 "and sgup.permission_id NOT in ("+permisoEstudiante+") and u.sf_guard_user_id=sgu.id and u.sf_guard_user_id=sgup.user_id";
					 
			 
			ResultSet rs = stmt.executeQuery(query);  		 
			while(rs.next())
			{ 					         
				String cedula="";
				String nombres="";
				String apellidos="";
				String alumnoId="";
				String nota="";
				String permisos="";
				String createdAt="";
				String lastlogin="";
				String username="";
				
				
				if(rs.getObject(1)!=null)	cedula=rs.getObject(1).toString();
				if(rs.getObject(2)!=null)	nombres=rs.getObject(2).toString();
				if(rs.getObject(3)!=null)	apellidos=rs.getObject(3).toString();
				if(rs.getObject(4)!=null)	permisos=rs.getObject(4).toString();
				if(rs.getObject(5)!=null)	createdAt=rs.getObject(5).toString();
				if(rs.getObject(6)!=null)	lastlogin=rs.getObject(6).toString();
				if(rs.getObject(7)!=null)	username=rs.getObject(7).toString();
				
				if(usuario_permisosGralLogin.get(cedula)==null)
				{
					//agrego en list
					 List<String> perm = new ArrayList<String>();
					 perm.add(permisos);				
					 usuario_permisosGralLogin.put(cedula, perm);
					 usuarioDTO tempo = new usuarioDTO("usuario",username,cedula,nombres,apellidos,permisos,perm,createdAt,lastlogin);
					 list.add(tempo);
				}
				else
				{
					//tomo cedula y agrego el list de has				
					 List<String> perm = new ArrayList<String>();
					 perm=usuario_permisosGralLogin.get(cedula);
					 perm.add(permisos);
					 usuario_permisosGralLogin.put(cedula, perm);				 				
				}
			}
			
			if(!conn.isClosed())	 conn.close();
			
			if(emf.isOpen())		 emf.close();
			 
		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("erroooor C a->"+e.toString());
			if(emf.isOpen())		 emf.close();
			
		}
			//recorro el resultadao para agrupar los que tienen mas de un rol
			Iterator ithhMeses3 = list.iterator();
			int p=0;
			while (ithhMeses3.hasNext()) {
				     
				 usuarioDTO tempo = (usuarioDTO) ithhMeses3.next();			
				 List<String> perm = new ArrayList<String>();
				 perm=usuario_permisosGralLogin.get(tempo.getIdentificacion());		 
				 usuarioDTO tempofinal = new usuarioDTO("usuario","",tempo.getIdentificacion(),tempo.getNombres(),tempo.getApellidos(),"",perm,tempo.getFechaCreacion(),tempo.getFechaUltimoAcceso());
				 usuarios_final.add(tempofinal);  
				 p++;   
			}
			
			int h=usuarios_final.size();				
			setUsuarioActivosLogin(h);	
			return usuarios_final;
	} 
	   
	*/
	 
	public String configuracion(String p) {
		
		System.out.println("inicio del sistema");
		
		setParam("2");
		
		return "configuracion?faces-redirect=true";
	}
	
	
	  
		public String permisos(String p) {
		
			
			setParam("1");
			
			System.out.println("inicio del sistema");
			
			return "permisos?faces-redirect=true";
		}
		
		 
	
	public String usuario( String p) {
		
		System.out.println("inicio del sistema - usuario:::");
		
		setParam("0");
		
		return "usuario?faces-redirect=true";
	}
	
	 
	
	public String inicioSistema() {	
		System.out.println("inicio del sistema");
		/*if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean")!=null)
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginBean",null);	
		*/
		//setc(null);		
		setPassWeb("");
		
		//return "inicio";
		return "inicio?faces-redirect=true";
	}
	 
	
	
	 
	public String cienciasMenu() {		 
		return "ciencias?faces-redirect=true";
	}
	
	//academico,ciencia,economico,infraestructura,sociedad,vinculación
	
	///////////////////////////////////////////////////////// PRIMER MENÚ //////////////////////////////////
	public String academicoMenu() {		 
		return "welcomeAcademico?faces-redirect=true";
	}
	
					public String estudiantesMenu() {	
						System.out.println("salir del a sistema");		
						return "graduadosEstudiantes?faces-redirect=true";					
					}					
					
					public String docentesMenu() {	
						System.out.println("salir del a sistema");		
						return "docentes?faces-redirect=true";					
					}
					
					public String postulantesMenu() {	
						System.out.println("salir del a sistema EN  POSTULANTES MENUUUUU");
						return "postulantes?faces-redirect=true";					
					} 
					
					public String conveniosMenu() {	 
						System.out.println("salir del a sistema");		
						return "conveniosFacultades?faces-redirect=true";					
					}
					
					public String fortalecimientoMenu() {	
						System.out.println("salir del a sistema");		
						return "fortalecimiento?faces-redirect=true";					
					}

	/////////////////////////////////////////////////////////////// 2
	
	public String cienciaMenu() {		 
		 
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("CienciaBean")!=null)
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("CienciaBean",null);	
		
		return "ciencia?faces-redirect=true";
	}
	
	
	
	/////////////////////////////////////////////////////////////// 3
	
	public String economicoMenu() {		
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("EconomicoBean")!=null)
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("EconomicoBean",null);	
		    
		return "economico?faces-redirect=true";
	}
	
	
	///////////////////////////////////////////////////////////// 4	
	public String infraestructuraMenu() {	
		   
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("InfraestructuraBean")!=null)
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("InfraestructuraBean",null);
		
		return "infraestructura?faces-redirect=true";
	}
	
	
	///////////////////////////////////////////////////////////// 5
	public String sociedadMenu() {		
		 
		  
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("SociedadBean")!=null)
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SociedadBean",null);
		
		return "sociedad?faces-redirect=true";
	}
	    
	      
	
	///////////////////////////////////////////////////////////// 6
	public String vinculacionMenu() {		
		     
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("VinculacionBean")!=null)
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("VinculacionBean",null);
		
		return "vinculacion?faces-redirect=true";
	}
	 
	
	///////////////////////////////////////////////////////////// 7	
	public String socialMenu() {		
		return "social?faces-redirect=true";
	}
	
	
	
	public String administrativoMenu() {		
		return "administrativo?faces-redirect=true";
	}
	
	 
	public String ces() {	 	
		return "ces?faces-redirect=true";
	}
	
	
	public String welcome() {		
		return "welcome?faces-redirect=true";
	}
	    
	public String salirSistema() {
		
		setAuthCorrecta(false);
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean")!=null)
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginBean",null);
		
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioView")!=null)
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioView",null);

		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("rolesView")!=null)
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rolesView",null);

		 
		FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
	    
	    request.getSession().invalidate();
		
		return "login?faces-redirect=true";
	}
	
	public String iniciar() {	
		System.out.println("salir del a sistema");		
		return "iniciar?faces-redirect=true";
		//return "inicio";
	}

	public String misionMenu() {	
		System.out.println("salir del a sistema");		
		return "misionvision?faces-redirect=true";
		//return "inicio";
	}

		
	
	public String produccionesMenu() {	
		System.out.println("salir del a sistema");		
		//return "actividades?faces-redirect=true";
		return "producciones?faces-redirect=true";
		//return "inicio";
	}
	 

	public String ingresa() { 
		
		System.out.println("aca intentando ingresar al sistema 1.1 errb en ingresa");		
		pruebaDAO dao = new pruebaDAO(); 
		String cript=dao.getStringEncrip(passWeb);
		
		System.out.println("cript--"+cript+"z----"); 
		
		
		setVisible(true);
		visible=true;
	 
			if (!cript.equals("")){ 
				visible=true;	
				setVisible(true);	
				System.out.println("dentro del passOK:"+FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean"));
				
				return "welcome";	
			}
			else{
				setVisible(false);
				visible=false;
				text.setValue("Verifique los datos ingresados. Clave incorrecta.");
				if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean")!=null)
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginBean",null);				
				return "";
				}
	}
 


	public String handleLoginVarios(ActionEvent actionEvent) {		
		System.out.println("handle login aqui");		
		return "inicio?faces-redirect=true";
	}
	 
	
	public HtmlOutputText getText() {
		return text;
	}

	public void setText(HtmlOutputText text) {
		this.text = text;
	}

	 

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getUsname() {
		return usname;
	}

	public void setUsname(String usname) {
		this.usname = usname;
	}
 

	public String getPassWeb() {
		return passWeb;
	}

	public void setPassWeb(String passWeb) {
		this.passWeb = passWeb;
	}



	public String getUrlIngresoInfo() {
		return urlIngresoInfo;
	}



	public void setUrlIngresoInfo(String urlIngresoInfo) {
		this.urlIngresoInfo = urlIngresoInfo;
	}


	public String getNombre() {
		return nombre; 
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApell() {
		return apell;
	}


	public void setApell(String apell) {
		this.apell = apell;
	}

	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@PostConstruct
	void initialiseSession() {
	    FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}
	
	 
	public String ulvrcentro() {	
		return "reporteUno?faces-redirect=true";
		// return "reporteUno";		
	}


	public String getParam() {
		return param;
	}


	public void setParam(String param) {
		this.param = param;
	}


	public boolean isAuthCorrecta() {
		return authCorrecta;
	}


	public void setAuthCorrecta(boolean authCorrecta) {
		this.authCorrecta = authCorrecta;
	}


	public String getAnioActivo() {
		return anioActivo;
	}


	public void setAnioActivo(String anioActivo) {
		this.anioActivo = anioActivo;
	}


	public String getPeriodoActivo() {
		return periodoActivo;
	}


	public void setPeriodo(String periodoActivo) {
		this.periodoActivo = periodoActivo;
	}


	public void setPeriodoActivo(String periodoActivo) {
		this.periodoActivo = periodoActivo;
	}


	public Map<String, List<String>> getUsuario_permisosGralLogin() {
		return usuario_permisosGralLogin;
	}


	public void setUsuario_permisosGralLogin(Map<String, List<String>> usuario_permisosGralLogin) {
		this.usuario_permisosGralLogin = usuario_permisosGralLogin;
	}


	public int getAdmisionActivos() {
		return admisionActivos;
	}


	public void setAdmisionActivos(int admisionActivos) {
		this.admisionActivos = admisionActivos;
	}


	public int getUsuarioActivosLogin() {
		return usuarioActivosLogin;
	}


	public void setUsuarioActivosLogin(int usuarioActivosLogin) {
		this.usuarioActivosLogin = usuarioActivosLogin;
	}


	public String getAdmisionActivosStr() {
		return admisionActivosStr;
	}


	public void setAdmisionActivosStr(String admisionActivosStr) {
		this.admisionActivosStr = admisionActivosStr;
	}
	
	
  
	
}

/*

        private String username;

        private String password;

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public void login(ActionEvent actionEvent) {
                RequestContext context = RequestContext.getCurrentInstance();
                FacesMessage msg = null;
                boolean loggedIn = false;

                if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
                        loggedIn = true;
                        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
                } else {
                        loggedIn = false;
                        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
                }

                FacesContext.getCurrentInstance().addMessage(null, msg);
                context.addCallbackParam("loggedIn", loggedIn);
        }




}*/

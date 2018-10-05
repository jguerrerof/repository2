package main.java.controllers;


import javax.annotation.PostConstruct;
 
import javax.faces.bean.ManagedBean;
 
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

 
import main.java.utils.pruebaDAO;
 
 

@ManagedBean(name="menuView")
public class MenuView { 

	  

	private String password;
	
	private String nombreUsuario;
	
	 

	private String passWeb;

	private boolean visible;

	public String usname;
	 
	public String nombre;
	
	public String apell;
	
	
	
	public String urlIngresoInfo;

	public HtmlOutputText text = new HtmlOutputText();

 
	 
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
	
	  
	public String mensaje() {
		
		System.out.println("inicio del sistema");
		
		return "home?faces-redirect=true";
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
		return "fin?faces-redirect=true";
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

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

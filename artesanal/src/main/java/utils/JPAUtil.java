package main.java.utils;

import java.io.IOException;




import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil { 
	 
	 EntityManagerFactory emf =
			 Persistence.createEntityManagerFactory("persistenceUnitName");
	 
//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAService");
    //public static EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("dos");
/*
 * 
 * 
 public EntityManager getEntityManager(String prueba) {
	 
	 EntityManager entidad=null; 
	 
	 System.out.println("aca en entity manager 1 ");
	 
	 if(prueba!=null){ 
		 if(prueba.equals("1"))	 entidad= emf.createEntityManager();
		  if(prueba.equals("2"))  entidad= emf2.createEntityManager();
	 }
	 
	 
	 return entidad;
	 
 }*/ 
 
  public EntityManager getEntityManager() {
	  EntityManager a=null;
	  try{
		  
		  System.out.println("EN GETENTITYMANAGER1");
		  
		  System.out.println("EN GETENTITYMANAGER2"+emf.getProperties());
		  
		  a=emf.createEntityManager();  
		  
		   System.out.println("EN GETENTITYMANAGER3"); 
		      
  }catch (Exception e) {
		//  System.out.println("error de conexiónabc- 2016 --!!!!."+e.toString());     
		  System.out.println("error de conexiónabc- 2016 --!!!!."+e.hashCode());
		  
		//FacesContext.getCurrentInstance ().getExternalContext().Redirect ("/jsp/page2.jsp");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("errorA.xhtml");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	  }
	finally {
		 //System.out.println("error de conexiónb.");
	}
	 return a;
	 } 
 
}
//   jdbc:oracle:thin:@191.9.200.165:1521:PRGIS
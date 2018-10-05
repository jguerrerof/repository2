package main.java.utils;

import java.math.BigDecimal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

 
import main.java.utils.JPAUtil;
 
 
public class pruebaDAO   {

 
	public String getStringEncrip(String cadena){		
		String encriptado="okkk";		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ulvrinforme");
		EntityManager em2 = emf.createEntityManager();		
		em2.getTransaction().begin();
		 try{ 
		String formarQuery2 = "select S.idgentDesc,S.idgentPadreid "+
		"from Swidg001 S ";
	 	  
		Query queryDivision232 = em2.createQuery(formarQuery2);
		List resultListMeses = queryDivision232.getResultList();
		Iterator ithhMeses = resultListMeses.iterator();
		boolean ac=true;
		while (ithhMeses.hasNext()) {
			Object[] tuple = (Object[]) ithhMeses.next();	
			
			String thdl1  = (String) tuple[0];					  
			Integer thdl2  = (Integer) tuple[1];
		  
			System.out.println("thdl1:"+thdl1);
			System.out.println("thdl2:"+thdl2); 
			
		} 
		 }
			finally {
				   em2.close();
				 } 
	 
		return encriptado;
	}
	
	public String getStringEncrip2(String cadena){		
		String encriptado="";		
		EntityManager em = new JPAUtil().getEntityManager();
		try {			
			Map<String, Object> properEmf = new HashMap<String, Object>();
			properEmf = em.getProperties();
			String url = "";
			String usr = "";
			String pass = "";
			if (properEmf != null) {
				url = properEmf.get("javax.persistence.jdbc.url").toString();
				usr = properEmf.get("javax.persistence.jdbc.user").toString();
				pass = properEmf.get("javax.persistence.jdbc.password")
				.toString();
			}
			em.close();
			java.sql.DriverManager.registerDriver(new com.mysql.jdbc.Driver());		
			Connection conn = DriverManager.getConnection(url, usr, pass);		
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from swidg");	    
			while(rs.next())
			{
				if(rs.getObject(1)!=null){	    
					 
					System.out.println("rs.getObject(1)->"+rs.getObject(1));
					encriptado = rs.getObject(1).toString();	    	
				}  
				 
			}
			if(em.isOpen())
			 {
				 em.flush();
			 }
		}catch (Exception e) {
			// TODO: handle exception
			if(em.isOpen())
			 {
				 em.flush();
			 }
		}
		return encriptado;
	}
	
}

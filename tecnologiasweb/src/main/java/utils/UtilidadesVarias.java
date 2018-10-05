package main.java.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.Query;

 
/** 
@author jguerrero
@Tropidatos/E.E   
01/feb/2011 
**/

public class UtilidadesVarias {


	public static String mesNumeroLetra(String numero){
		
		String letra="";
		
	 
		if(numero.equals("01") || numero.equals("1")) letra="Enero";
		else if(numero.equals("02") || numero.equals("2") ) letra="Febrero";
		else if(numero.equals("03") || numero.equals("3")) letra="Marzo";
		else if(numero.equals("04") || numero.equals("4")) letra="Abril";
		else if(numero.equals("05") || numero.equals("5")) letra="Mayo";
		else if(numero.equals("06") || numero.equals("6")) letra="Junio";
		else if(numero.equals("07") || numero.equals("7")) letra="Julio";
		else if(numero.equals("08") || numero.equals("8")) letra="Agosto";
		else if(numero.equals("09") || numero.equals("9")) letra="Septiembre";
		else if(numero.equals("10")) letra="Octubre";
		else if(numero.equals("11")) letra="Noviembre";
		else if(numero.equals("12")) letra="Diciembre";
		else letra="-";
			 
		
		return letra;
	}
	  

	public static String formato0dec(String number) { 
		
		Locale.setDefault(Locale.US);
		//Local lcl = new Locale("fr", "FR");
		
		//DecimalFormat frmtr = DecimalFormat.getInstance(lcl);
		DecimalFormat.getInstance( new Locale("us", "US")) ;
		
		double value; 
		String numberFormat = "###,###,###,###"; 
		DecimalFormat formatter = new DecimalFormat(numberFormat); 
		try { 
		value = Double.parseDouble(number); 
		} catch (Throwable t) 
		{ 
		return null;  
		} 
		String f=formatter.format(value);
		 
		
		int numero=3;
		 
		
		return f;
		}
	
	
	public static String getNombreMes(String numero){

		String nombre="";

		if(numero!=null){
			int numMes=new Integer(numero).intValue();
			if(numMes==1) nombre="ENERO";
			if(numMes==2) nombre="FEBRERO";
			if(numMes==3) nombre="MARZO";
			if(numMes==4) nombre="ABRIL";
			if(numMes==5) nombre="MAYO";
			if(numMes==6) nombre="JUNIO";
			if(numMes==7) nombre="JULIO";
			if(numMes==8) nombre="AGOSTO";
			if(numMes==9) nombre="SEPTIEMBRE";
			if(numMes==10) nombre="OCTUBRE";
			if(numMes==11) nombre="NOVIEMBRE";
			if(numMes==12) nombre="DICIEMBRE";	
		}

		return nombre;

	}

	
public static String formato2dec(String number) { 
		
		System.out.println("numer ddddd:"+number);
		
		Locale.setDefault(Locale.US);
		//Local lcl = new Locale("fr", "FR");
		
		//DecimalFormat frmtr = DecimalFormat.getInstance(lcl);
		DecimalFormat.getInstance( new Locale("us", "US")) ;
		
		double value; 
		String numberFormat = "###,###,###,###.##"; 
		DecimalFormat formatter = new DecimalFormat(numberFormat); 
		try { 
		value = Double.parseDouble(number); 
		} catch (Throwable t) 
		{ 
		return null; 
		} 
		String f=formatter.format(value);
		if(!f.contains(".") && !f.contains(","))
			f=f+".00";
		
		if(f.indexOf(".")!=-1)
		{		 
		int numceros=f.substring(f.indexOf(".")).length();	 
		if(numceros==2){
			f=f+"0";
		}
		}
		if(!f.contains("."))
			f=f+".00";
			
			System.out.println("F-->:"+f);
			
		return f;
		}


	public static int calcularMayor(int v1,int v2,int v3) {		
        int m;
        if(v1>v2 && v1>v3) {
          m=v1;
        } else {
            if(v2>v3) {
                m=v2;
            } else {
            	m=v3;
            }
        }
        return m;
    }
    
    public static int calcularMenor(int v1,int v2,int v3) {   
    	
        int m;
        if(v1<v2 && v1<v3) {
          m=v1;
        } else {
            if(v2<v3) {
                m=v2;
            } else {
            	m=v3;
            }
        }
        return m;
    }

	public static java.sql.Date utilDateToSqlDate(java.util.Date uDate) throws ParseException
	{		
		//java.sql.Date sqldate=new java.sql.Date(uDate.getTime());		
		DateFormat sqlDateFormatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");		 
		return java.sql.Date.valueOf(sqlDateFormatter2.format(uDate));
	}


	public static java.util.Date dateHoy() throws ParseException {
		java.util.Date today = new java.util.Date();
		String dia = getDayFromDate(today);
		String mes = getMonthFromDate(today);
		String anio = getYearFromDate(today);
		String hoy = anio + "-" + mes + "-" + dia;
		java.util.Date dateHoy = new SimpleDateFormat("yyyy-MM-dd").parse(hoy);
		return dateHoy;
	}

	public static Date fechaBase(){		
		Date dateIni=null;		
		try {
			EntityManager em = new JPAUtil().getEntityManager();
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
			ResultSet rs = stmt.executeQuery("SELECT SYSDATE FROM DUAL");	    
			while(rs.next())
			{
				if(rs.getObject(1)!=null){	    
					DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	    	
					dateIni = dateFormatter.parse(rs.getObject(1).toString());	    	
				}  
				String x=(String)rs.getObject(1);	     
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dateIni;
	}



	public static String fechaBaseStr(){		
		String dateIni=null;		
		try {
			EntityManager em = new JPAUtil().getEntityManager();
			Map<String, Object> properEmf = new HashMap<String, Object>();
			properEmf = em.getProperties();
			String url = "";
			String usr = "";
			String pass = "";
			if (properEmf != null) {
				url = properEmf.get("javax.persistence.jdbc.url").toString();
				usr = properEmf.get("javax.persistence.jdbc.user").toString();
				pass = properEmf.get("javax.persistence.jdbc.password").toString();
			}
			em.close();
			java.sql.DriverManager.registerDriver(new com.mysql.jdbc.Driver());		
			Connection conn = DriverManager.getConnection(url, usr, pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SYSDATE FROM DUAL");	    
			while(rs.next())
			{
				if(rs.getObject(1)!=null){	    	
					dateIni=rs.getObject(1).toString();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dateIni;
	}

	public static java.util.Date dateHoyCalendar2(){
		Date hoy =null;
		try {
			hoy=fechaBase();			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return hoy;
	}


	public static String getMonthFromDate(java.util.Date d) {
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormatter.format(d).substring(3, 5);
	}

	public static String getYearFromDate(java.util.Date d) {
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormatter.format(d).substring(6, 10);
	}

	public static String getDayFromDate(java.util.Date d) {
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormatter.format(d).substring(0, 2);
	}


	public static Map<String, String> ordenarHashMap3(Map<String, String> hmap) {
		HashMap map = new LinkedHashMap();
		List mapKeys = new ArrayList(hmap.keySet());
		List mapValues = new ArrayList(hmap.values());
		hmap.clear();
		TreeSet sortedSet = new TreeSet(mapValues);
		Object[] sortedArray = sortedSet.toArray();
		int size = sortedArray.length;

		Object key = null;
		Object value = null;
		int index = -1;

		for (int i = 0, l = sortedArray.length; i < l; i++) {
			value = sortedArray[i];
			index = mapValues.indexOf(value);
			key = mapKeys.get(index);

			map.put(key, value);
			mapKeys.remove(index);
			mapValues.remove(value);
		}
		return map;
	}




	public Iterator iterator() {
		//Collection collection = this.values();
		Collection collection = null;

		Object[] array = collection.toArray();
		Arrays.sort(array);
		return Arrays.asList(array).iterator();
	}

	public static Map<String, Map<String, String>> sortHashMapByValuesD(Map<String, Map<String, String>> passedMap) {
		List mapKeys = new ArrayList(passedMap.keySet());
		List mapValues = new ArrayList(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		LinkedHashMap sortedMap =     new LinkedHashMap();

		Iterator valueIt = mapKeys.iterator();
		while (valueIt.hasNext()) {
			Object val = valueIt.next();
			Iterator keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				Object key = keyIt.next();
				String comp1 = passedMap.get(key).toString();
				String comp2 = val.toString();

				if (comp1.equals(comp2)){
					passedMap.remove(key);
					mapKeys.remove(key);
					sortedMap.put((String)key, (Map<String, String>)val);
					break;
				}

			}

		}
		return sortedMap;
	}

	public static Map<String, Map<String, String>> ordenarHashMap4(Map<String, Map<String, String>> hmap) {

		HashMap map = new LinkedHashMap();
		List mapKeys = new ArrayList(hmap.keySet());
		List mapValues = new ArrayList(hmap.values());		
		hmap.clear();

		//TreeSet sortedSet = new TreeSet(mapValues);
		TreeSet sortedSet = new TreeSet(mapKeys);

		Object[] sortedArray = sortedSet.toArray();

		int size = sortedArray.length;

		Object key = null;
		Object valuekeys = null;

		Object vals = null;

		int index = -1;

		for (int i = 0, l = sortedArray.length; i < l; i++) {



			valuekeys = sortedArray[i];
			index = mapKeys.indexOf(valuekeys);
			vals = mapValues.get(index);
			//key = mapKeys.get(index);

			map.put(valuekeys, vals);
			mapKeys.remove(index);
			mapValues.remove(vals);
		}
		return map;
	}



	public static java.util.Date getLastDateFromMonth(java.util.Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}


	public static java.util.Date getFirstDateFromMonth(java.util.Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
	/*
	
		//int dias=new Date(mes).get
		
		java.util.Date today = new java.util.Date();
		today.setYear(new Integer(anio).intValue());
		today.setMonth(new Integer(mes.replaceAll("0","")).intValue());
		
		today.setYear(2011+1900);
		today.setMonth(5+1);
		//today.setDate(1);
		//today.getm
		//today=UtilidadesVarias.getLastDateFromMonth(today);
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(today);
		int h =	calendar.getmActualMinimum(Calendar.DAY_OF_MONTH);
		
		System.out.println(anio+mes+"<----today4-->"+h); 
	*/

	//compara fechas solo año, mes y día
	public static int compararFechas(java.sql.Date fecha1, java.sql.Date fecha2){
		int comparacion = 0;		
		int anioFecha1 = fecha1.getYear();
		int mesFecha1 = fecha1.getMonth();
		int diaFecha1 = fecha1.getDate();
		int anioFecha2 = fecha2.getYear();
		int mesFecha2 = fecha2.getMonth();
		int diaFecha2 = fecha2.getDate();

		if(anioFecha1 > anioFecha2){
			comparacion = 1;
		}else if(anioFecha1 < anioFecha2){
			comparacion = -1;
		}else{
			if(mesFecha1 > mesFecha2){
				comparacion = 1;
			}else if(mesFecha1 < mesFecha2){
				comparacion = -1;
			}else{
				if(diaFecha1 > diaFecha2){
					comparacion = 1;
				}else if(diaFecha1 < diaFecha2){
					comparacion = -1;
				}else{
					comparacion = 0;
				}
			}
		}

		return comparacion;
	}


	public static String md5(String s) {

		String r = null;
		try {
			if (s != null) {

				MessageDigest algorithm =MessageDigest.getInstance("MD5");
				algorithm.reset();
				algorithm.update(s.getBytes());
				byte bytes[] = algorithm.digest();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < bytes.length; i++) {
					String hex = Integer.toHexString(0xff & bytes[i]);
					if (hex.length() == 1)
						sb.append('0');
					sb.append(hex);
				}

				r = sb.toString();
			}
		} catch (NoSuchAlgorithmException e) {
		}

		return r;

	}

	public void restaFechas(Date dateIni,Date dateFin){
		/* CREAMOS LOS OBJETOS GREGORIAN CALENDAR PARA EFECTUAR LA RESTA */
		GregorianCalendar date1 = new GregorianCalendar();
		date1.setTime(dateIni); //dateIni es el objeto Date
		GregorianCalendar date2 = new GregorianCalendar();        
		date2.setTime(dateFin); //dateFin es el objeto Date        
		int dias =  date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR);

	}


	public static void restaFechas1(Date dateIni,Date dateFin){		
		GregorianCalendar date1 = new GregorianCalendar();
		date1.setTime(dateIni); //dateIni es el objeto Date
		GregorianCalendar date2 = new GregorianCalendar();
		date2.setTime(dateFin); //dateFin es el objeto Date
		 
		/* COMPROBAMOS SI ESTAMOS EN EL MISMO ANYO */
		if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {	        
			long resta=(date2.getTimeInMillis() - date1.getTimeInMillis());	    
			resta=resta/1000;	     
			if(resta>60){
				resta=resta/60;	        	
				if(resta>60){
					resta=resta/60;	        	
				}	        	
			}	        
		} else {
			/* SI ESTAMOS EN DISTINTO ANYO COMPROBAMOS QUE EL ANYO DEL DATEINI NO SEA BISIESTO
			 * SI ES BISIESTO SON 366 DIAS EL ANYO
			 * SINO SON 365
			 */
			int diasAnyo = date1.isLeapYear(date1.get(Calendar.YEAR)) ? 366 : 365;

			/* CALCULAMOS EL RANGO DE ANYOS */
			int rangoAnyos = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);

			/* CALCULAMOS EL RANGO DE DIAS QUE HAY */
			int rango = (rangoAnyos * diasAnyo) + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR));

			System.out.println("Valor de rangoDias:**" + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR)));
			System.out.println("Valor de rangoAnyos**: " + rangoAnyos);
			System.out.println("Valor de rango:** " + rango);
		}

	}



	public static Double restaFechasHorasNuevo(Date dateIni,Date dateFin){		
		Long restaBD=new Long("0");		
		Double restaBDd=new Double("0");

		GregorianCalendar date1 = new GregorianCalendar();
		date1.setTime(dateIni); //dateIni es el objeto Date

		Calendar cal = Calendar.getInstance();
		if(dateFin==null) dateFin=cal.getTime();

		GregorianCalendar date2 = new GregorianCalendar();
		date2.setTime(dateFin); //dateFin es el objeto Date


		/* COMPROBAMOS SI ESTAMOS EN EL MISMO ANYO */
		if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
			restaBDd=
				new Double(
						new Long(date2.getTimeInMillis()).doubleValue() - 
						new Long(date1.getTimeInMillis()).doubleValue()
				);

			restaBDd=restaBDd/1000;
			restaBDd=restaBDd/60;
			restaBDd=restaBDd/60;

		} else {
			/* SI ESTAMOS EN DISTINTO ANYO COMPROBAMOS QUE EL ANYO DEL DATEINI NO SEA BISIESTO
			 * SI ES BISIESTO SON 366 DIAS EL ANYO
			 * SINO SON 365
			 */
			int diasAnyo = date1.isLeapYear(date1.get(Calendar.YEAR)) ? 366 : 365;

			/* CALCULAMOS EL RANGO DE ANYOS */
			int rangoAnyos = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);

			/* CALCULAMOS EL RANGO DE DIAS QUE HAY */
			int rango = (rangoAnyos * diasAnyo) + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR));

			System.out.println("Valor de rangoDias:**" + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR)));
			System.out.println("Valor de rangoAnyos**: " + rangoAnyos);
			System.out.println("Valor de rango:** " + rango);
		}

		return restaBDd;

	}


	public static double ConvertirMinutos_en_Hora(long minutos){
		return (minutos / 60); 
	} 

	public static double ConvertirSegundos_en_Hora(long seg){
		return (seg / 3600); 
	}

	public static long ConvertirHoras_en_Minutos(double horas){
		return (long)(horas * 60); 
	} 
	public static double ConvertirHoras_en_Dias(long horas){
		return (horas / 24); 
	}
	public static long ConvertirDias_en_Horas(double dias){
		return (long)(dias * 24); 
	} 



	public static Double restaFechasDates(Date date1,Date date2,String horasporDia){
		double dato = ((date2.getTime() - date1.getTime())/(3600*1000.0));
		return dato;
	}

	public static Double restaFechasHoras(String dateIni1,String dateFin1){

		Long restaBD=new Long("0");
		Double restaBDd=new Double("0");
		java.util.Date dateIni=null;
		java.util.Date dateFin=null;

		try {
			DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			dateIni = dateFormatter.parse(dateIni1);
			dateFin = dateFormatter.parse(dateFin1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GregorianCalendar date1 = new GregorianCalendar();
		date1.setTime(dateIni); //dateIni es el objeto Date
		Calendar cal = Calendar.getInstance();
		if(dateFin==null) dateFin=cal.getTime();
		GregorianCalendar date2 = new GregorianCalendar();
		date2.setTime(dateFin); //dateFin es el objeto Date

		/* COMPROBAMOS SI ESTAMOS EN EL MISMO ANYO */
		if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {

			restaBDd=
				new Double(
						new Long(date2.getTimeInMillis()).doubleValue() - 
						new Long(date1.getTimeInMillis()).doubleValue()
				);

			restaBDd=restaBDd/1000;			
			restaBDd=restaBDd/60;			
			restaBDd=restaBDd/60;

		} else {
			/* SI ESTAMOS EN DISTINTO ANYO COMPROBAMOS QUE EL ANYO DEL DATEINI NO SEA BISIESTO
			 * SI ES BISIESTO SON 366 DIAS EL ANYO SINO SON 365 */
			int diasAnyo = date1.isLeapYear(date1.get(Calendar.YEAR)) ? 366 : 365;
			/* CALCULAMOS EL RANGO DE ANYOS */
			int rangoAnyos = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);
			/* CALCULAMOS EL RANGO DE DIAS QUE HAY */
			int rango = (rangoAnyos * diasAnyo) + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR));
		}
		return restaBDd;
	}	



	public static String convertirFormatoDiasHorasMinSegAhoras1(String string,String horaspordia)//String dias,String horas,String min)
	{

		String horasGrl="";		
		String cadena=string;
		int uno=cadena.indexOf("/");		

		if(uno>0){
			String dias=cadena.substring(0,uno);				
			cadena=cadena.substring(uno+1);						
			int dos=cadena.indexOf("/");				
			if(dos>0){
				String horas=cadena.substring(0,dos);		
				String min=cadena.substring(dos+1);			

				double diasl=new Double(dias).doubleValue()*new Double(horaspordia).doubleValue();
				double minl=new Double(min).doubleValue()/60;
				double horasl=new Double(horas).doubleValue();		

				double suma=diasl+minl+horasl;

				BigDecimal xy= new BigDecimal(suma);
				xy=redondeoValor(xy);

				horasGrl=xy.toString();
			}
		}
		return horasGrl;
	}


	public static String convertirFormatoDiasHorasMinSegAhorasMinutosNuevo2(String string,String horasporDia)//String dias,String horas,String min)
	{

		String suma=convertirFormatoDiasHorasMinSegAhoras1(string,horasporDia);

		String horasGrl="";

		BigDecimal xy= new BigDecimal(suma);
		horasGrl=xy.toString();
		String min2=null;
		if(horasGrl.indexOf(".")!=-1)
		{
			String resto=horasGrl;
			horasGrl=horasGrl.substring(0,horasGrl.indexOf("."));
			min2=resto.substring(resto.indexOf("."));

			System.out.println(resto+"MIN2->"+min2);
			if(min2!=null && !min2.equals("0") && !min2.equals("0.0"))
			{
				double min2D=new Double(min2).doubleValue()*60;
				min2=new Double(min2D).toString();			

				if(min2!=null && min2.indexOf(".")!=-1)
				{
					String otro=min2.substring(min2.indexOf("."));
					min2=min2.substring(0,min2.indexOf("."));				
					Double or=new Double(otro);

					if (or>0.50){					
						Integer add= new Integer(min2)+ new Integer("1");
						min2=add.toString();						
					}

					String aotro=".06";
					Double aor=new Double(aotro);					
				}

				if(min2!=null && min2.length()==1){
					min2="0"+min2;	
				}			
			}

			horasGrl=horasGrl+"."+min2;

		}
		return horasGrl;
	}


	public static String convertirFormatoDiasHorasMinSegAhorasMinutosNuevo(String string,String horasporDia)//String dias,String horas,String min)
	{

		String horasGrl="";		
		String cadena=string;
		int uno=cadena.indexOf("/");				
		if(uno>0){
			String dias=cadena.substring(0,uno);				
			cadena=cadena.substring(uno+1);						
			int dos=cadena.indexOf("/");				
			if(dos>0){
				String horas=cadena.substring(0,dos);		
				String min=cadena.substring(dos+1);			
				Double hPdias=new Double(horasporDia);
				double diasl=new Double(dias).doubleValue()*hPdias.doubleValue();		
				double horasl=new Double(horas).doubleValue();			
				double suma=diasl+horasl;

				BigDecimal xy= new BigDecimal(suma);
				horasGrl=xy.toString();
				String min2=null;
				if(horasGrl.indexOf(".")!=-1)
				{
					String resto=horasGrl;
					horasGrl=horasGrl.substring(0,horasGrl.indexOf("."));
					min2=resto.substring(resto.indexOf(".")+1);				
					if(min2!=null && !min2.equals("0") && !min2.equals("0.0"))
					{
						double min2D=new Double(min2).doubleValue()*6;
						min2=new Double(min2D).toString();						
					}

				}

				if(min!=null && !min.equals("")){
					//en caso q horas tenga fraccion			 
					if(min2!=null){						
						Double x=new Double(min)+new Double(min2);					
						min=new Integer(x.intValue()).toString();
					}
				}
				horasGrl=horasGrl+"."+min;
			}
		}
		return horasGrl;
	}

	public static BigDecimal redondeoValor(BigDecimal valor) {
		if (valor != null) {
			return valor.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return null;
	}

	public static BigDecimal redondeoValor1(BigDecimal valor) {
		if (valor != null) {
			return valor.setScale(1, BigDecimal.ROUND_HALF_UP);
		}
		return null;
	}


	public static String convertirFormatoDiasHorasMinSeg24HORASNuevo(String tiempoHoras,String horasPorDia){
		//ejemplo: 130 horas= 16 dias, 2 horas , 0 min, 0 seg.
		String formateado="";
		String diasStr="";
		String horasStr="";
		String minutosStr="";
		String segundosStr="";

		if (tiempoHoras != null && tiempoHoras.contains(",")) {
			tiempoHoras = tiempoHoras.replace(',', '.');
		}

		if(tiempoHoras!=null && !tiempoHoras.equals("") && !tiempoHoras.equals("0"))
		{
			Double dias= new Double(tiempoHoras);		
			dias=dias/new Double("24").doubleValue();
			diasStr=new Integer(dias.intValue()).toString();
			formateado=diasStr+" dias";

			double diasDecimal=dias-new Double(diasStr).doubleValue();	   

			if(diasDecimal!=0.0 )
			{			
				Double horas= diasDecimal;
				horas=horas*24;			
				horasStr=new Integer(horas.intValue()).toString();
				formateado=diasStr+" dias, "+horasStr+" horas";
				double horasDecimal=horas-new Double(horasStr).doubleValue();

				if(horasDecimal>0)					   
				{				
					Double min= horasDecimal;				
					min=min*60;
					min=redondeoValor(new BigDecimal(min)).doubleValue();
					minutosStr=new Integer(min.intValue()).toString();
					formateado=diasStr+" dias, "+horasStr+" horas, "+minutosStr+" min";
				}
			}				   
		}
		return formateado;	
	}



	public static String convertirFormatoDiasHorasMinSeg24HORASNuevoConSegundos(String tiempoHoras,String horasPorDia){
		//ejemplo: 130 horas= 16 dias, 2 horas , 0 min, 0 seg.
		String formateado="";
		String diasStr="";
		String horasStr="";
		String minutosStr="";
		String segundosStr="";

		if (tiempoHoras != null && tiempoHoras.contains(",")) {
			tiempoHoras = tiempoHoras.replace(',', '.');
		}

		if(tiempoHoras!=null && !tiempoHoras.equals("") && !tiempoHoras.equals("0"))
		{
			Double dias= new Double(tiempoHoras);		
			dias=dias/new Double("24").doubleValue();
			diasStr=new Integer(dias.intValue()).toString();
			formateado=diasStr+" dias";
			double diasDecimal=dias-new Double(diasStr).doubleValue();
			if(diasDecimal!=0.0 )
			{
				Double horas= diasDecimal;
				horas=horas*24;			
				horasStr=new Integer(horas.intValue()).toString();
				formateado=diasStr+" dias, "+horasStr+" horas";
				double horasDecimal=horas-new Double(horasStr).doubleValue();
				if(horasDecimal>0)					   
				{
					Double min= horasDecimal;
					min=min*60;
					min=redondeoValor(new BigDecimal(min)).doubleValue();
					minutosStr=new Integer(min.intValue()).toString();
					formateado=diasStr+" dias, "+horasStr+" horas, "+minutosStr+" min";
					double minutosDecimal=min-new Double(minutosStr).doubleValue();
					if(minutosDecimal>0)					   
					{   
						Double seg= minutosDecimal;
						seg=seg*60;
						seg=redondeoValor(new BigDecimal(seg)).doubleValue();
						segundosStr=new Integer(seg.intValue()).toString();
						formateado=diasStr+" dias, "+horasStr+" horas, "+minutosStr+" min, "+segundosStr+"seg.";
					}
				}
			}				   
		}  
		return formateado;	
	}

	public static String convertirFormatoDiasHorasMinSeg8HORASNuevo(String tiempoHoras,String horasPorDia){
		//ejemplo: 130 horas= 16 dias, 2 horas , 0 min, 0 seg.
		String formateado="";
		String diasStr="";
		String horasStr="";
		String minutosStr="";
		String segundosStr="";

		if (tiempoHoras != null && tiempoHoras.contains(",")) {
			tiempoHoras = tiempoHoras.replace(',', '.');
		}
		if(tiempoHoras!=null && !tiempoHoras.equals("") && !tiempoHoras.equals("0"))
		{
			Double dias= new Double(tiempoHoras);	
			dias=dias/new Double(horasPorDia).doubleValue();
			diasStr=new Integer(dias.intValue()).toString();
			formateado=diasStr+" dias";
			double diasDecimal=dias-new Double(diasStr).doubleValue();			   

			if(diasDecimal!=0.0 )
			{
				Double horas= diasDecimal;
				horas=horas*new Double(horasPorDia).doubleValue();
				horasStr=new Integer(horas.intValue()).toString();
				formateado=diasStr+" dias, "+horasStr+" horas";
				double horasDecimal=horas-new Double(horasStr).doubleValue();
				if(horasDecimal>0)					   
				{
					Double min= horasDecimal;
					min=min*60;
					min=redondeoValor(new BigDecimal(min)).doubleValue();
					minutosStr=new Integer(min.intValue()).toString();					   
					formateado=diasStr+" dias, "+horasStr+" horas, "+minutosStr+" min";
				}
			}				   
		}
		return formateado;	
	}



	//CAMBIAR
	public static Double soloHorasValor(String formateadoHorasPminutos){
		//formateadoHorasPminutos 25.30 25 HORAS 30 MINUTOS
		String hor=formateadoHorasPminutos;
		String min=null;
		if(formateadoHorasPminutos.indexOf('.')!=-1)
		{
			hor=formateadoHorasPminutos.substring(0,formateadoHorasPminutos.indexOf('.'));
			min=formateadoHorasPminutos.substring(formateadoHorasPminutos.indexOf('.')+1);
		}

		Double doubleHras=0.0;
		if(hor!=null && !hor.equals("00"))	doubleHras=new Double(hor);

		Double doubleMin=0.0;
		if(min!=null && !min.equals("00"))
		{
			if(min.length()==1) min=min+"0";
			doubleMin=new Double(min)/60;
		}

		Double xyz=doubleHras+doubleMin;
		return xyz;
	}



	public Double soloHorasValorHMS123(String formateadoHorasMinSeg){

		Double horasSolo=0.0;
		String hor=formateadoHorasMinSeg;
		String min=null;
		String seg=null;
		if(formateadoHorasMinSeg.indexOf(':')!=-1)
		{
			hor=formateadoHorasMinSeg.substring(0,formateadoHorasMinSeg.indexOf(':'));

			String resto=formateadoHorasMinSeg.substring(formateadoHorasMinSeg.indexOf(':')+1);

			min=resto.substring(0,resto.indexOf(':'));

			seg=resto.substring(resto.indexOf(':')+1);
		}

		Double doubleHras=0.0;
		if(hor!=null && !hor.equals("00"))
			doubleHras=new Double(hor);

		Double doubleMin=0.0;
		if(min!=null && !min.equals("00"))
			doubleMin=new Double(min)/60;

		Double doubleSeg=0.0;
		if(seg!=null && !seg.equals("00"))
			doubleSeg=new Double(seg)/3600;

		Double xyz=doubleHras+doubleMin+doubleSeg;

		return xyz;

	}


	public static Double soloHorasValorPuntoMin(String formateadoHorasMin){

		String hor=formateadoHorasMin;
		String min=null;

		if(formateadoHorasMin.indexOf(':')!=-1)
		{
			hor=formateadoHorasMin.substring(0,formateadoHorasMin.indexOf(':'));			
			min=formateadoHorasMin.substring(formateadoHorasMin.indexOf(':')+1);			
		}

		Double doubleHras=0.0;
		if(hor!=null && !hor.equals("00"))
			doubleHras=new Double(hor);

		Double doubleMin=0.0;
		if(min!=null && !min.equals("00"))
			doubleMin=new Double(min)/60;

		Double xyz=doubleHras+doubleMin;

		return xyz;
	}


	public static Double soloHorasValorPuntoMinPuntoSeg(String formateadoHorasMin){
		String hor=formateadoHorasMin;
		String min=null;
		String seg=null;

		if(formateadoHorasMin.indexOf(':')!=-1)
		{
			hor=formateadoHorasMin.substring(0,formateadoHorasMin.indexOf(':'));
			min=formateadoHorasMin.substring(formateadoHorasMin.indexOf(':')+1,formateadoHorasMin.indexOf(':')+3);
			String resto=formateadoHorasMin.substring(formateadoHorasMin.indexOf(':')+1);
			seg=resto.substring(resto.indexOf(':')+1);
		}

		Double doubleHras=0.0;
		if(hor!=null && !hor.equals("00"))		doubleHras=new Double(hor);

		Double doubleMin=0.0;
		if(min!=null && !min.equals("00"))		doubleMin=new Double(min)/60;

		Double doubleSeg=0.0;
		if(seg!=null && !seg.equals("00"))		doubleSeg=new Double(seg)/3600;

		Double xyz=doubleHras+doubleMin+doubleSeg;

		return xyz;

	}



}

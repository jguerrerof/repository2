package main.java.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

/**
 * @description Clase que encripta o cifra un string en una sola vía y ese estring es encodificado en Base64 
 * para que sean caracteres ASCII y asi almacenarlos en la BD.
 * voy a usar el cifrador SHA1 no MD5.
 * http://es.debugmodeon.com/articulo/generar-hash-sha-1-de-una-cadena-en-java
   1. Prefiero que sea un método estático que pueda llamar sin tener que instanciar un objeto.
   2. En el método getBytes() prefiero indicar explícitamente que se use UTF-8 como codificación de caracteres.
   3. Evito que quien llame al método tenga que manejar la excepción. Nunca debería ocurrir una NoSuchAlgorithmException ni una UnsupportedEncodingException porque siempre se pasan las mismas constantes. Con hacer un test de unidad bastaría para comprobar que nunca se va a producir la excepción.
 * http://www.programacion.com/java/foros/27/msg/195910/
 * */
public final class SHA1BASE64 {
	public static String encriptar(String textoplano) throws IllegalStateException {
		MessageDigest md = null;
		byte[] buffer, digest;
	    String  hashEjemplo1 = "";
	    String  hashEjemplo2 = "";
		try{			
			md = MessageDigest.getInstance("SHA1");//Instancia de generador SHA-1
		}catch(NoSuchAlgorithmException e) {
			throw new IllegalStateException(e.getMessage());
		}
		
		try{
			buffer = textoplano.getBytes("UTF-8");
		}catch(UnsupportedEncodingException e) {
			throw new IllegalStateException(e.getMessage());
		}
		
		md.update(buffer);//Generación de resumen de mensaje
		digest = md.digest();//Obtención del resumen de mensaje	
		
		/*Esto hacen en una ejemplo*/
		//byte raw[] = md.digest(); 
		//String hash = (new BASE64Encoder()).encode(raw);//Traducción a BASE64
		hashEjemplo1 = (new Base64()).encodeBase64String(digest);//Traducción a BASE64 //este bota 28 caracteres, pero con un problema \n\r, que me dan problemas porque no se ven...
		
		/*Esto hacen en otro ejemplo*/
		for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hashEjemplo2 += "0";
            hashEjemplo2 += Integer.toHexString(b);
        }

        return hashEjemplo2;//este bota 40 caracteres
	}
}
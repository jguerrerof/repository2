package main.java.controllers;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
 
import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.security.auth.login.AccountException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
 
public class ActiveDirectoryAuthentication {
 
    private static final String CONTEXT_FACTORY_CLASS = "com.sun.jndi.ldap.LdapCtxFactory";
    //OU=oulaica,DC=local,DC=ulvr,DC=edu,DC=ec				
 
    private String ldapServerUrls[];
 
    private int lastLdapUrlIndex;
 
    private final String domainName;
 
    public ActiveDirectoryAuthentication(String domainName) {
        this.domainName = domainName.toUpperCase();
 
        try {
            ldapServerUrls = nsLookup(domainName);
            
            System.out.println("ldapServerUrls"+ldapServerUrls);
            
        } catch (Exception e) { 
            e.printStackTrace();
        }
        lastLdapUrlIndex = 0;
    }
 
    public boolean authenticate(String username, String password) throws LoginException {
    	
    	boolean grupook=false;
    	
        if (ldapServerUrls == null || ldapServerUrls.length == 0) {
            throw new AccountException("Unable to find ldap servers");
        }
        if (username == null || password == null || username.trim().length() == 0 || password.trim().length() == 0) {
            throw new FailedLoginException("Username or password is empty");
        }
        int retryCount = 0;
        int currentLdapUrlIndex = lastLdapUrlIndex;
        do {
            retryCount++;
            try {
                Hashtable<Object, Object> env = new Hashtable<Object, Object>();
                env.put(Context.INITIAL_CONTEXT_FACTORY, CONTEXT_FACTORY_CLASS);
                env.put(Context.PROVIDER_URL, ldapServerUrls[currentLdapUrlIndex]);
                env.put(Context.SECURITY_PRINCIPAL, username + "@" + domainName);
                //env.put(Context.SECURITY_PRINCIPAL, "UID="+username + ",OU=Usuarios,OU=Sistemas,OU=ouLaica,DC=local,DC=ulvr,DC=edu,DC=ec");
                
                //props.put(Context.SECURITY_PRINCIPAL, "uid=adminuser,ou=special users,o=xx.com")
                
                env.put(Context.SECURITY_CREDENTIALS, password);
                
                DirContext ctx = new InitialDirContext(env);
                 
 
              
               NamingEnumeration<NameClassPair> resultList; 
             
               resultList = ctx.list("OU=Usuarios,OU=Sistemas,OU=ouLaica,DC=local,DC=ulvr,DC=edu,DC=ec");
               
               
               //confirmar que este dentro del grupo de Sistemas (de acuerdo al listado del result que se realiza sobre la OU=Sistemas)
               while (resultList.hasMore()) {
                   NameClassPair result = resultList.next();                   
                    Attributes attrs = ctx.getAttributes(result.getNameInNamespace());                    
                    if(attrs.get("SAMAccountName").get()!=null)
                    {
                    	String g=attrs.get("SAMAccountName").get().toString();
                    	if(g.equals(username)) grupook=true;                    		
                    }
               }
               
                 
                
                ctx.close();
                System.out.println("dentro del grupo Sistemas"+grupook);
                
                lastLdapUrlIndex = currentLdapUrlIndex;
                return grupook;
            } catch (CommunicationException exp) {
                exp.printStackTrace(); // TODO you can replace with log4j or slf4j API
                // if the exception of type communication we can assume the AD is not reachable hence retry can be attempted with next available AD
                if (retryCount < ldapServerUrls.length) {
                    currentLdapUrlIndex++;
                    if (currentLdapUrlIndex == ldapServerUrls.length) {
                        currentLdapUrlIndex = 0;
                    }
                    continue;
                }
                return false;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return false;
            }
        } while (true);
    }
 
    private static String[] nsLookup(String argDomain) throws Exception {
        try {
            Hashtable<Object, Object> env = new Hashtable<Object, Object>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
            env.put("java.naming.provider.url", "dns:");
            DirContext ctx = new InitialDirContext(env);
            Attributes attributes = ctx.getAttributes(String.format("_ldap._tcp.%s", argDomain), new String[] { "srv" });
            // try thrice to get the KDC servers before throwing error
            for (int i = 0; i < 3; i++) {
                Attribute a = attributes.get("srv");
                if (a != null) {
                    List<String> domainServers = new ArrayList<String>();
                    NamingEnumeration<?> enumeration = a.getAll();
                    while (enumeration.hasMoreElements()) {
                        String srvAttr = (String) enumeration.next();
                        // the value are in space separated 0) priority 1)
                        // weight 2) port 3) server
                        String values[] = srvAttr.toString().split(" ");
                        domainServers.add(String.format("ldap://%s:%s", values[3], values[2]));
                    }
                    String domainServersArray[] = new String[domainServers.size()];
                    domainServers.toArray(domainServersArray);
                    return domainServersArray;
                }
            }
            throw new Exception("Unable to find srv attribute for the domain " + argDomain);
        } catch (NamingException exp) {
            throw new Exception("Error while performing nslookup. Root Cause: " + exp.getMessage(), exp);
        }
    }
}
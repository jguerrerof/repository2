package main.java.controllers;

import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

 
@ManagedBean
@ViewScoped
public class DashboardView implements Serializable {
     
    private DashboardModel model;
    private String option;
 
     
    @PostConstruct
    public void init() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
      
        column1.addWidget("vtasmensuales");
       
        column1.addWidget("rotacion");
         
        column2.addWidget("vtasproducto");
        column2.addWidget("vtasmaq");
     //   column2.addWidget("top10");
                
 
        model.addColumn(column1);
        model.addColumn(column2);
        
		
		System.out.println("init- en dashborad ABC--->");
		
		 
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean")!=null)
			{
				
				System.out.println("1a"); 
				loginBean loginBean = (loginBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");	
				System.out.println("1b"); 
				
				
				boolean ok=loginBean.isAuthCorrecta();
				System.out.println("1c"); 
				if(ok){
					
					System.out.println("1d"); 
					
					
					
					}
				else
				{
					System.out.println("error login en rol 1e");	
					 try {
							FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
							 	} catch (Exception e1) {
							// TODO Auto-generated catch block
							 e1.printStackTrace();
						}
					}
		
    }
	else{
		
		 
		
	}		
	
	
    }
       
    

 
     
    public void handleReorder(DashboardReorderEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Reordered: " + event.getWidgetId());
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
         
        addMessage(message);
    }
     
    public void handleClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
         
        addMessage(message);
    }
     
    public void handleToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public DashboardModel getModel() {
        return model;
    }
    
    

    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    } 
    
}

 
package controller;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import util.JDBCData;

/**
 * 
 * 
 * 
 * @author Heiner, Steffen
 *
 */

@Named(value = "RegBean")

public class RegisterBean implements Serializable {
  
  @Inject 
  private JDBCData jdBC;

  private String userName, password, eMail;
  
  public void Register()
  {
    
    
   
    
    
    
    
    
  }
}
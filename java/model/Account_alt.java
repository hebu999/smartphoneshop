package model;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import util.Data;


/**
 * 
 * 
 * @author Heiner, Steffen
 * @version 1.0
 * 
 * @category Diese Klasse stellt den Objekt Datentyp für die Account ArrayList zur Verfügung mit den entsprechenden Attributen.
 *
 */

@Named(value = "User")
public class Account_alt implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Inject
  private Data jdBC;

  String accname;
  String accpwd;
  
  public Account_alt(String an, String ap) {
    this.setAccname(an);
    this.setAccpwd(ap);
  }

  public String getAccname() {
    return accname;
  }

  public void setAccname(String accname) {
    this.accname = accname;
  }

  public String getAccpwd() {
    return accpwd;
  }

  public void setAccpwd(String accpwd) {
    this.accpwd = accpwd;
  }
}
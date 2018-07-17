package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.*;
import util.Data;
import controller.LoginBean;
import model.Account;
import model.Kunde;

/**
 * 
 * 
 * @author Heiner, Steffen
 * @version 1.0
 * 
 * @category Diese Klasse fügt mit Hilfe von prepared-statements Benutzer- und Kundendaten in die Datenbank ein
 *           und überprüft, ob ein Accountname schon vorhanden ist.
 * 
 */

@ManagedBean
@RequestScoped
public class RegisterBean implements Serializable {
  private final Logger logger = Logger.getLogger(this.getClass().getName());
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Inject
  private Data data;

  @Inject
  private LoginBean LoginBean;

  private Account checkAccount;

  private Kunde newCustomer = new Kunde("", "", "", "", "");

  /**
   * 
   * Die ArrayList aus der JDBC Klasse wird in einer erweiterten for-schleife durchlaufen und die
   * Benutzernamen auf gleichheit geprüft, sollte dies nicht der Fall sein wird der Benutzername mit
   * einer persistierung in die Datenbank geschrieben
   * 
   * 
   * @throws SQLException
   */
  public void Register() throws SQLException {
    boolean userExists = false;

    setCheckAccount(data.findAccountByLoginName(newCustomer.getFkAccid().getAccname()));

    if (getCheckAccount() != null) {
      userExists = true;
    }

    if ((newCustomer.getFkAccid().getAccname() != null
        && newCustomer.getFkAccid().getAccpwd() != null) && !userExists) {

      try {

        // data.registerUser(userName, password);

        logger.info("Daten: " + newCustomer.getKAnrede() + newCustomer.getKName()
            + newCustomer.getKVName() + newCustomer.getKEMail() + newCustomer.getKTel()
            + newCustomer.getFkAccid().getAccname());
        data.registerCustomer(newCustomer);

        FacesMessage m = new FacesMessage("Registrierung erfolgreich!");
        FacesContext.getCurrentInstance().addMessage("register", m);

        LoginBean.doLogin();

      } catch (Exception e) {
        FacesMessage m = new FacesMessage("Registrierung fehlgeschlagen!");
        FacesContext.getCurrentInstance().addMessage("register", m);
        e.printStackTrace();
      }
    }

    else {

      FacesMessage m = new FacesMessage("Benutzername " + "'"
          + newCustomer.getFkAccid().getAccname() + "'" + " existiert bereits!");
      FacesContext.getCurrentInstance().addMessage("register", m);
    }
  }

  
  /**
   * Setter and Getter
   */
  public Kunde getNewCustomer() {
    return newCustomer;
  }

  public void setNewCustomer(Kunde newCustomer) {
    this.newCustomer = newCustomer;
  }


  public Account getCheckAccount() {
    return checkAccount;
  }

  public void setCheckAccount(Account checkAccount) {
    this.checkAccount = checkAccount;
  }

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }

}

/*
 * Connection conn = jdBC.connectDatabase();
 * 
 * String sqlInsertQuery = "INSERT INTO accounts(ACCID, ACCNAME, ACCPWD)" + "VALUES(NULL, ?, ?)";
 * 
 * PreparedStatement prepStat = conn.prepareStatement(sqlInsertQuery);
 * 
 * prepStat.setString(1, userName); prepStat.setString(2, password);
 * 
 * prepStat.executeUpdate();
 */

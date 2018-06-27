package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.*;
import util.JDBCData;
import controller.LoginBean;
import model.Account;

/**
 * 
 * 
 * @author Heiner, Steffen
 * @version 1.0
 * 
 * @category Diese Klasse fügt mit Hilfe von prepared-statements Benutzerdaten in die Datenbank ein
 *           und überprüft ob ein Benutzername schon vorhanden ist.
 *  
 */

@ManagedBean
@RequestScoped
public class RegisterBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Inject
  private JDBCData jdBC;

  @Inject
  private LoginBean LoginBean;

  private String userName, password;
  private Account checkAccount;

  // Die ArrayList aus der JDBC Klasse wird in einer erweiterten for-schleife durchlaufen und die
  // Benutzernamen auf gleichheit geprüft, sollte dies nicht der Fall sein wird der
  // Benutzername mit einem prepared-statement in die Datenbank geschrieben
  public void Register() throws SQLException {
    boolean userExists = false;

    setCheckAccount(jdBC.findAccountByLoginName(userName));

    if (getCheckAccount().getAccname().equalsIgnoreCase(userName)) {
      userExists = true;
    }

    if ((userName != null && password != null) && !userExists) {

      Connection conn = jdBC.connectDatabase();

      String sqlInsertQuery = "INSERT INTO accounts(ACCID, ACCNAME, ACCPWD)" + "VALUES(NULL, ?, ?)";

      PreparedStatement prepStat = conn.prepareStatement(sqlInsertQuery);

      prepStat.setString(1, userName);
      prepStat.setString(2, password);
      
      prepStat.executeUpdate();

      LoginBean.doLogin();
    }

    else {

      FacesMessage m =
          new FacesMessage("Benutzername " + "'" + userName + "'" + " existiert bereits!");
      FacesContext.getCurrentInstance().addMessage("register", m);
    }
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Account getCheckAccount() {
    return checkAccount;
  }

  public void setCheckAccount(Account checkAccount) {
    this.checkAccount = checkAccount;
  }
}
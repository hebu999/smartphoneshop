package controller;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import util.Data;
import model.Account;
import model.Kunde;
import java.util.logging.*;

/**
 * 
 * @author Heiner, Steffen
 * @version 1.0
 *
 * @category Diese Klasse ist für die Überprüfung der gelieferten JPQL Daten verantwortlich und
 *           realisiert bei erfolgreicher Überprüfung die An- und Abmeldung
 *
 *
 */

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Inject
  private Data data;

  
  public LoginBean() {

  }

  private final Logger logger = Logger.getLogger(this.getClass().getName());

  private String username, password;

  private boolean loggedIn = false;

  private Account account = new Account();
  
  private Kunde customer;

  
  /**
   * Überprüft ob ein Accountname bereits vorhanden ist, sollte dies der Fall sein wird das Passwort abgeglichen und bei Erfolg die Methode DoLogin ausgeführt
   * @return
   */
  
  public void checkLogin() {

    try {
      setAccount(data.findAccountByLoginName(username));   
    }

    catch (Exception ex) {
      FacesMessage m = new FacesMessage("Fehler: " + ex.getMessage());
      FacesContext.getCurrentInstance().addMessage("test", m);
    }

    if (this.account == null) {
      FacesMessage m = new FacesMessage("Account wurde nicht gefunden!");
      FacesContext.getCurrentInstance().addMessage("test", m);

    }

    else

    {
      if (getAccount().getAccpwd().equals(password)) {

        logger.info("Abgleich erfolgreich, mache doLogin()");
        doLogin();

      }

      else

      {
        FacesMessage m = new FacesMessage("Name oder Passwort falsch!");
        FacesContext.getCurrentInstance().addMessage("test", m);

      }
    }
  }
  
  

  /**
   * Setzt die Variable loggedIn auf "true" und weist dem Kundenobject über die Methode in der Data klasse den Accountnamen zu
   * 
   * @return index.html
   */
  public String doLogin() {

    this.loggedIn = true;
    logger.info("loggedIn=True");
setCustomer(data.findCustomer(account.getAccname()));
    
    FacesMessage m = new FacesMessage("Login erfolgreich!");
    FacesContext.getCurrentInstance().addMessage("loggedin", m);

    return "/index.xhtml";
  }

  /**
   * Setzt die loggedIn Variable auf false
   * @return index.yhtml
   */
  public String doLogout() {

    if (this.loggedIn) {
      this.loggedIn = false;
    }

    FacesContext context = FacesContext.getCurrentInstance();

    context.getExternalContext().invalidateSession();
    context.getExternalContext().getSession(true);

    context.addMessage("test",
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Auf Wiedersehen!", "Tschüss"));

    return "/index.xhtml";
  }
  
  

  /**
   * Setter and Getter
   */
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean getloggedIn() {
    return loggedIn;
  }

  public void setloggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
  
  public Kunde getCustomer() {
    return customer;
  }

  public void setCustomer(Kunde customer) {
    this.customer = customer;
  }
}

/*
 * public void checkLogin() {
 * 
 * logger.setLevel(Level.ALL); List<Account> accountListCheck; try { accountListCheck =
 * jdBC.getSQLDataAccount(); int i = 0; logger.info("accountListSize:" + accountListCheck.size());
 * // Groesse der Accountliste // anzeigen while (i < accountListCheck.size()) {
 * logger.info(username + " is equal to " + accountListCheck.get(i).getAccname());
 * logger.info(password + " is equal to " + accountListCheck.get(i).getAccpwd());
 * 
 * if (username != null && password != null) { if
 * (username.equalsIgnoreCase(accountListCheck.get(i).getAccname()) &&
 * password.equals(accountListCheck.get(i).getAccpwd())) {
 * logger.info("Abgleich erfolgreich, mache doLogin()"); doLogin(); break; } } i++; } } catch
 * (SQLException e) { //Auto-generated catch block e.printStackTrace(); }
 * 
 */

/*
 * if (!loggedIn) {
 * 
 * FacesMessage m = new FacesMessage("Falsche Daten");
 * FacesContext.getCurrentInstance().addMessage("test", m);
 * 
 * username = "";
 * 
 * logger.info("Login failed message");
 * 
 * } }
 */

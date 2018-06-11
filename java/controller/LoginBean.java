package controller;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import javax.inject.*;
import util.JDBCData;
import model.Account;

/**
 * 
 * 
 * 
 * @author Heiner, Steffen
 *
 */

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Inject
  private JDBCData jdBC;

  private String username, password;

  private boolean isLoggedin = false;
  private final boolean login_succesful = false;

  public LoginBean() {

  }

  public void checkLogin() {

    List<Account> accountListCheck = jdBC.getaccountList();

    int i = 0;

    while (i < accountListCheck.size()) {

      if (username == accountListCheck.get(i).toString()
          && password == accountListCheck.get(i).toString()) {

        doLogin();
        continue;
      }
      i++;
    }

    if (!isLoggedin) {

      FacesMessage m = new FacesMessage("Passwort oder Benutzername falsch!!!");
      FacesContext.getCurrentInstance().addMessage("login", m);
    }
  }

  public String doLogin() {
    this.isLoggedin = true;

    FacesMessage m = new FacesMessage("Login erfolgreich");
    FacesContext.getCurrentInstance().addMessage("login", m);

    return "/index.xhtml";
  }

  public String doLogout() {
    this.isLoggedin = false;

    FacesContext context = FacesContext.getCurrentInstance();

    context.getExternalContext().invalidateSession();
    context.getExternalContext().getSession(true);

    context.addMessage("Messagefield",
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Auf Wiedersehen!", "Tschüss"));

    return "/index.xhtml";
  }

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

}

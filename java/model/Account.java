package model;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import util.JDBCData;

@Named(value="User")

public class Account implements Serializable {

  
  @Inject 
  private JDBCData jdBC;
  

  String accname;
  String accpwd;
  
  Account(String an, String ap){
  
    jdBC.getaccountList();
    
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

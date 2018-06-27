package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name = "accounts")
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(insertable = false, updatable = false)
  private int accid;

  private String accname;

  private String accpwd;

  @Column(name = "CURRENT_CONNECTIONS")
  private BigInteger currentConnections;

  private String host;

  @Column(name = "TOTAL_CONNECTIONS")
  private BigInteger totalConnections;

  private String user;

  public Account() {}

  public int getAccid() {
    return this.accid;
  }

  public void setAccid(int accid) {
    this.accid = accid;
  }

  public String getAccname() {
    return this.accname;
  }

  public void setAccname(String accname) {
    this.accname = accname;
  }

  public String getAccpwd() {
    return this.accpwd;
  }

  public void setAccpwd(String accpwd) {
    this.accpwd = accpwd;
  }

  public BigInteger getCurrentConnections() {
    return this.currentConnections;
  }

  public void setCurrentConnections(BigInteger currentConnections) {
    this.currentConnections = currentConnections;
  }

  public String getHost() {
    return this.host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public BigInteger getTotalConnections() {
    return this.totalConnections;
  }

  public void setTotalConnections(BigInteger totalConnections) {
    this.totalConnections = totalConnections;
  }

  public String getUser() {
    return this.user;
  }

  public void setUser(String user) {
    this.user = user;
  }
}
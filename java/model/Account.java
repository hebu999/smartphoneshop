package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name = "accounts")
@NamedQueries({@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByName",
        query = "SELECT a FROM Account a WHERE a.accname = :accname"),
    @NamedQuery(name = "Account.findByAccID",
        query = "SELECT a FROM Account a WHERE a.accid = :accid")})
public class Account implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, updatable = false)
  private int accid;

  private String accname;

  private String accpwd;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAccid", fetch = FetchType.LAZY)
  private List<Kunde> customerList;

  public Account() {}

  public Account(String an, String ap) {
    this.setAccname(an);
    this.setAccpwd(ap);
  }

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
}

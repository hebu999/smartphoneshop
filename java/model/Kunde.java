package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kunde database table.
 * 
 */
@Entity
@NamedQuery(name = "Kunde.findAll", query = "SELECT k FROM Kunde k")
public class Kunde implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "FK_ACCID")
  private int fkAccid;


  @Column(name = "FK_AID")
  private int fkAid;

  private String KAnrede;


  private String KEMail;


  @Id
  @Column(insertable = false, updatable = false)
  private int kid;

  private String KName;



  private String KTel;


  private String KVName;



  public Kunde() {}



  public int getFkAccid() {
    return this.fkAccid;
  }

  public void setFkAccid(int fkAccid) {
    this.fkAccid = fkAccid;
  }


  public int getFkAid() {
    return this.fkAid;
  }

  public void setFkAid(int fkAid) {
    this.fkAid = fkAid;
  }


  public String getKAnrede() {
    return this.KAnrede;
  }

  public void setKAnrede(String KAnrede) {
    this.KAnrede = KAnrede;
  }


  public String getKEMail() {
    return this.KEMail;
  }

  public void setKEMail(String KEMail) {
    this.KEMail = KEMail;
  }



  public int getKid() {
    return this.kid;
  }

  public void setKid(int kid) {
    this.kid = kid;
  }



  public String getKName() {
    return this.KName;
  }

  public void setKName(String KName) {
    this.KName = KName;
  }


  public String getKTel() {
    return this.KTel;
  }

  public void setKTel(String KTel) {
    this.KTel = KTel;
  }

  public String getKVName() {
    return this.KVName;
  }

  public void setKVName(String KVName) {
    this.KVName = KVName;
  }

}

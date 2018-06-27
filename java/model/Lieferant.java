package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lieferant database table.
 * 
 */
@Entity
@NamedQuery(name = "Lieferant.findAll", query = "SELECT l FROM Lieferant l")
public class Lieferant implements Serializable {
  private static final long serialVersionUID = 1L;

  private String ansprechpartner;

  private String email;


  private String firma;

  private int FK_AdrID;


  @Column(name = "FK_AID")
  private int fkAid;

  @Column(name = "FK_HID")
  private int fkHid;

  private String kontaktName;

  @Id
  @Column(insertable = false, updatable = false)
  private int lid;


  private String LName;


  private String tel;

  private String www;



  public Lieferant() {}

  public String getAnsprechpartner() {
    return this.ansprechpartner;
  }

  public void setAnsprechpartner(String ansprechpartner) {
    this.ansprechpartner = ansprechpartner;
  }


  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirma() {
    return this.firma;
  }

  public void setFirma(String firma) {
    this.firma = firma;
  }


  public int getFK_AdrID() {
    return this.FK_AdrID;
  }

  public void setFK_AdrID(int FK_AdrID) {
    this.FK_AdrID = FK_AdrID;
  }

  public int getFkAid() {
    return this.fkAid;
  }

  public void setFkAid(int fkAid) {
    this.fkAid = fkAid;
  }

  public int getFkHid() {
    return this.fkHid;
  }

  public void setFkHid(int fkHid) {
    this.fkHid = fkHid;
  }


  public String getKontaktName() {
    return this.kontaktName;
  }

  public void setKontaktName(String kontaktName) {
    this.kontaktName = kontaktName;
  }


  public int getLid() {
    return this.lid;
  }

  public void setLid(int lid) {
    this.lid = lid;
  }

  public String getLName() {
    return this.LName;
  }

  public void setLName(String LName) {
    this.LName = LName;
  }


  public String getTel() {
    return this.tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getWww() {
    return this.www;
  }

  public void setWww(String www) {
    this.www = www;
  }

}

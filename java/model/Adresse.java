package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a")
public class Adresse implements Serializable {
  private static final long serialVersionUID = 1L;

  private String ABundLand;

  @Temporal(TemporalType.TIMESTAMP)
  private Date ADatum;

  @Id
  @Column(insertable = false, updatable = false)
  private int adrid;

  private String ALand;

  private String AOrt;

  private String aplz;

  private String AStrasse;

  public Adresse() {}

  public String getABundLand() {
    return this.ABundLand;
  }

  public void setABundLand(String ABundLand) {
    this.ABundLand = ABundLand;
  }

  public Date getADatum() {
    return this.ADatum;
  }

  public void setADatum(Timestamp ADatum) {
    this.ADatum = ADatum;
  }

  public int getAdrid() {
    return this.adrid;
  }

  public void setAdrid(int adrid) {
    this.adrid = adrid;
  }

  public String getALand() {
    return this.ALand;
  }

  public void setALand(String ALand) {
    this.ALand = ALand;
  }

  public String getAOrt() {
    return this.AOrt;
  }

  public void setAOrt(String AOrt) {
    this.AOrt = AOrt;
  }

  public String getAplz() {
    return this.aplz;
  }

  public void setAplz(String aplz) {
    this.aplz = aplz;
  }

  public String getAStrasse() {
    return this.AStrasse;
  }

  public void setAStrasse(String AStrasse) {
    this.AStrasse = AStrasse;
  }
}
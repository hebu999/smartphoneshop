package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import util.JDBCData;

/**
 * 
 * 
 * @author Heiner, Steffen
 * @version 1.0
 * 
 * @category Diese Klasse stellt den Objekt Datentyp für die Produkt ArrayList zur Verfügung mit den entsprechenden Attributen.
 *
 */

@Named(value = "product")
public class Produkt_alt implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Inject
  private JDBCData jdBC;

  String pName;
  BigDecimal pPreisNetto;
  String pTyp;
  String pKomment;

  public Produkt_alt() {

  }

  public Produkt_alt(String pn, BigDecimal pp, String pt, String pl) {

    this.setpName(pn);
    this.setpPreisNetto(pp);
    this.setpTyp(pt);
    this.setpKomment(pl);
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public BigDecimal getpPreisNetto() {
    return pPreisNetto;
  }

  public void setpPreisNetto(BigDecimal pPreisNetto) {
    this.pPreisNetto = pPreisNetto;
  }

  public String getpTyp() {
    return pTyp;
  }

  public void setpTyp(String pTyp) {
    this.pTyp = pTyp;
  }

  public String getpKomment() {
    return pKomment;
  }

  public void setpKomment(String pKomment) {
    this.pKomment = pKomment;
  }
}

package model;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.inject.Inject;
import javax.inject.Named;
import util.JDBCData;

/**
 * 
 * 
 * 
 * @author Heiner, Steffen
 *
 */

public class Produkt implements Serializable {
  
  @Inject 
  private JDBCData jdBC;
  
  String pName;
  BigDecimal pPreisNetto;
  String pTyp;
  String pKomment;
  
  Produkt(String pn, BigDecimal pp, String pt, String pl) {
    
    jdBC.getproductList();
    
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

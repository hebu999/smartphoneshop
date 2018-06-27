package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the bestelldetail database table.
 * 
 */
@Entity
@NamedQuery(name = "Bestelldetail.findAll", query = "SELECT b FROM Bestelldetail b")
public class Bestelldetail implements Serializable {
  private static final long serialVersionUID = 1L;


  @Temporal(TemporalType.TIMESTAMP)
  private Date BDDatum;

  @Id
  @Column(insertable = false, updatable = false)
  private int bdid;


  private byte BDMenge;


  private BigDecimal BDPreisRabatt;



  @Column(name = "FK_BID")
  private int fkBid;


  @Column(name = "FK_PID")
  private int fkPid;


  public Bestelldetail() {}

  public Date getBDDatum() {
    return this.BDDatum;
  }

  public void setBDDatum(Timestamp BDDatum) {
    this.BDDatum = BDDatum;
  }



  public int getBdid() {
    return this.bdid;
  }

  public void setBdid(int bdid) {
    this.bdid = bdid;
  }



  public byte getBDMenge() {
    return this.BDMenge;
  }

  public void setBDMenge(byte BDMenge) {
    this.BDMenge = BDMenge;
  }


  public BigDecimal getBDPreisRabatt() {
    return this.BDPreisRabatt;
  }

  public void setBDPreisRabatt(BigDecimal BDPreisRabatt) {
    this.BDPreisRabatt = BDPreisRabatt;
  }



  public int getFkPid() {
    return this.fkPid;
  }

  public void setFkPid(int fkPid) {
    this.fkPid = fkPid;
  }

}

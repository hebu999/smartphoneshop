package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the bestelldetail database table.
 * 
 */
@Entity
@NamedQuery(name = "Bestelldetail.findAll", query = "SELECT b FROM Bestelldetail b")
public class Bestelldetail implements Serializable {
  private static final long serialVersionUID = 1L;

  @Temporal(TemporalType.DATE)
  @Column(insertable = false)
  private Date BDDatum;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, updatable = false)
  private int bdid;

  private byte BDMenge;

  private double BDPreisRabatt;

  @JoinColumn(name = "FK_PID", referencedColumnName = "pid")
  @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Produkt.class)
  private Produkt fkPid;

  @JoinColumn(name = "FK_BID", referencedColumnName = "BID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Bestellung.class)
  private Bestellung fkBid;

  public Bestelldetail() {}
  
  public Bestelldetail(int BDMenge, Bestellung bes,Produkt pro) 
  {
      this.BDMenge=(byte) BDMenge;
      this.fkBid=bes;
      this.fkPid=pro;
  }

  public Date getBDDatum() {
    return this.BDDatum;
  }

  public void setBDDatum(Date BDDatum) {
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

  public double getBDPreisRabatt() {
    return this.BDPreisRabatt;
  }

  public void setBDPreisRabatt(double BDPreisRabatt) {
    this.BDPreisRabatt = BDPreisRabatt;
  }

  public Produkt getFkPid() {
    return this.fkPid;
  }

  public void setFkPid(Produkt fkPid) {
    this.fkPid = fkPid;
  }
}

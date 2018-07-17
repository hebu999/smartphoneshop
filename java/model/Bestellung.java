package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;


/**
 * The persistent class for the bestellung database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name = "Bestellung.findAll", query = "SELECT b FROM Bestellung b"),
  @NamedQuery(name = "Bestellung.findDates", query = "SELECT b.BLieferDat FROM Bestellung b")
, @NamedQuery(name = "Bestellung.findByBesID", query = "SELECT b FROM Bestellung b WHERE b.BID = :BID")
, @NamedQuery(name = "Bestellung.findByBesStatus", query = "SELECT b FROM Bestellung b WHERE b.BStatus = :BStatus")
, @NamedQuery(name = "Bestellung.findByBesKommentar", query = "SELECT b FROM Bestellung b WHERE b.BKomment = :BKomment")
, @NamedQuery(name = "Bestellung.findByBesAenderungsdatum", query = "SELECT b FROM Bestellung b WHERE b.BAendDat = :BAendDat")})

public class Bestellung implements Serializable {
  private static final long serialVersionUID = 1L;

  
  @Temporal(TemporalType.DATE)
  @Column(insertable = false)
  private Date BAendDat;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, updatable = false)
  private int BID;

  private String BKomment;

  //@Temporal(TemporalType.DATE)
  private String BLieferDat;

  private String BStatus;

  @Column(name = "FK_ID")
  private int fkId;

  @JoinColumn(name = "FK_KID", referencedColumnName = "KID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Kunde.class)
  private Kunde fkKid;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkBid", fetch = FetchType.LAZY)
  private List<Bestelldetail> bestelldetailList;

  public Bestellung() {}

  public Bestellung(int bid, String BKomment, Date BLieferDat, Kunde fkKid) {
    this.setBid(bid);
    this.setBKomment(BKomment);
    //this.setBLieferDat(BLieferDat);
    this.setFkKid(fkKid);
  }
  
  public Bestellung(Kunde kunde)
  {
      this.BStatus = "In Bearbeitung";
      //this.BLieferDat = new Date();
      this.fkKid= kunde;
  }

  public Date getBAendDat() {
    return this.BAendDat;
  }

  public void setBAendDat(Timestamp BAendDat) {
    this.BAendDat = BAendDat;
  }

  public int getBid() {
    return this.BID;
  }

  public void setBid(int bid) {
    this.BID = bid;
  }

  public String getBKomment() {
    return this.BKomment;
  }

  public void setBKomment(String BKomment) {
    this.BKomment = BKomment;
  }

  public String getBLieferDat() {
    return this.BLieferDat;
  }

  public void setBLieferDat(String BLieferDat) {
    this.BLieferDat = BLieferDat;
  }

  public String getBStatus() {
    return this.BStatus;
  }

  public void setBStatus(String BStatus) {
    this.BStatus = BStatus;
  }

  public int getFkId() {
    return fkId;
  }

  public void setFkId(int fkId) {
    this.fkId = fkId;
  }

  public Kunde getFkKid() {
    return fkKid;
  }

  public void setFkKid(Kunde fkKid) {
    this.fkKid = fkKid;
  }
}

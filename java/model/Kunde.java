package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kunde database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name = "Kunde.findAll", query = "SELECT k FROM Kunde k"),
    @NamedQuery(name = "Kunde.findByKunID", query = "SELECT k FROM Kunde k WHERE k.KID = :KID"),
    @NamedQuery(name = "Kunde.findByKunVorname",
        query = "SELECT k FROM Kunde k WHERE k.KVName = :KVName"),
    @NamedQuery(name = "Kunde.findByKunNachname",
        query = "SELECT k FROM Kunde k WHERE k.KName = :KName"),
    @NamedQuery(name = "Kunde.findByKunAnrede",
        query = "SELECT k FROM Kunde k WHERE k.KAnrede = :KAnrede"),
    @NamedQuery(name = "Kunde.findByKunEmail",
        query = "SELECT k FROM Kunde k WHERE k.KEMail = :KEMail"),
    @NamedQuery(name = "Kunde.findByKunTelNr",
        query = "SELECT k FROM Kunde k WHERE k.KTel = :KTel"),
    @NamedQuery(name = "Kunde.findByAccId",
        query = "SELECT k FROM Kunde k " + "inner join k.fkAccid a " + "WHERE a.accname = :name")
})


public class Kunde implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, updatable = false)
  private int KID;

  @JoinColumn(name = "FK_ACCID", referencedColumnName = "accid")
  @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Account.class)
  private Account fkAccid;

  @JoinColumn(name = "FK_AID", referencedColumnName = "adrid")
  @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Adresse.class)
  private Adresse fkAid;

  private String KAnrede;

  private String KEMail;

  private String KName;

  private String KTel;

  private String KVName;

  public Kunde() {}

  public Kunde(int kID, String kAnrede, String kName, String kVName, String kEMail, String kTel) {
    this.KID = kID;
    this.KAnrede = kAnrede;
    this.KEMail = kEMail;
    this.KName = kName;
    this.KTel = kTel;
    this.KVName = kVName;
  }

  public Kunde(String kAnrede, String kName, String kVName, String kEMail, String kTel) {
    this.KAnrede = kAnrede;
    this.KEMail = kEMail;
    this.KName = kName;
    this.KTel = kTel;
    this.KVName = kVName;
    this.fkAccid = new Account();
    // this.fkAid = new Adresse();
  }

  public Account getFkAccid() {
    return this.fkAccid;
  }

  public void setFkAccid(Account fkAccid) {
    this.fkAccid = fkAccid;
  }

  public Adresse getFkAid() {
    return this.fkAid;
  }

  public void setFkAid(Adresse fkAid) {
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

  public int getKID() {
    return this.KID;
  }

  public void setKID(int KID) {
    this.KID = KID;
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

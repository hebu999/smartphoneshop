package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the produkt database table.
 * 
 */
@Entity
@NamedQuery(name = "Produkt.findAll", query = "SELECT p FROM Produkt p")
public class Produkt implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, updatable = false)
  private int pid;
  
  @JoinColumn(name = "FK_KatID", referencedColumnName = "PKatID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Produktkategorie FK_KatID;

  private Timestamp PAendDat;

  private String pimg;

  private String PIMGPfad;

  @Lob
  private String PKomment;

  private String PName;

  private int PNr;

  private double PPreisNetto;

  private String PTyp;

  public Produkt() {}

  public Produkt(int pid, String pn, double pp, String pt, String pl) {
    this.setPid(pid);
    this.setPName(pn);
    this.setPPreisNetto(pp);
    this.setPTyp(pt);
    this.setPKomment(pl);
  }

  public Produktkategorie getFK_KatID() {
    return this.FK_KatID;
  }

  public void setFK_KatID(Produktkategorie FK_KatID) {
    this.FK_KatID = FK_KatID;
  }

  public Timestamp getPAendDat() {
    return this.PAendDat;
  }

  public void setPAendDat(Timestamp PAendDat) {
    this.PAendDat = PAendDat;
  }

  public int getPid() {
    return this.pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
  }

  public String getPimg() {
    return this.pimg;
  }

  public void setPimg(String pimg) {
    this.pimg = pimg;
  }

  public String getPIMGPfad() {
    return this.PIMGPfad;
  }

  public void setPIMGPfad(String PIMGPfad) {
    this.PIMGPfad = PIMGPfad;
  }

  public String getPKomment() {
    return this.PKomment;
  }

  public void setPKomment(String PKomment) {
    this.PKomment = PKomment;
  }

  public String getPName() {
    return this.PName;
  }

  public void setPName(String PName) {
    this.PName = PName;
  }

  public int getPNr() {
    return this.PNr;
  }

  public void setPNr(int PNr) {
    this.PNr = PNr;
  }

  public double getPPreisNetto() {
    return this.PPreisNetto;
  }

  public void setPPreisNetto(double PPreisNetto) {
    this.PPreisNetto = PPreisNetto;
  }

  public String getPTyp() {
    return this.PTyp;
  }

  public void setPTyp(String PTyp) {
    this.PTyp = PTyp;
  }
}

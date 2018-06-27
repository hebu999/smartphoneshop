package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the produkt database table.
 * 
 */
@Entity
@NamedQuery(name = "Produkt.findAll", query = "SELECT p FROM Produkt p")
public class Produkt implements Serializable {
  private static final long serialVersionUID = 1L;

  private int FK_KatID;


  @Column(name = "FK_LID")
  private int fkLid;


  @Temporal(TemporalType.TIMESTAMP)
  private Date PAendDat;

  @Id
  @Column(insertable = false, updatable = false)
  private int pid;


  private String pimg;


  private String PIMGPfad;

  @Lob
  private String PKomment;

  private String PName;


  private int PNr;


  private BigDecimal PPreisNetto;



  private String PTyp;


  public Produkt() {}



  public int getFK_KatID() {
    return this.FK_KatID;
  }

  public void setFK_KatID(int FK_KatID) {
    this.FK_KatID = FK_KatID;
  }

  public int getFkLid() {
    return this.fkLid;
  }

  public void setFkLid(int fkLid) {
    this.fkLid = fkLid;
  }


  public Date getPAendDat() {
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



  public BigDecimal getPPreisNetto() {
    return this.PPreisNetto;
  }

  public void setPPreisNetto(BigDecimal PPreisNetto) {
    this.PPreisNetto = PPreisNetto;
  }


  public String getPTyp() {
    return this.PTyp;
  }

  public void setPTyp(String PTyp) {
    this.PTyp = PTyp;
  }

}

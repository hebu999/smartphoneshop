package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the bestellung database table.
 * 
 */
@Entity
@NamedQuery(name="Bestellung.findAll", query="SELECT b FROM Bestellung b")
public class Bestellung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date BAendDat;

	@Id
	@Column(insertable=false, updatable=false)
	private int bid;

	private String BKomment;

	@Temporal(TemporalType.DATE)
	private Date BLieferDat;

	private String BStatus;

	private int FK_FilialID;


	@Column(name="FK_ID")
	private int fkId;


	@Column(name="FK_KID")
	private int fkKid;

	public Bestellung() {
	}


	public Date getBAendDat() {
		return this.BAendDat;
	}

	public void setBAendDat(Timestamp BAendDat) {
		this.BAendDat = BAendDat;
	}



	public int getBid() {
		return this.bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}



	public String getBKomment() {
		return this.BKomment;
	}

	public void setBKomment(String BKomment) {
		this.BKomment = BKomment;
	}


	public Date getBLieferDat() {
		return this.BLieferDat;
	}

	public void setBLieferDat(Date BLieferDat) {
		this.BLieferDat = BLieferDat;
	}


	public String getBStatus() {
		return this.BStatus;
	}

	public void setBStatus(String BStatus) {
		this.BStatus = BStatus;
	}



	public int getFK_FilialID() {
		return this.FK_FilialID;
	}

	public void setFK_FilialID(int FK_FilialID) {
		this.FK_FilialID = FK_FilialID;
	}


	public int getFkId() {
		return this.fkId;
	}

	public void setFkId(int fkId) {
		this.fkId = fkId;
	}

	public int getFkKid() {
		return this.fkKid;
	}

	public void setFkKid(int fkKid) {
		this.fkKid = fkKid;
	}

}
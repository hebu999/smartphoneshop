package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lieferant database table.
 * 
 */
@Entity
@NamedQuery(name="Lieferant.findAll", query="SELECT l FROM Lieferant l")
public class Lieferant implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ansprechpartner;

	private String firma;
	
	@JoinColumn(name = "FK_AID", referencedColumnName = "adrid")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Adresse.class)
	private int fkAid;

	@Column(name="FK_HID")
	private int fkHid;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int lid;

	private String tel;

	public Lieferant() {
	}

	public String getAnsprechpartner() {
		return this.ansprechpartner;
	}

	public void setAnsprechpartner(String ansprechpartner) {
		this.ansprechpartner = ansprechpartner;
	}

	public String getFirma() {
		return this.firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public int getFkAid() {
		return this.fkAid;
	}

	public void setFkAid(int fkAid) {
		this.fkAid = fkAid;
	}

	public int getFkHid() {
		return this.fkHid;
	}

	public void setFkHid(int fkHid) {
		this.fkHid = fkHid;
	}

	public int getLid() {
		return this.lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
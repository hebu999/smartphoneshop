package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the services database table.
 * 
 */
@Entity
@Table(name="services")
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="FK_HID")
	private int fkHid;

	private int SDauer;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int sid;

	private BigDecimal SPreis;

	private String STyp;

	public Service() {
	}

	public int getFkHid() {
		return this.fkHid;
	}

	public void setFkHid(int fkHid) {
		this.fkHid = fkHid;
	}

	public int getSDauer() {
		return this.SDauer;
	}

	public void setSDauer(int SDauer) {
		this.SDauer = SDauer;
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public BigDecimal getSPreis() {
		return this.SPreis;
	}

	public void setSPreis(BigDecimal SPreis) {
		this.SPreis = SPreis;
	}

	public String getSTyp() {
		return this.STyp;
	}

	public void setSTyp(String STyp) {
		this.STyp = STyp;
	}

}
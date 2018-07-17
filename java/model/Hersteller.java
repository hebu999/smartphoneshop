package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hersteller database table.
 * 
 */
@Entity
@NamedQuery(name="Hersteller.findAll", query="SELECT h FROM Hersteller h")
public class Hersteller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int hid;

	private String name;

	public Hersteller() {
	}

	public int getHid() {
		return this.hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
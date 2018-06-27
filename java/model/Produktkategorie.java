package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produktkategorie database table.
 * 
 */
@Entity
@NamedQuery(name="Produktkategorie.findAll", query="SELECT p FROM Produktkategorie p")
public class Produktkategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=false, updatable=false)
	private int PKatID;


	private String PKatName;


	public Produktkategorie() {
	}


	public int getPKatID() {
		return this.PKatID;
	}

	public void setPKatID(int PKatID) {
		this.PKatID = PKatID;
	}


	public String getPKatName() {
		return this.PKatName;
	}

	public void setPKatName(String PKatName) {
		this.PKatName = PKatName;
	}

}
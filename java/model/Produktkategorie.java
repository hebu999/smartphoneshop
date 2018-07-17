package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The persistent class for the produktkategorie database table.
 * 
 */
@Entity
@NamedQuery(name="Produktkategorie.findAll", query="SELECT p FROM Produktkategorie p")
public class Produktkategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
    @NotNull
	@Column(insertable=false, updatable=false)
	private int PKatID;

	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
	private String PKatName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "FK_KatID", fetch = FetchType.LAZY)
    private List<Produkt> produktList;

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
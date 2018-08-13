package org.este.resturant.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tables implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTable;
	@NotEmpty
	private String typeTable;
	@NotEmpty
	private int nombreTable;
	private boolean etatTable;
	public Long getIdTable() {
		return idTable;
	}
	public void setIdTable(Long idTable) {
		this.idTable = idTable;
	}
	public String getTypeTable() {
		return typeTable;
	}
	public void setTypeTable(String typeTable) {
		this.typeTable = typeTable;
	}
	public int getNombreTable() {
		return nombreTable;
	}
	public void setNombreTable(int nombreTable) {
		this.nombreTable = nombreTable;
	}
	public boolean isEtatTable() {
		return etatTable;
	}
	public void setEtatTable(boolean etatTable) {
		this.etatTable = etatTable;
	}
	public Tables() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tables(String typeTable, int nombreTable, boolean etatTable) {
		super();
		this.typeTable = typeTable;
		this.nombreTable = nombreTable;
		this.etatTable = etatTable;
	}
}

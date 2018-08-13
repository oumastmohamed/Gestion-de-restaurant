package org.este.resturant.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Produit implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	@NotEmpty
	@Size(min=4,max=100)
	private String nomProduit;
	private String description;
	@NumberFormat
	private double prix;
	private boolean etatProduit;
	@Lob
	private byte[] photo;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isEtatProduit() {
		return etatProduit;
	}
	public void setEtatProduit(boolean etatProduit) {
		this.etatProduit = etatProduit;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String nomProduit, String description, double prix, boolean etatProduit, byte[] photo) {
		super();
		this.nomProduit = nomProduit;
		this.description = description;
		this.prix = prix;
		this.etatProduit = etatProduit;
		this.photo = photo;
	}
}

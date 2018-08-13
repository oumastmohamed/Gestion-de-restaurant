package org.este.resturant.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cassier implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCassier;
	@NotEmpty
	private String nomCassier;
	@NotEmpty
	private String prenomCassier;
	private String adresse;
	@Size(min=10,max=12)
	private String tel;
	@NotEmpty
	@Email
	private String email;
	private String sexe;
	@NumberFormat
	private double salaire;
	
	public Long getIdCassier() {
		return idCassier;
	}
	public void setIdCassier(Long idCassier) {
		this.idCassier = idCassier;
	}
	public String getNomCassier() {
		return nomCassier;
	}
	public void setNomCassier(String nomCassier) {
		this.nomCassier = nomCassier;
	}
	public String getPrenomCassier() {
		return prenomCassier;
	}
	public void setPrenomCassier(String prenomCassier) {
		this.prenomCassier = prenomCassier;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	public Cassier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cassier(String nomCassier, String prenomCassier, String adresse, String tel, String email, String sexe,
			double salaire) {
		super();
		this.nomCassier = nomCassier;
		this.prenomCassier = prenomCassier;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.sexe = sexe;
		this.salaire = salaire;
	}
}

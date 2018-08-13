package org.este.resturant.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Serveur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idServeur;
	@NotEmpty
	private String nomServeur;
	@NotEmpty
	private String prenomServeur;
	private String adresse;
	@Size(min=10,max=12)
	private String tel;
	@NotEmpty
	@Email
	private String email;
	private String sexe;
	@NumberFormat
	private double salaire;
	
	public Long getIdServeur() {
		return idServeur;
	}
	public void setIdServeur(Long idServeur) {
		this.idServeur = idServeur;
	}
	public String getNomServeur() {
		return nomServeur;
	}
	public void setNomServeur(String nomServeur) {
		this.nomServeur = nomServeur;
	}
	public String getPrenomServeur() {
		return prenomServeur;
	}
	public void setPrenomServeur(String prenomServeur) {
		this.prenomServeur = prenomServeur;
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
	
	public Serveur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Serveur(String nomServeur, String prenomServeur, String adresse, String tel, String email, String sexe,
			double salaire) {
		super();
		this.nomServeur = nomServeur;
		this.prenomServeur = prenomServeur;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.sexe = sexe;
		this.salaire = salaire;
	}
}

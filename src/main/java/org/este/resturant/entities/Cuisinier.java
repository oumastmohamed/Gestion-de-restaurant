package org.este.resturant.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
@Entity
public class Cuisinier implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCuisinier;
	@NotEmpty
	private String nomCuisinier;
	@NotEmpty
	private String prenomCuisinier;
	private String adresse;
	@Size(min=10,max=12)
	private String tel;
	@NotEmpty
	@Email
	private String email;
	private String sexe;
	@NumberFormat
	private double salaire;
	@NotEmpty
	private String grade;
	
	public Long getIdCuisinier() {
		return idCuisinier;
	}
	public void setIdCuisinier(Long idCuisinier) {
		this.idCuisinier = idCuisinier;
	}
	public String getNomCuisinier() {
		return nomCuisinier;
	}
	public void setNomCuisinier(String nomCuisinier) {
		this.nomCuisinier = nomCuisinier;
	}
	public String getPrenomCuisinier() {
		return prenomCuisinier;
	}
	public void setPrenomCuisinier(String prenomCuisinier) {
		this.prenomCuisinier = prenomCuisinier;
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
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Cuisinier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuisinier(String nomCuisinier, String prenomCuisinier, String adresse, String tel, String email, String sexe,
			double salaire, String grade) {
		super();
		this.nomCuisinier = nomCuisinier;
		this.prenomCuisinier = prenomCuisinier;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.sexe = sexe;
		this.salaire = salaire;
		this.grade = grade;
	}
}

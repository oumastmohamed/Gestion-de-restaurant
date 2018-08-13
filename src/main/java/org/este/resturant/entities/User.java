package org.este.resturant.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.access.annotation.Secured;
@Entity
@Table(name="users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long idUser;
	@NotEmpty
	@Column(name="user_name")
	private String login;
	@Size(min=4,max=20)
	private String password;
	private byte[] passwordByte;
	private boolean actived;
	@OneToMany
	@JoinColumn(name="user_id")
	private Collection<Role> roles;
	@ManyToOne
	@JoinColumn(name="idCassier")
	private Cassier cassier;
	@ManyToOne
	@JoinColumn(name="idAdmin")
	private Admin admin;
	@ManyToOne
	@JoinColumn(name="idServeur")
	private Serveur serveur;
	@ManyToOne
	@JoinColumn(name="idCuisinier")
	private Cuisinier cuisinier;
	
	private Long emailUserUtil;
	private String nomPrenomUtil;
	private String nomroleUtil;
	
	
	public byte[] getPasswordByte() {
		return passwordByte;
	}
	public void setPasswordByte(byte[] passwordByte) {
		this.passwordByte = passwordByte;
	}
	public String getNomPrenomUtil() {
		return nomPrenomUtil;
	}
	public void setNomPrenomUtil(String nomPrenomUtil) {
		this.nomPrenomUtil = nomPrenomUtil;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public Cassier getCassier() {
		return cassier;
	}
	public void setCassier(Cassier cassier) {
		this.cassier = cassier;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Serveur getServeur() {
		return serveur;
	}
	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}
	public Cuisinier getCuisinier() {
		return cuisinier;
	}
	public void setCuisinier(Cuisinier cuisinier) {
		this.cuisinier = cuisinier;
	}
	public Long getEmailUserUtil() {
		return emailUserUtil;
	}
	public void setEmailUserUtil(Long emailUserUtil) {
		this.emailUserUtil = emailUserUtil;
	}
	public String getNomroleUtil() {
		return nomroleUtil;
	}
	public void setNomroleUtil(String nomroleUtil) {
		this.nomroleUtil = nomroleUtil;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", password=" + password + ", passwordByte="
				+ Arrays.toString(passwordByte) + ", actived=" + actived + ", roles=" + roles + ", cassier=" + cassier
				+ ", admin=" + admin + ", serveur=" + serveur + ", cuisinier=" + cuisinier + ", emailUserUtil="
				+ emailUserUtil + ", nomPrenomUtil=" + nomPrenomUtil + ", nomroleUtil=" + nomroleUtil + "]";
	}
	
}

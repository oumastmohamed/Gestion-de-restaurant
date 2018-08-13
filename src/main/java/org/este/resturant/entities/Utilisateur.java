package org.este.resturant.entities;

import java.io.Serializable;

public class Utilisateur implements Serializable{
	private Long idUtil;
	private String emailUtil;
	private String nomRole;
	private Long idRole;

	public Long getIdUtil() {
		return idUtil;
	}

	public void setIdUtil(Long idUtil) {
		this.idUtil = idUtil;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	public String getEmailUtil() {
		return emailUtil;
	}

	public void setEmailUtil(String emailUtil) {
		this.emailUtil = emailUtil;
	}

	public Utilisateur() {
		super();
	}
}

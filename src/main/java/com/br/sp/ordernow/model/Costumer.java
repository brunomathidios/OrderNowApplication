package com.br.sp.ordernow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="ODN_USER")
public class Costumer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_USER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;

	@Column(name = "NM_USER")
	private String nmUser;
	
	@Column(name = "LOGIN_USER")
	private String loginUser;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "PWD_USER")
	private String pwdUser;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNmUser() {
		return nmUser;
	}

	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPwdUser() {
		return pwdUser;
	}

	public void setPwdUser(String pwdUser) {
		this.pwdUser = pwdUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((loginUser == null) ? 0 : loginUser.hashCode());
		result = prime * result + ((nmUser == null) ? 0 : nmUser.hashCode());
		result = prime * result + ((pwdUser == null) ? 0 : pwdUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costumer other = (Costumer) obj;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (loginUser == null) {
			if (other.loginUser != null)
				return false;
		} else if (!loginUser.equals(other.loginUser))
			return false;
		if (nmUser == null) {
			if (other.nmUser != null)
				return false;
		} else if (!nmUser.equals(other.nmUser))
			return false;
		if (pwdUser == null) {
			if (other.pwdUser != null)
				return false;
		} else if (!pwdUser.equals(other.pwdUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nmUser=" + nmUser + "]";
	}
}

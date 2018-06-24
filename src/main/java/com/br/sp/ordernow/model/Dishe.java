package com.br.sp.ordernow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ODN_DISHE")
public class Dishe {
	
	@Id
	@Column(name = "ID_DISHE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDishe;
	
	@Column(name = "NM_DISHE")
	private String nmDishe;

	public Long getIdDishe() {
		return idDishe;
	}

	public void setIdDishe(Long idDishe) {
		this.idDishe = idDishe;
	}

	public String getNmDishe() {
		return nmDishe;
	}

	public void setNmDishe(String nmDishe) {
		this.nmDishe = nmDishe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDishe == null) ? 0 : idDishe.hashCode());
		result = prime * result + ((nmDishe == null) ? 0 : nmDishe.hashCode());
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
		Dishe other = (Dishe) obj;
		if (idDishe == null) {
			if (other.idDishe != null)
				return false;
		} else if (!idDishe.equals(other.idDishe))
			return false;
		if (nmDishe == null) {
			if (other.nmDishe != null)
				return false;
		} else if (!nmDishe.equals(other.nmDishe))
			return false;
		return true;
	}

}

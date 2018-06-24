package com.br.sp.ordernow.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ODN_RESTAURANT")
public class Restaurant {
	
	@Id
	@Column(name = "ID_RESTAURANT")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRest;

	@Column(name = "NM_RESTAURANT")
	private String nmRest;
	
	@Column(name = "ID_DISHE")
	private Long idDishe;
	
	/**
	 * The annotation @JsonManagedReference is to make the reference 'productList' and fields serialized.
	 */
	@JsonManagedReference
	@OneToMany(mappedBy = "rest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Product> productList;

	public Long getIdRest() {
		return idRest;
	}

	public void setIdRest(Long idRest) {
		this.idRest = idRest;
	}

	public String getNmRest() {
		return nmRest;
	}

	public void setNmRest(String nmRest) {
		this.nmRest = nmRest;
	}

	public Long getIdDishe() {
		return idDishe;
	}

	public void setIdDishe(Long idDishe) {
		this.idDishe = idDishe;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDishe == null) ? 0 : idDishe.hashCode());
		result = prime * result + ((idRest == null) ? 0 : idRest.hashCode());
		result = prime * result + ((nmRest == null) ? 0 : nmRest.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (idDishe == null) {
			if (other.idDishe != null)
				return false;
		} else if (!idDishe.equals(other.idDishe))
			return false;
		if (idRest == null) {
			if (other.idRest != null)
				return false;
		} else if (!idRest.equals(other.idRest))
			return false;
		if (nmRest == null) {
			if (other.nmRest != null)
				return false;
		} else if (!nmRest.equals(other.nmRest))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Restaurant [idRest=" + idRest + ", nmRest=" + nmRest + "]";
	}

}

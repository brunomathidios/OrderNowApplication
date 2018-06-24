package com.br.sp.ordernow.model;

import java.time.LocalDateTime;
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
@Table(name="ODN_ORDER")
public class Order {

	@Id
	@Column(name = "ID_ORDER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrder;
	
	@Column(name = "ID_RESTAURANT")
	private Long idRest;
	
	@Column(name = "ID_USER")
	private Long idUser;
	
	@Column(name = "IN_STATUS_ORDER")
	private String inStatusOrder;
	
	@Column(name="DT_ORDER")
	private LocalDateTime dtOrder;
	
	@Column(name = "FL_AVAL")
	private String flAval;
	
	@Column(name = "RATING")
	private Integer rating;
	
	/**
	 * The annotation @JsonManagedReference is to make the reference 'orderProductList' and fields serialized.
	 */
	@JsonManagedReference
    @OneToMany( mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderProduct> orderProductList;

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Long getIdRest() {
		return idRest;
	}

	public void setIdRest(Long idRest) {
		this.idRest = idRest;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getInStatusOrder() {
		return inStatusOrder;
	}

	public void setInStatusOrder(String inStatusOrder) {
		this.inStatusOrder = inStatusOrder;
	}

	public LocalDateTime getDtOrder() {
		return dtOrder;
	}

	public void setDtOrder(LocalDateTime dtOrder) {
		this.dtOrder = dtOrder;
	}

	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtOrder == null) ? 0 : dtOrder.hashCode());
		result = prime * result + ((flAval == null) ? 0 : flAval.hashCode());
		result = prime * result + ((idOrder == null) ? 0 : idOrder.hashCode());
		result = prime * result + ((idRest == null) ? 0 : idRest.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((inStatusOrder == null) ? 0 : inStatusOrder.hashCode());
		result = prime * result + ((orderProductList == null) ? 0 : orderProductList.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
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
		Order other = (Order) obj;
		if (dtOrder == null) {
			if (other.dtOrder != null)
				return false;
		} else if (!dtOrder.equals(other.dtOrder))
			return false;
		if (flAval == null) {
			if (other.flAval != null)
				return false;
		} else if (!flAval.equals(other.flAval))
			return false;
		if (idOrder == null) {
			if (other.idOrder != null)
				return false;
		} else if (!idOrder.equals(other.idOrder))
			return false;
		if (idRest == null) {
			if (other.idRest != null)
				return false;
		} else if (!idRest.equals(other.idRest))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (inStatusOrder == null) {
			if (other.inStatusOrder != null)
				return false;
		} else if (!inStatusOrder.equals(other.inStatusOrder))
			return false;
		if (orderProductList == null) {
			if (other.orderProductList != null)
				return false;
		} else if (!orderProductList.equals(other.orderProductList))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
	}

}

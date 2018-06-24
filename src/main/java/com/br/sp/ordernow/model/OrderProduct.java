package com.br.sp.ordernow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ODN_ORDER_PRODUCT")
public class OrderProduct {

	@Id
	@Column(name = "ID_ORDER_PRODUCT")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrderProduct;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ORDER")
	private Order order;
	
	@Column(name="ID_PRODUCT")
	private Long idProduct;

	public Long getIdOrderProduct() {
		return idOrderProduct;
	}

	public void setIdOrderProduct(Long idOrderProduct) {
		this.idOrderProduct = idOrderProduct;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOrderProduct == null) ? 0 : idOrderProduct.hashCode());
		result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		OrderProduct other = (OrderProduct) obj;
		if (idOrderProduct == null) {
			if (other.idOrderProduct != null)
				return false;
		} else if (!idOrderProduct.equals(other.idOrderProduct))
			return false;
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
}

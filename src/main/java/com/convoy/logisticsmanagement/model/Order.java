package com.convoy.logisticsmanagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	private int id;
	
	private String orderdate;
	private String status="placed";
	private int cost;
	private String email;
	
	@ManyToOne
	private Carrier carrier;
	@OneToOne(cascade = CascadeType.ALL)
	private Cargo cargo;
	@OneToOne(cascade = CascadeType.ALL)
	private Loading loading;
	@OneToOne(cascade = CascadeType.ALL)
	private Unloading unloading;
	
	public Order() {
		super();
	}
	public Order(int id, String orderdate, String status, int cost, String email, Carrier carrier, Cargo cargo,
			Loading loading, Unloading unloading) {
		super();
		this.id = id;
		this.orderdate = orderdate;
		this.status = status;
		this.cost = cost;
		this.email = email;
		this.carrier = carrier;
		this.cargo = cargo;
		this.loading = loading;
		this.unloading = unloading;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Loading getLoading() {
		return loading;
	}
	public void setLoading(Loading loading) {
		this.loading = loading;
	}
	public Unloading getUnloading() {
		return unloading;
	}
	public void setUnloading(Unloading unloading) {
		this.unloading = unloading;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderdate=" + orderdate + ", status=" + status + ", cost=" + cost + ", email="
				+ email + ", carrier=" + carrier + ", cargo=" + cargo + ", loading=" + loading + ", unloading="
				+ unloading + "]";
	}
}

package com.convoy.logisticsmanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DriverDto {
	@NotNull
	@Positive
	private int id;
	@NotNull
	private String name;
	@NotNull
	@Positive
	private long contact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public DriverDto(@NotNull @Positive int id, String name, @NotNull @Positive long contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "DriverDto [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}
}

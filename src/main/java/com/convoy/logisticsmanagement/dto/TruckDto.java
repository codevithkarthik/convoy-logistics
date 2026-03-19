package com.convoy.logisticsmanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TruckDto {
	@NotNull
	@Positive
	private int id;
	@NotNull
	private String name;
	@NotNull
	@Positive
	private int number;
	@NotNull
	@Positive
	private int capacity;
	private String status;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TruckDto(@NotNull @Positive int id, @NotNull String name, @NotNull @Positive int number,
			@NotNull @Positive int capacity, String status) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.capacity = capacity;
		this.status = status;
	}
	public TruckDto() {
		super();
	}
	@Override
	public String toString() {
		return "TruckDto [id=" + id + ", name=" + name + ", number=" + number + ", capacity=" + capacity + ", status="
				+ status + "]";
	}
}

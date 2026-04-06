package com.convoy.logisticsmanagement.dto;

import jakarta.validation.constraints.NotNull;

public class LoadingDto {
	@NotNull
	private String date;
	@NotNull
	private String time;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public LoadingDto(@NotNull String date, @NotNull String time) {
		super();
		this.date = date;
		this.time = time;
	}
	public LoadingDto() {
		super();
	}
	@Override
	public String toString() {
		return "LoadingDto [date=" + date + ", time=" + time + "]";
	}
}

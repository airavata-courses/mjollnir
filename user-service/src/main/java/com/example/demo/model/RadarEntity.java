package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class RadarEntity {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO) 
	    private long id;
	private String radarId;
	private String userName;
	private LocalDate startDate;
	private LocalDate endDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRadarId() {
		return radarId;
	}
	public void setRadarId(String radarId) {
		this.radarId = radarId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public RadarEntity( String radarId, String userName, LocalDate startDate, LocalDate endDate) {
		super();
		this.radarId = radarId;
		this.userName = userName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}

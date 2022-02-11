package com.example.demo.model;



import org.springframework.stereotype.Component;


public class RadarData {
    private long id;
private String radarId;
private String userName;
private String year;
private String month;
private String date;
private String startHour;
private String endHour;
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
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getStartHour() {
	return startHour;
}
public void setStartHour(String startHour) {
	this.startHour = startHour;
}
public String getEndHour() {
	return endHour;
}
public void setEndHour(String endHour) {
	this.endHour = endHour;
}
public RadarData(long id, String radarId, String userName, String year, String month, String date, String startHour,
		String endHour) {
	super();
	this.id = id;
	this.radarId = radarId;
	this.userName = userName;
	this.year = year;
	this.month = month;
	this.date = date;
	this.startHour = startHour;
	this.endHour = endHour;
}
}

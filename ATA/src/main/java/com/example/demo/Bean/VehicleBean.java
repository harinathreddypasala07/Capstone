package com.example.demo.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="ATA_TBL_VEHICLE")
public class VehicleBean {
	public int getVehicleID() {
		return VehicleID;
	}
	public void setVehicleID(int vehicleID) {
		VehicleID = vehicleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getSeatingapacity() {
		return seatingapacity;
	}
	public void setSeatingapacity(String seatingapacity) {
		this.seatingapacity = seatingapacity;
	}
	public String getFarePerKM() {
		return farePerKM;
	}
	public void setFarePerKM(String farePerKM) {
		this.farePerKM = farePerKM;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int VehicleID;
 @Column
 private String name;
@Column
 private String type;
@Column
 private String registrationNumber;
@Column
 private String seatingapacity;
@Column
 private String farePerKM;
}

package com.example.demo.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="ATA_TBL_DRIVER")
public class DriverBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int driverID;
@Column          
    private String  name;
@Column       
   private String  street;
@Column
   private String  location;
@Column
    private String city;
@Column
    private String state;
@Column
   private String  pincode;
@Column
   private String  mobileno;
@Column
   private String  licenseNumber;
@OneToOne
@JoinColumn(name="vehicleid")
private VehicleBean vehicleBean;

public VehicleBean getVehicleBean() {
	return vehicleBean;
}
public void setVehicleBean(VehicleBean vehicleBean) {
	this.vehicleBean = vehicleBean;
}
public int getDriverID() {
	return driverID;
}
public void setDriverID(int driverID) {
	this.driverID = driverID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public String getLicenseNumber() {
	return licenseNumber;
}
public void setLicenseNumber(String licenseNumber) {
	this.licenseNumber = licenseNumber;
}

}

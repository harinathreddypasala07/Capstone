package com.example.demo.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="ATA_TBL_RESERVATION")
public class ReservationBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int reservationID;
	@ManyToOne
	 @JoinColumn(name="user_Id")
  private CredentialsBean credentialsBean;
 @ManyToOne
 @JoinColumn(name="route_Id")
 private RouteBean routeBean;
 
@Column
 private String journeyDate;
@Column
private String bookingDate;

//@ManyToOne
//@JoinColumn(name="vehicle_Id")
// private VehicleBean vehicleBean;


@ManyToOne
@JoinColumn(name="driver_Id")
 private DriverBean driverBean;

@Column
 private String bookingStatus;
@Column
 private String totalFare;
@Column
 private String boardingPoint;
@Column
 private String dropPoint;
  
public CredentialsBean getCredentialsBean() {
	return credentialsBean;
}
public void setCredentialsBean(CredentialsBean credentialsBean) {
	this.credentialsBean = credentialsBean;
}
public DriverBean getDriverBean() {
	return driverBean;
}
public void setDriverBean(DriverBean driverBean) {
	this.driverBean = driverBean;
}
//public VehicleBean getVehicleBean() {
//	return vehicleBean;
//}
//public void setVehicleBean(VehicleBean vehicleBean) {
//	this.vehicleBean = vehicleBean;
//}
public int getReservationID() {
	return reservationID;
}
public void setReservationID(int reservationID) {
	this.reservationID = reservationID;
}

  
public RouteBean getRouteBean() {
	return routeBean;
}
public void setRouteBean(RouteBean routeBean) {
	this.routeBean = routeBean;
}
public String getBookingDate() {
	return bookingDate;
}
public void setBookingDate(String bookingDate) {
	this.bookingDate = bookingDate;
}
public String getJourneyDate() {
	return journeyDate;
}
public void setJourneyDate(String journeyDate) {
	this.journeyDate = journeyDate;
}


public String getBookingStatus() {
	return bookingStatus;
}
public void setBookingStatus(String bookingStatus) {
	this.bookingStatus = bookingStatus;
}
public String getTotalFare() {
	return totalFare;
}
public void setTotalFare(String totalFare) {
	this.totalFare = totalFare;
}
public String getBoardingPoint() {
	return boardingPoint;
}
public void setBoardingPoint(String boardingPoint) {
	this.boardingPoint = boardingPoint;
}
public String getDropPoint() {
	return dropPoint;
}
public void setDropPoint(String dropPoint) {
	this.dropPoint = dropPoint;
}
}

package com.example.demo.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bean.CredentialsBean;
import com.example.demo.Bean.ProfileBean;
import com.example.demo.Bean.ReservationBean;
import com.example.demo.Bean.RouteBean;
import com.example.demo.Bean.VehicleBean;
import com.example.demo.Dao.CustomerDao;

@Service
public class CustomerService {
 @Autowired
 private CustomerDao cdao;
 
 public String bookVehicle(ReservationBean reservationBean) 
	{
		return cdao.bookVehicle(reservationBean);
	}
 public ReservationBean viewResevationById(int reservationID)
	{
		return cdao.viewResevationById(reservationID);
	}
 public  List<VehicleBean> viewVehicleByType(String type)
	{
		return cdao.viewVehicleByType(type);
	}
 
 public  List<VehicleBean> viewVehicleBySeatingCapacity(String seatingapacity)
	{
		return cdao.viewVehicleBySeatingCapacity(seatingapacity);
	}
 public  List<RouteBean> viewRoute()
	{
		return cdao.viewRoute();
	}
 public ProfileBean getCustomerById(int userID) {
	 return cdao.getCustomerById(userID);
 }
 public ArrayList<ReservationBean> getReservationByuserId(String userId){
	 return cdao.getReservationByuserId(userId);
 }
 public CredentialsBean viewCredentialById(String userId) {
	 return cdao.viewCredentialById(userId);
 }
 public String deleteReservation(int reservationID){
	 return cdao.deleteReservation(reservationID);
 }
}
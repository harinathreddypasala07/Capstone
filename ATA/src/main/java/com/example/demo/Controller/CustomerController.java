package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.CredentialsBean;
import com.example.demo.Bean.DriverBean;
import com.example.demo.Bean.ProfileBean;
import com.example.demo.Bean.ReservationBean;
import com.example.demo.Bean.RouteBean;
import com.example.demo.Bean.VehicleBean;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.CustomerService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {
@Autowired
private CustomerService cuserv;
@Autowired
private AdminService adserv;

@PostMapping("/bookVehicle")
public String meth1(@RequestBody ReservationBean rb)
{
	cuserv.bookVehicle(rb);
	return "Booked Successfully";
}
@GetMapping("/booking/{id}")
public ReservationBean meth2(@PathVariable(value = "id") int reservationID)
{
	return cuserv.viewResevationById(reservationID);
	
}
@GetMapping("/vehicle/{type}")
public  List<VehicleBean> meth3(@PathVariable(value = "type") String type)
{
	return cuserv.viewVehicleByType(type);
	
}
@GetMapping("/vehicleCapacity/{seatingcapacity}")
public  List<VehicleBean> meth4(@PathVariable(value = "seatingcapacity") String seatingapacity)
{
	return cuserv.viewVehicleBySeatingCapacity(seatingapacity);
	
}
@GetMapping("/print/{id}")
public ReservationBean meth5(@PathVariable(value = "id") int reservationID)
{
	return cuserv.viewResevationById(reservationID);
	
}
@GetMapping("/viewRoute")
public List<RouteBean> meth6()
{
	
	return cuserv.viewRoute();
}
@GetMapping("/customer/{id}")
public ProfileBean meth22(@PathVariable(value = "id") int userID)
{
	return cuserv.getCustomerById(userID);
	
}
@GetMapping("/viewDriver")
public List<DriverBean> meth13()
{
	
	return adserv.viewDriver();
}
@GetMapping("/route/{id}")
public RouteBean meth123(@PathVariable(value = "id") int routeID)
{
	return adserv.viewRouteById(routeID);
	
}
@GetMapping("/driver/{id}")
public DriverBean meth1234(@PathVariable(value = "id") int driverID)
{
	return adserv.viewDriverById(driverID);
	
}
@GetMapping("/creditial/{id}")
public CredentialsBean meth12349(@PathVariable(value = "id") String userId)
{
	return cuserv.viewCredentialById(userId);
	
}
@GetMapping("/reservationbyuser/{id}")
public  ArrayList<ReservationBean> meth12345(@PathVariable(value = "id") String userId)
{
	return cuserv.getReservationByuserId(userId);
	
}
@GetMapping("/profiless")
public List<ProfileBean> meth1257656()
{
    
    return adserv.viewProfile();
}
@PostMapping("/addProfile")
public String meth1354(@RequestBody ProfileBean pb)
{
    adserv.addProfile(pb);
    return "Profile Added Successfully";

}


@DeleteMapping("/deletereservation/{id}")
public String meth234(@PathVariable(value="id") int reservationID)
{
	return cuserv.deleteReservation(reservationID)+" record deleted successfully";
}
}

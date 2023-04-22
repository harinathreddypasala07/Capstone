package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.CredentialsBean;
import com.example.demo.Bean.DriverBean;
import com.example.demo.Bean.ReservationBean;
import com.example.demo.Bean.RouteBean;
import com.example.demo.Bean.VehicleBean;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.CustomerService;





@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {
@Autowired
private AdminService adserv;

@Autowired
private CustomerService cuserv;
@GetMapping("/viewRoute")
public List<RouteBean> meth12()
{
	
	return adserv.viewRoute();
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
@GetMapping("/viewDriver")
public List<DriverBean> meth13()
{
	
	return adserv.viewDriver();
}
@GetMapping("/viewVehicle")
public List<VehicleBean> meth14()
{
	
	return adserv.viewVehicle();
}
@PostMapping("/addVehicle")
public String meth1(@RequestBody VehicleBean vb)
{
	adserv.addVehicle(vb);
	return "Vehicle Added Successfully";	
}
@DeleteMapping("/deleteVehicle/{id}")
public String meth2(@PathVariable(value="id") int VehicleId)
{
	return adserv.deleteVehicle(VehicleId)+" record deleted successfully";
}
@GetMapping("/Vehicle/{id}")
public VehicleBean meth3(@PathVariable(value = "id") int VehicleID)
{
	return adserv.viewVehicleById(VehicleID);
	
}
@PutMapping("/modifyVehicle")
public String meth4(@RequestBody VehicleBean vb)
{
	adserv.modifyVehicle(vb);
	return " Vehicle Updated successfully";
}
@PostMapping("/addDriver")
public String meth5(@RequestBody DriverBean db)
{
	adserv.addDriver(db);
	return "Driver Added Successfully";
}
@DeleteMapping("/deleteDriver/{id}")
public String meth6(@PathVariable(value="id") int DriverId)
{
	return adserv.deleteDriver(DriverId)+" record deleted successfully";
}
@PutMapping("/modifyDriver")
public String meth7(@RequestBody DriverBean db)
{
	adserv.modifyDriver(db);
	return " Driver Updated successfully";
}
@PostMapping("/addRoute")
public String meth8(@RequestBody RouteBean db)
{
	adserv.addRoute(db);
	return "Route Added Successfully";
}
@DeleteMapping("/deleteRoute/{id}")
public String meth9(@PathVariable(value="id") int routeID)
{
	return adserv.deleteRoute(routeID)+" record deleted successfully";
}
@GetMapping("/viewRoutes")
public List<RouteBean> meth10()
{	
	return cuserv.viewRoute();
}
@PutMapping("/modifyRoute")
public String meth11(@RequestBody RouteBean rb)
{
	adserv.modifyRoute(rb);
	return " Route Updated successfully";
}
@GetMapping("/reservationsDetails/{journeyDate}/{source}/{destination}")
public List<ReservationBean> viewReservationByJourneyDetails(@PathVariable String journeyDate, @PathVariable String source, @PathVariable String destination) {
    return adserv.viewReservationByJourneyDetails(journeyDate, source, destination);
}
@GetMapping("/reservation")
public List<ReservationBean> meth1256()
{
	
	return adserv. viewReservations();
}
@GetMapping("/selectUser/{userId}/{password}")
@ResponseBody
public boolean auth(@PathVariable String userId,@PathVariable String password)
{
    System.out.println("Under Controller "+userId+" "+password);
    CredentialsBean cb=new CredentialsBean();
    cb.setUserId(userId);
    cb.setPassword(password);
    System.out.println(adserv.authenticate(cb));;
    return adserv.authenticate(cb);

}
@GetMapping("/userbyid/{id}")
public CredentialsBean  meth1256b(@PathVariable(value = "id") String userId)
{
	
	return adserv. viewcredentialsById(userId);
}
}

package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bean.CredentialsBean;
import com.example.demo.Bean.DriverBean;
import com.example.demo.Bean.ProfileBean;
import com.example.demo.Bean.ReservationBean;
import com.example.demo.Bean.RouteBean;
import com.example.demo.Bean.VehicleBean;
import com.example.demo.Dao.AdminDao;


@Service
public class AdminService {
	@Autowired
	
	private AdminDao aadao;
	 public  List<RouteBean> viewRoute()
		{
			return aadao.viewRoute();
		}
	 public  List<DriverBean> viewDriver()
		{
			return aadao.viewDriver();
		}
	 public  List<VehicleBean> viewVehicle()
		{
			return aadao.viewVehicle();
		}
	public String addVehicle(VehicleBean vehicleBean) 
	{
		return aadao.addVehicle(vehicleBean);
	}
	public String deleteVehicle(int VehicleId)
	{
		return aadao.deleteVehicle(VehicleId);
	}
	public VehicleBean viewVehicleById(int VehicleID)
	{
		return aadao.viewVehicleById(VehicleID);
	}
	public RouteBean viewRouteById(int routeID)
	{
		return aadao.viewRouteById(routeID);
	}
	public DriverBean viewDriverById(int driverID)
	{
		return aadao.viewDriverById(driverID);
	}
	public boolean modifyVehicle(VehicleBean vehicleBean)
	{
		return aadao.modifyVehicle(vehicleBean);
	}
	public String addDriver(DriverBean driverBean) 
	{
		return aadao.addDriver(driverBean);
	}
	public String deleteDriver(int driverId)
	{
		return aadao.deleteDriver(driverId);
	}
	public boolean modifyDriver(DriverBean driverBean)
	{
		return aadao.modifyDriver(driverBean);
	}
	public String addRoute(RouteBean routeBean) 
	{
		return aadao.addRoute(routeBean);
	}
	public String deleteRoute(int routeID)
	{
		return aadao.deleteRoute(routeID);
	}
	public boolean modifyRoute(RouteBean routeBean)
	{
		return aadao.modifyRoute(routeBean);
	}
	public List<ReservationBean> viewReservationByJourneyDetails(String journeyDate, String source, String destination) {
	    return aadao.viewReservationByJourneyDetails(journeyDate, source, destination);
	}
	public List<ReservationBean>  viewReservations()
	{
		return aadao.viewReservations();
	}
	public  List<ProfileBean> viewProfile()
    {
        return aadao.viewProfile();
    }
    public String addProfile(ProfileBean profileBean) 
    {
        return aadao.addProfile(profileBean);
    }
    public boolean authenticate(CredentialsBean user) {
        return aadao.authenticate(user);
    }
    public CredentialsBean viewcredentialsById(String userId) {
    	return aadao.viewcredentialsById(userId);
    }

	
}

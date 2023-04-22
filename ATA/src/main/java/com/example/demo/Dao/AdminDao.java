package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Bean.CredentialsBean;
import com.example.demo.Bean.DriverBean;
import com.example.demo.Bean.ProfileBean;
import com.example.demo.Bean.ReservationBean;
import com.example.demo.Bean.RouteBean;
import com.example.demo.Bean.VehicleBean;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;







@Repository
public class AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query q;
	
	public String addVehicle(VehicleBean vehicleBean ) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(vehicleBean);
		transaction.commit();
		session.close();
		return "SUCCESS";
	}
	public String deleteVehicle(int VehicleID){
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query q1=session.createQuery("delete from VehicleBean where VehicleID=:VehicleID");
		q1.setParameter("VehicleID",VehicleID);
		q1.executeUpdate();
        transaction.commit();
        return "SUCCESS";
	}
	public VehicleBean viewVehicleById(int VehicleID) {
	
		VehicleBean elBean=new VehicleBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<VehicleBean> q2=session.createQuery("from VehicleBean where VehicleID=:VehicleID");
	q2.setParameter("VehicleID", VehicleID);
	ArrayList<VehicleBean> all=(ArrayList<VehicleBean>) q2.getResultList();
	for(VehicleBean e1:all)
	{
		elBean=e1;
	}
	return elBean;
	}

	public boolean modifyVehicle(VehicleBean vehicleBean) {
	    boolean isSuccess = true;
	    try {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(vehicleBean);
	        transaction.commit();
	        session.close();
	    } catch (Exception e) {
	        isSuccess = false;
	        e.printStackTrace();
	    }
	    return isSuccess;
	}

	public String addDriver(DriverBean driverBean ) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(driverBean);
		transaction.commit();
		session.close();
		return "SUCCESS";
	}
	public String deleteDriver(int driverID){
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query q1=session.createQuery("delete from DriverBean where driverID=:driverID");
		q1.setParameter("driverID",driverID);
		q1.executeUpdate();
        transaction.commit();
        return "SUCCESS";
	}
	public boolean modifyDriver(DriverBean driverBean) {
	    boolean isSuccess = true;
	    try {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(driverBean);
	        transaction.commit();
	        session.close();
	    } catch (Exception e) {
	        isSuccess = false;
	        e.printStackTrace();
	    }
	    return isSuccess;
	}
	public String addRoute(RouteBean routeBean ) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(routeBean);
		transaction.commit();
		session.close();
		return "SUCCESS";
	}
	public String deleteRoute(int routeID){
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query q1=session.createQuery("delete from RouteBean where routeID=:routeID");
		q1.setParameter("routeID",routeID);
		q1.executeUpdate();
        transaction.commit();
        return "SUCCESS";
	}
	public boolean modifyRoute(RouteBean routeBean) {
	    boolean isSuccess = true;
	    try {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(routeBean);
	        transaction.commit();
	        session.close();
	    } catch (Exception e) {
	        isSuccess = false;
	        e.printStackTrace();
	    }
	    return isSuccess;
	}
	public RouteBean viewRouteById(int routeID) {
		
		RouteBean elBean=new RouteBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<RouteBean> q2=session.createQuery("from RouteBean where routeID=:routeID");
	q2.setParameter("routeID", routeID);
	ArrayList<RouteBean> all=(ArrayList<RouteBean>) q2.getResultList();
	for(RouteBean e1:all)
	{
		elBean=e1;
	}
	return elBean;
	}
	public List<ReservationBean> viewReservationByJourneyDetails(String journeyDate, String source, String destination) {
	    try (Session session = sessionFactory.openSession()) {
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<ReservationBean> criteriaQuery = builder.createQuery(ReservationBean.class);
	        Root<ReservationBean> root = criteriaQuery.from(ReservationBean.class);

	        Join<ReservationBean, RouteBean> join = root.join("routeBean", JoinType.INNER);
	        criteriaQuery.where(builder.and(
	            builder.equal(join.get("source"), source),
	            builder.equal(join.get("destination"), destination),
	            builder.equal(root.get("journeyDate"), journeyDate)
	        ));

	        List<ReservationBean> reservations = session.createQuery(criteriaQuery).getResultList();
	        return reservations;
	    }
	}

	public ArrayList<RouteBean> viewRoute()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from RouteBean");
		return (ArrayList<RouteBean>) q.list();
	}

	public ArrayList<VehicleBean> viewVehicle() 	
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from VehicleBean");
		return (ArrayList<VehicleBean>) q.list();
	}
	public ArrayList<DriverBean> viewDriver()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from DriverBean");
		return (ArrayList<DriverBean>) q.list();
	}
public DriverBean viewDriverById(int driverID) {
		
	DriverBean elBean=new DriverBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<DriverBean> q2=session.createQuery("from DriverBean where driverID=:driverID");
	q2.setParameter("driverID", driverID);
	ArrayList<DriverBean> all=(ArrayList<DriverBean>) q2.getResultList();
	for(DriverBean e1:all)
	{
		elBean=e1;
	}
	return elBean;
	}

public CredentialsBean viewcredentialsById(String userId) {
	
	CredentialsBean elBean=new CredentialsBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<CredentialsBean> q2=session.createQuery("from CredentialsBean where userId=:userId");
	q2.setParameter("userId", userId);
	ArrayList<CredentialsBean> all=(ArrayList<CredentialsBean>) q2.getResultList();
	for( CredentialsBean e1:all)
	{
		elBean=e1;
	}
	return elBean;
	}

public ArrayList<ReservationBean> getReservationByuserId(String userId) {
    System.out.println("Under DAO " + userId);
    CredentialsBean credentials = viewcredentialsById(userId);
    if (credentials != null) {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query<ReservationBean> query = session.createQuery("FROM ReservationBean WHERE credentialsBean.userId = :userId");
            query.setParameter("userId", userId);
            ArrayList<ReservationBean> reservations = (ArrayList<ReservationBean>) query.getResultList();
            transaction.commit();
            return reservations;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    return null;
}























public ArrayList<ReservationBean> viewReservations()
{
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	q=session.createQuery("from ReservationBean");
	return (ArrayList<ReservationBean>) q.list();
}
public ArrayList<ProfileBean> viewProfile()
{
    session=sessionFactory.openSession();
    transaction=session.beginTransaction();
    q=session.createQuery("from ProfileBean");
    return (ArrayList<ProfileBean>) q.list();
}
public String addProfile(ProfileBean profileBean ) {
    session=sessionFactory.openSession();
    transaction=session.beginTransaction();
    session.save(profileBean);
    transaction.commit();
    session.close();
    return "SUCCESS";
}
public boolean authenticate(CredentialsBean user) 
{
    System.out.println("Under Dao "+user.getUserId()+" "+user.getPassword());
    session=sessionFactory.openSession();
    transaction=session.beginTransaction();
    Query q3=session.createQuery("from CredentialsBean where userId=:uid and password=:pss");
    q3.setParameter("uid", user.getUserId());
    q3.setParameter("pss", user.getPassword());
    ArrayList<CredentialsBean> al=(ArrayList<CredentialsBean>) q3.getResultList();
    int count=0;
    for(CredentialsBean cb:al)
    {
        if((cb.getUserId().equals(user.getUserId()))&&(cb.getPassword().equals(user.getPassword())))
        {
            System.out.println("Record is  present"+cb.getUserId()+" "+cb.getPassword());
            count++;
            if(count>0)
            {
    return true;
            }
            else
            {
                return false;
            }
        }
    }
    return false;
    
}



}
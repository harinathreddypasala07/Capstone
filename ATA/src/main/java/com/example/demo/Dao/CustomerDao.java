package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import com.example.demo.Bean.CredentialsBean;
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
public class CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query q;
	
	public String bookVehicle(ReservationBean reservationBean ) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(reservationBean);
		transaction.commit();
		session.close();
		return "Booking SUCCESS";
	}
	public ReservationBean viewResevationById(int reservationID) {
		
		 ReservationBean elBean=new ReservationBean();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
		Query<ReservationBean> q2=session.createQuery("from ReservationBean where reservationID=:reservationID");
		q2.setParameter("reservationID", reservationID);
		ArrayList<ReservationBean> all=(ArrayList<ReservationBean>) q2.getResultList();
		for(ReservationBean e1:all)
		{
			elBean=e1;
		}
		return elBean;
		}
	  

	public List<VehicleBean> viewVehicleByType(String type) {
	    try (Session session = sessionFactory.openSession()) {
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<VehicleBean> criteriaQuery = builder.createQuery(VehicleBean.class);
	        Root<VehicleBean> root = criteriaQuery.from(VehicleBean.class);

	        criteriaQuery.where(builder.equal(root.get("type"), type));

	        List<VehicleBean> vehicles = session.createQuery(criteriaQuery).getResultList();
	        return vehicles;
	    }
	}
	public List<VehicleBean> viewVehicleBySeatingCapacity(String seatingapacity) {
	    try (Session session = sessionFactory.openSession()) {
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<VehicleBean> criteriaQuery = builder.createQuery(VehicleBean.class);
	        Root<VehicleBean> root = criteriaQuery.from(VehicleBean.class);

	        criteriaQuery.where(builder.equal(root.get("seatingapacity"), seatingapacity));

	        List<VehicleBean> vehicles = session.createQuery(criteriaQuery).getResultList();
	        return vehicles;
	    }
	}
	   
	public ArrayList<RouteBean> viewRoute()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from RouteBean");
		return (ArrayList<RouteBean>) q.list();
	}
	
	public ProfileBean getCustomerById(int userID) {
		
		ProfileBean elBean=new ProfileBean();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
		Query<ProfileBean> q2=session.createQuery("from ProfileBean where userID=:userID");
		q2.setParameter("userID", userID);
		ArrayList<ProfileBean> all=(ArrayList<ProfileBean>) q2.getResultList();
		for(ProfileBean e1:all)
		{
			elBean=e1;
		}
		return elBean;
		}
	
	public CredentialsBean viewCredentialById(String userId) {
	    CredentialsBean elBean = null;
	    session = sessionFactory.openSession();
	    try {
	        transaction = session.beginTransaction();
	        Query<CredentialsBean> query = session.createQuery("FROM CredentialsBean WHERE userId = :userId");
	        query.setParameter("userId", userId);
	        elBean = query.uniqueResult();
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return elBean;
	}
	public ArrayList<ReservationBean> getReservationByuserId(String userId) {
	    System.out.println("Under DAO " + userId);
	    CredentialsBean credentials = viewCredentialById(userId);
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

	public String deleteReservation(int reservationID){
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query q1=session.createQuery("delete from ReservationBean where reservationID=:reservationID");
		q1.setParameter("reservationID",reservationID);
		q1.executeUpdate();
        transaction.commit();
        return "SUCCESS";
	}
	

}

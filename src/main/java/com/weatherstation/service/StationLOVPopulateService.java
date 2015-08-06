package com.weatherstation.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.weatherstation.model.Stations;
import com.weatherstation.util.HibernateUtil_Stations;

public class StationLOVPopulateService {
	

	public List<Stations> getListOfData(String Organization){
		 List<Stations> list = new ArrayList<Stations>();
		 Session session = HibernateUtil_Stations.openSession();
		 String query;
		 if (Organization.equalsIgnoreCase("SCD"))
		 {
			 query="from Stations";			 
		 }
		 else
		 {
			 query="from Stations WHERE Organization = "+ Organization;			 
		 }
		 Transaction tx = null;	

		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 list = session.createQuery(query).list();	
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return list;
	}

}

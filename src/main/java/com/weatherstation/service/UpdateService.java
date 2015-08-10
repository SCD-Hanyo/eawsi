package com.weatherstation.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.weatherstation.model.Data;
import com.weatherstation.util.HibernateUtil_Data;

public class UpdateService {
	
	
	public void AddNewRecord(Data data){

		Session session = HibernateUtil_Data.openSession();        
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(data);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
	}

}

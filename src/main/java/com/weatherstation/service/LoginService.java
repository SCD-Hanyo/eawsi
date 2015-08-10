package com.weatherstation.service;

import com.weatherstation.model.Users;
import com.weatherstation.util.HibernateUtil_Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginService {

	public boolean FindUser(String userName, String password) {
		 Users user = CheckDB(userName, password );		
		 if(user!=null ){
			 return true;
		 }else{
			 return false;
		 }
	}

	public Users CheckDB(String userName, String password) {
		Session session = HibernateUtil_Users.openSession();
		 Transaction tx = null;
		 Users user = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			
			 Query query = session.createQuery("from Users where UserName='" + userName+ "' AND Password='" + password + "'"); 
			 user = (Users)query.uniqueResult();
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return user;
	}
}

 package com.weatherstation.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


@SuppressWarnings("deprecation")
public class HibernateUtil_Data {
	private static final SessionFactory sessionFactory;

	static {
		 try {
			 sessionFactory = new AnnotationConfiguration().configure("hibernate.data.cfg.xml").buildSessionFactory();
		 } catch (Throwable ex) {
			 System.err.println("Initial SessionFactory creation failed." + ex);
			 throw new ExceptionInInitializerError(ex);
		 }
	}

	public static Session openSession() {
		 return sessionFactory.openSession();
	}
}

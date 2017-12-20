package com;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	static{
		sessionFactory = new Configuration().configure("myhibernate.cfg.xml").buildSessionFactory();
		 /*Configuration cfg = new Configuration();
		 cfg.addClass(foo.Category.class);
		 cfg.addClass(foo.Item.class);
		 sessionFactory = cfg.buildSessionFactory();*/
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void shutdown(){
		sessionFactory.close();
	}

}

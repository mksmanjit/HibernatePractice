package com;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		try{
			Properties prop = new Properties();
			prop.setProperty("hibernate.bytecode.use_reflection_optimizer", "false");
			prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			prop.setProperty("hibernate.connection.password","manjit");
			prop.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/Testing");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			prop.setProperty("hibernate.show_sql", "true");
			prop.setProperty("hibernate.hbm2ddl.auto", "create");
		Configuration cfg= new Configuration();
		//cfg.setProperty("hibernate.show_sql", "true");
		cfg.addClass(foo.HelloWorld.class);
		cfg.setProperties(prop);
		//cfg.setProperties(System.getProperties());
		//cfg.addResource("foo\\Hello.hbm.xml");
		//cfg.configure();
		return cfg.buildSessionFactory();
		}
		catch(Throwable ex){
			System.out.println("Initial SessionFactory creation failed."+ex);
			throw new ExceptionInInitializerError(ex);
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void shutDown(){
		getSessionFactory().close();
	}

}

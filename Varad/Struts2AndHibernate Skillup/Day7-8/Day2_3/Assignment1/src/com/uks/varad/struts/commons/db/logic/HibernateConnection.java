package com.uks.varad.struts.commons.db.logic;
/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*
 * Class HibernateConnection is used to connect to the database
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
public class HibernateConnection {
	Configuration configuration = new Configuration();
	SessionFactory factory;
	Session session1;
	public Session getHbmConnection()
	{
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
		session1 = factory.openSession();
		return session1;
	}
}
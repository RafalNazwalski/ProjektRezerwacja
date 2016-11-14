package repository;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseRepository {

	protected Transaction tx;
	
	
	private SessionFactory sessionFactory = new Configuration()
	        .configure("model/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
	        .buildSessionFactory();
	
	protected Session session;
	protected Query query;
	protected String command;
	
	protected void openConnection(){
		session  = sessionFactory.openSession();
	}
	
	protected void closeConnection(){
		session.close();
	}
}

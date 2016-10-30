package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseRepository {

	protected Transaction tx;
	
	
	private SessionFactory sessionFactory = new Configuration()
	        .configure("Database/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
	        .buildSessionFactory();
	
	private Session session;
	
	protected void openConnection(){
		session  = sessionFactory.openSession();
	}
	
	protected void closeConnection(){
		session.close();
	}
}
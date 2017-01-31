package repository;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.HistoriaRezerwacji;
import model.Pokoj;
import model.Uzytkownik;

public class BaseRepository {

	private static final SessionFactory sessionFactory;
	
	static {
		try {
			Properties prop = new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "root");
			prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
			
			sessionFactory = new Configuration()
				   .addProperties(prop)
				   .addAnnotatedClass(Uzytkownik.class)
				   .addAnnotatedClass(Pokoj.class)
				   .addAnnotatedClass(HistoriaRezerwacji.class)
				   .buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session openConnection() throws HibernateException{
		return sessionFactory.openSession();
	}
	
	public static void closeConnection(){
		sessionFactory.close();
	}
}

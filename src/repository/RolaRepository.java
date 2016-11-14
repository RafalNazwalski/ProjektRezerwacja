package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import model.Rola;
import model.Uzytkownik;

public class RolaRepository extends BaseRepository
{
	public void add(Rola rola){
		
	}
	
	public ArrayList<Rola> getAll(){
		
		openConnection();
		
		org.hibernate.Transaction t = session.beginTransaction();
		
//		Query query = session.createQuery("FROM Uzytkownik");
//		
//		List<Uzytkownik> list = query.list();
//		
		List<Uzytkownik> result = (List<Uzytkownik>) session.createQuery("from Uzytkownik").list();
		
		t.commit();
		closeConnection();
		
		return new ArrayList<Rola>();
	}
	
	public Rola getById(int Id){
		throw new NotYetImplementedException();
	}
	
	public void delete(int Id){
		
	}
	
	public void update(int Id){
		
	}
}

package repository;

import java.util.ArrayList;

import org.hibernate.cfg.NotYetImplementedException;

import model.Rola;

public class RolaRepository extends BaseRepository
{
	public void add(Rola rola){
		
	}
	
	public ArrayList<Rola> getAll(){
		
		openConnection();
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

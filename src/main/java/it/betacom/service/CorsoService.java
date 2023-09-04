package it.betacom.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import it.betacom.dao.CorsoDao;
import it.betacom.model.Corso;

public class CorsoService {

	CorsoDao corsoDao = new CorsoDao();
	private List<Corso> corsi = new ArrayList<>();

	public CorsoService() {
		super();
	}
	
	// i metodi vanno sostituiti con collegamento DB

	public List<Corso> findAll() {
		if (corsi.size() == 0) {
			corsi = corsoDao.getAll();
			for(Corso corso : corsi) {
				System.out.println(corso);
			}
		}
		return corsi;
	}
	
	public Corso fetch(long id) throws NotFoundException {
		Corso corso = corsoDao.getCorsoById(id);
		if (corso != null)
			return corso;
		throw new NotFoundException("Resource not found with id: " + id);
	}
	
	public boolean create(Corso corso) {
		corsoDao.save(corso);
		return true;
	}
	
	public boolean update(Corso corso) {
		corsoDao.update(corso);
		return true;
	}
	
	public boolean delete(long id){
		corsoDao.delete(fetch(id));
		return true;
	}
}

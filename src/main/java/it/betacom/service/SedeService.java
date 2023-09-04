package it.betacom.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import it.betacom.dao.SedeDao;
import it.betacom.model.Sede;

public class SedeService {

	SedeDao sedeDao = new SedeDao();
	private List<Sede> sedi = new ArrayList<>();

	public SedeService() {
		super();
	}
	
	// i metodi vanno sostituiti con collegamento DB

	public List<Sede> findAll() {
		if (sedi.size() == 0) {
			sedi = sedeDao.getAll();
			for(Sede sede : sedi) {
				System.out.println(sede);
			}
		}
		return sedi;
	}
	
	public Sede fetch(long id) throws NotFoundException {
		Sede sede = sedeDao.getSedeById(id);
		if (sede != null)
			return sede;
		throw new NotFoundException("Resource not found with id: " + id);
	}
	
	public boolean create(Sede sede) {
		sedeDao.save(sede);
		return true;
	}
	
	public boolean update(Sede sede) {
		sedeDao.update(sede);
		return true;
	}
	
	public boolean delete(long id){
		sedeDao.delete(fetch(id));
		return true;
	}
}

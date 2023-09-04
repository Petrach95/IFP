package it.betacom.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import it.betacom.dao.DocenteDao;
import it.betacom.model.Docente;

public class DocenteService {

	DocenteDao docenteDao = new DocenteDao();
	private List<Docente> docenti = new ArrayList<>();

	public DocenteService() {
		super();
	}
	
	// i metodi vanno sostituiti con collegamento DB

	public List<Docente> findAll() {
		if (docenti.size() == 0) {
			docenti = docenteDao.getAll();
			for(Docente docente : docenti) {
				System.out.println(docente);
			}
		}
		return docenti;
	}
	
	public Docente fetch(long id) throws NotFoundException {
		Docente docente = docenteDao.getDocenteById(id);
		if (docente != null)
			return docente;
		throw new NotFoundException("Resource not found with id: " + id);
	}
	
	public boolean create(Docente docente) {
		docenteDao.save(docente);
		return true;
	}
	
	public boolean update(Docente docente) {
		docenteDao.update(docente);
		return true;
	}
	
	public boolean delete(long id){
		docenteDao.delete(fetch(id));
		return true;
	}
}

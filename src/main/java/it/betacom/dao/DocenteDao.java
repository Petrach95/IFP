package it.betacom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import it.betacom.model.Docente;

public class DocenteDao {

Session s = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	
	@SuppressWarnings("unchecked")
	public List<Docente> getAll(){
		return (List<Docente>) s.createQuery("from Docente").list();
	}
	
	public Docente getDocenteById(long id) {
		return s.load(Docente.class, id);
	}
	public void save(Docente docente) {
        s.beginTransaction();
        s.save(docente);
        s.getTransaction().commit();
	}
	
	public void update(Docente docente) {
		s.beginTransaction();
		s.update(docente);
		s.getTransaction().commit();
	}
	
	public void delete(Docente docente) {
		s.beginTransaction();
		s.delete(docente);
		s.getTransaction().commit();
	}
}

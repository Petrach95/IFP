package it.betacom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import it.betacom.model.Corso;

public class CorsoDao {

Session s = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	
	@SuppressWarnings("unchecked")
	public List<Corso> getAll(){
		return (List<Corso>) s.createQuery("from Corso").list();
	}
	
	public Corso getCorsoById(long id) {
		return s.load(Corso.class, id);
	}
	public void save(Corso corso) {
        s.beginTransaction();
        s.save(corso);
        s.getTransaction().commit();
	}
	
	public void update(Corso corso) {
		s.beginTransaction();
		s.update(corso);
		s.getTransaction().commit();
	}
	
	public void delete(Corso corso) {
		s.beginTransaction();
		s.delete(corso);
		s.getTransaction().commit();
	}
}

package it.betacom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import it.betacom.model.Sede;

public class SedeDao {

	Session s = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	
	@SuppressWarnings("unchecked")
	public List<Sede> getAll(){
		return (List<Sede>) s.createQuery("from Sede").list();
	}
	
	public Sede getSedeById(long id) {
		return s.load(Sede.class, id);
	}
	public void save(Sede sede) {
        s.beginTransaction();
        s.save(sede);
        s.getTransaction().commit();
	}
	
	public void update(Sede sede) {
		s.beginTransaction();
		s.update(sede);
		s.getTransaction().commit();
	}
	
	public void delete(Sede sede) {
		s.beginTransaction();
		s.delete(sede);
		s.getTransaction().commit();
	}
}

package it.betacom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "corso")
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int durata;
	@ManyToOne
	@JoinColumn(name="id_docente", referencedColumnName="id")
	private Docente docente;
	
	public Corso() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Corso(int id, String nome, int durata) {
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.durata = durata;
//		
//	}
	public Corso(int id, String nome, int durata, Docente docente) {
		super();
		this.id = id;
		this.nome = nome;
		this.durata = durata;
		this.docente = docente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
}

package it.betacom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "docente")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	private String telefono;
	private String titoloStudio;
//	@OneToMany(mappedBy="corso")
//	private List<Corso> corsi;

	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Docente(Long id, String nome, String cognome, String telefono, String titoloStudio) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.titoloStudio = titoloStudio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTitoloStudio() {
		return titoloStudio;
	}

	public void setTitoloStudio(String titoloStudio) {
		this.titoloStudio = titoloStudio;
	}
//	public List<Corso> getCorsi() {
//		return corsi;
//	}
//	public void setCorsi(List<Corso> corsi) {
//		this.corsi = corsi;
//	}

}

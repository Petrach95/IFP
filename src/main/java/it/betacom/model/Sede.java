package it.betacom.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sede")
public class Sede {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String citta;
	private String indirizzo;
	private String telefono;
	
	public Sede() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sede(Long id, String citta, String indirizzo, String telefono) {
		super();
		this.id = id;
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return citta + ": " + indirizzo + " tel. " + telefono;
	}
	
}

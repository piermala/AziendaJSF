package it.alfasoft.pierangelo.model.bean;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;

@ManagedBean(name="dipendente",eager=true)
@Entity
public class Dipendente extends Utente {

	private static final long serialVersionUID = 1L;
	
	
	protected String posizione;
	protected double stipendio;
	
	
	
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	
	
	
	
	public Dipendente(){
		this.ruolo = 'C';
	}
	
	
	public Dipendente(String nome, String cognome, String username,
			String password, char ruolo, String posizione, double stipendio) {
		super(nome, cognome, username, password, ruolo);
		this.posizione = posizione;
		this.stipendio = stipendio;
	}
	
}

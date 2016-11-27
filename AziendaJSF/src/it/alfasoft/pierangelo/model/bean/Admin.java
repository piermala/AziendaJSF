package it.alfasoft.pierangelo.model.bean;


import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;

@ManagedBean(name="admin",eager=true)
@Entity
public class Admin extends Utente {

	private static final long serialVersionUID = 1L;
	
	private String livelloAccesso;	
	
	
	public long getIdUtente() {
		return idUtente;
	}




	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}




	public String getLivelloAccesso() {
		return livelloAccesso;
	}




	public void setLivelloAccesso(String livelloAccesso) {
		this.livelloAccesso = livelloAccesso;
	}




	public Admin(){
		this.ruolo = 'C';
	}




	public Admin(String nome, String cognome, String username, String password,
			char ruolo, String livelloAccesso) {
		super(nome, cognome, username, password, ruolo);
		this.livelloAccesso = livelloAccesso;
	}
	
}

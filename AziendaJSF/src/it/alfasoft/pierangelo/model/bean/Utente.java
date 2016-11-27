package it.alfasoft.pierangelo.model.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@ManagedBean(name="utente",eager=true)
@Inheritance(strategy=InheritanceType.JOINED)
@Entity
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long idUtente;
	
	protected String nome;
	protected String cognome;
	protected String username;
	protected String password;
	protected char ruolo;	
	
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getRuolo() {
		return ruolo;
	}
	public void setRuolo(char ruolo) {
		this.ruolo = ruolo;
	}
	
	
	public Utente(String nome, String cognome, String username,
			String password, char ruolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}
	
	public Utente(){
		this.ruolo = 'C';
	}
	
}

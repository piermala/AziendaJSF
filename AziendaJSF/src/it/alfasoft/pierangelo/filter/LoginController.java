package it.alfasoft.pierangelo.filter;

import it.alfasoft.pierangelo.model.bean.Utente;
import it.alfasoft.pierangelo.servizi.ServiziUtente;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="loginController",eager=true)
@SessionScoped
public class LoginController {

	private String username;
	private String password;
	private boolean loggato;
	private ServiziUtente servUtente;
	
	
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
	public boolean isLoggato() {
		return loggato;
	}
	public void setLoggato(boolean loggato) {
		this.loggato = loggato;
	}
	
	
	
	/// DO LOGIN
	public String doLogin(){
		
		servUtente = new ServiziUtente();
		
		Utente u = servUtente.cercaConUsername(username);
		
		
		if (u != null){
			
			if (u.getPassword().equals(password)){
				
				char ruolo = u.getRuolo();
				
				switch(ruolo){
				
					case 'A':
						return "/Admin/HomepageAdmin.xhtml";
					case 'C':
						return "/Cliente/HomepageCliente.xhtml";
					case 'D':
						return "/Dipendente/HomepageDipendente.xhtml";				
				}
			}
			
		}
		
		this.loggato = true;
		
		return "login.xhtml";
		
	}
	
	
	
	
	
	
}

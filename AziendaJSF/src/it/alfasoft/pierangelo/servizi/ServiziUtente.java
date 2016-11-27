package it.alfasoft.pierangelo.servizi;

import it.alfasoft.pierangelo.dao.UtenteDao;
import it.alfasoft.pierangelo.model.bean.Utente;

public class ServiziUtente {

	private UtenteDao uDao = new UtenteDao();
	
	
	/// CREA UTENTE
	public void creaUtente(String nome, String cognome, String username, String password, char ruolo){
		uDao.createUtente(nome, cognome, username, password, ruolo);
	}
	
	
	
	/// CERCA CON USERNAME
	public Utente cercaConUsername(String username) {

		Utente u = null;
		u = uDao.cercaConUsername(username);

		return u;
	}

	// / CERCA UTENTE CON ID
	public Utente cercaUtenteConId(long id) {

		Utente u = null;
		u = uDao.trovaUtenteConId(id);

		return u;
	}
	

	// / ELIMINA UTENTE DA ID
	public void eliminaUtenteById(long id) {

		Utente u = uDao.trovaUtenteConId(id);

		uDao.eliminaUtente(u);
	}

}

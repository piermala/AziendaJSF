package it.alfasoft.pierangelo.servizi;

import java.util.List;



import it.alfasoft.pierangelo.dao.DipendenteDao;
import it.alfasoft.pierangelo.model.bean.Dipendente;

public class ServiziDipendente {
	

	DipendenteDao dDao = new DipendenteDao();	
	
	
	// / AGGIUNGI DIPENDENTE
	public Dipendente createDipendente(String nome, String cognome,
			String username, String password, String posizione, double stipendio) {
		
		Dipendente dipendente = dDao.createDipendente(nome, cognome, username,
				password, posizione, stipendio);

		return dipendente;

	}

	// / CERCA CON USERNAME
	public Dipendente trovaDipendenteConUsername(String username) {

		Dipendente dipendente = null;
		dipendente = dDao.trovaDipendenteConUsername(username);

		return dipendente;

	}

	// / GET DIPENDENTE DA ID
	public Dipendente getDipendenteConId(long id) {

		Dipendente dipendente = null;
		dipendente = dDao.getDipendenteDaId(id);

		return dipendente;
		
	}

	
	/// TUTTI I DIPENDENTI
	public List<Dipendente> getTuttiDipendenti() {
		
		List<Dipendente> dipendenti = null;
		dipendenti = dDao.leggiTuttiDipendenti();

		return dipendenti;
		
	}
	

	/// MODIFICA DIPENDENTE
	public void modificaDipendente(Dipendente d) {
		
		dDao.modificaDipendente(d);
		
	}

	
	/// ELIMINA DIPENDENTE
	public void eliminaDipendente(Dipendente d) {
		
		dDao.eliminaDipendente(d);
		
	}
	
	
}

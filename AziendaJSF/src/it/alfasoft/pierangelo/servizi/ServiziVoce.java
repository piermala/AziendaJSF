package it.alfasoft.pierangelo.servizi;

import it.alfasoft.pierangelo.dao.VoceDao;
import it.alfasoft.pierangelo.model.rubrica.Rubrica;
import it.alfasoft.pierangelo.model.rubrica.Voce;

import java.util.List;


public class ServiziVoce {

	private VoceDao vDao = new VoceDao();
	
	
	
	/// AGGIUNGI VOCE
	public Voce aggiungiVoce(String nome, String cognome, String telefono,
			Rubrica rubrica) {
		Voce v = null;
		v = vDao.aggiungiVoce(nome, cognome, telefono, rubrica);

		return v;
	}

	// / CERCA VOCE
	public Voce cercaVoce(long id) {
		Voce v = null;
		v = vDao.cercaVoce(id);

		return v;
	}

	// / CERCA TELEFONO
	public Voce cercaTelefono(String telefono) {
		Voce v = null;
		v = vDao.cercaTelefono(telefono);

		return v;
	}

	// / LEGGI TUTTE LE VOCI
	public List<Voce> getTutteLeVoci(long id) {

		List<Voce> voci = null;
		voci = vDao.getTutteLeVoci(id);

		return voci;
	}

	// / MODIFICA VOCE
	public boolean modificaVoce(Voce v) {
		boolean modificato = false;
		modificato = vDao.modificaVoce(v);

		return modificato;
	}

	// / ELIMINA VOCE
	public void eliminaVoce(Voce v) {
		vDao.eliminaVoce(v);
	}
	
	
}

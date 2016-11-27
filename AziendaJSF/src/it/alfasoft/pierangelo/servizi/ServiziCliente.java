package it.alfasoft.pierangelo.servizi;

import java.util.List;

import it.alfasoft.pierangelo.dao.ClienteDao;
import it.alfasoft.pierangelo.model.bean.Cliente;

public class ServiziCliente {

	private ClienteDao cDao = new ClienteDao();
	
	
	/// AGGIUNGI CLIENTE
	public Cliente createCliente(String nome, String cognome, String username,
			String password, String partitaIVA, String ragioneSociale) {
		
		Cliente cliente = cDao.createCliente(nome, cognome, username, password,
				partitaIVA, ragioneSociale);

		return cliente;
		
	}

	
	/// CERCA CON USERNAME
	public Cliente trovaClienteConUsername(String username) {

		Cliente cliente = null;
		cliente = cDao.trovaClienteConUsername(username);

		return cliente;

	}
	
	
	/// CERCA CON USERNAME
	public Cliente trovaClienteConId(long id) {

		Cliente cliente = null;
		cliente = cDao.trovaClienteConId(id);

		return cliente;

	}
	

	/// TUTTI I CLIENTI
	public List<Cliente> getTuttiClienti() {

		List<Cliente> clienti = null;
		clienti = cDao.leggiTuttiClienti();

		return clienti;

	}

	// / MODIFICA DIPENDENTE
	public void modificaCliente(Cliente c) {
		cDao.modificaCliente(c);
	}

	// / ELIMINA DIPENDENTE
	public void eliminaCliente(Cliente c) {
		cDao.eliminaDipendente(c);
	}
	
	
}

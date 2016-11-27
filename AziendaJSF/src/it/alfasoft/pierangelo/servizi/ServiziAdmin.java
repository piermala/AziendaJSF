package it.alfasoft.pierangelo.servizi;

import it.alfasoft.pierangelo.dao.AdminDao;
import it.alfasoft.pierangelo.model.bean.Admin;


public class ServiziAdmin {
	
	
	private AdminDao aDao = new AdminDao();

	/// AGGIUNGI ADMIN
	public Admin createAdmin(String nome, String cognome, String username,
			String password, String livelloAccesso) {
		
		Admin admin = aDao.createAdmin(nome, cognome, username, password,
				livelloAccesso);

		return admin;
	}

	
	
	/// CERCA CON USERNAME
	public Admin trovaAdminConUsername(String username) {

		Admin admin = null;
		admin = aDao.trovaAdminConUsername(username);

		return admin;
	}
			
	
	
	
}

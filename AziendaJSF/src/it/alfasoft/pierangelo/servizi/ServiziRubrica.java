package it.alfasoft.pierangelo.servizi;

import it.alfasoft.pierangelo.dao.RubricaDao;
import it.alfasoft.pierangelo.model.rubrica.Rubrica;


public class ServiziRubrica {
	
	
	private RubricaDao rDao = new RubricaDao();
	

	/// AGGIUNGI RUBRICA
		public Rubrica aggiungiRubrica(String name){
			Rubrica r = null;
			r = rDao.aggiungiRubrica(name);
			
			return r;
		}
		
		
		/// CERCA RUBRICA
		public Rubrica cercaRubrica(long id){
			Rubrica r = null;
			r = rDao.cercaRubrica(id);
				
			return r;
		}
		
		
		/// LEGGI ID RUBRICA
		public long leggiID(String username){
			
			long id = -1;
			id = rDao.leggiIdRubrica(username);
			
			return id;		
		}
		
		
		/// ELIMINA RUBRICA
		public void eliminaRubrica(Rubrica r){
			rDao.eliminaRubrica(r);
		}
		
}

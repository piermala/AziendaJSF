package it.alfasoft.pierangelo.servizi;

import java.util.ArrayList;
import java.util.List;



import it.alfasoft.pierangelo.dao.BustaDao;
import it.alfasoft.pierangelo.model.bean.BustaPaga;

public class ServiziBustaPaga {

	BustaDao bDao = new BustaDao();
	
	
	// / CREA BUSTA PAGA
	public void creaBustaPaga(BustaPaga bp) {
		bDao.aggiungiBustaPaga(bp);
	}

	// / LEGGI BUSTA PAGA DA ID
	public BustaPaga leggiBustaPagaDaId(long id) {
		BustaPaga bp = null;
		bp = bDao.getBustaPaga(id);

		return bp;
	}

	// / LEGGI TUTTE LE BUSTE PAGA
	public List<BustaPaga> leggiTutteBustePaga() {

		List<BustaPaga> bustePaga = new ArrayList<BustaPaga>();
		bustePaga = bDao.getBustePaga();

		return bustePaga;
	}

	// / LEGGI TUTTE LE BUSTE PAGA
	public List<BustaPaga> leggiBustePagaDaId(long id) {

		List<BustaPaga> bustePaga = new ArrayList<BustaPaga>();
		bustePaga = bDao.getBustePagaDaId(id);

		return bustePaga;

	}

	// / MODIFICA BUSTA PAGA
	public void modificaBustaPaga(BustaPaga bPaga) {
		bDao.modificaBustaPaga(bPaga);
	}

	// / ELIMINA BUSTA PAGA
	public void eliminaBustaPaga(BustaPaga bPaga) {
		bDao.eliminaBustaPaga(bPaga);
	}		

}

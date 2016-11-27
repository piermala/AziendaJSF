package prova;

import it.alfasoft.pierangelo.controller.ClienteController;
import it.alfasoft.pierangelo.controller.DipendenteController;
import it.alfasoft.pierangelo.editview.EditViewCliente;
import it.alfasoft.pierangelo.model.bean.Cliente;
import it.alfasoft.pierangelo.model.bean.Dipendente;

public class mainProva {

	public static void main(String[] args) {
	
		
//		ClienteController cc = new ClienteController();
//		cc.init();
//		
//		Cliente c2 = new Cliente();
//		c2.setNome("ccc");
//		c2.setCognome("ddd");
//		c2.setRagioneSociale("agri");
//		c2.setpartitaIVA("jkjk");
//		c2.setUsername("ccdd");
//		c2.setPassword("ccc");
//		
//		cc.addCliente(c2);
		
		
		DipendenteController dc = new DipendenteController();
		dc.init();
		
		Dipendente d1 = new Dipendente();
		d1.setNome("andrea");
		d1.setCognome("laneri");
		d1.setUsername("and");
		d1.setPassword("rea");
		d1.setStipendio(2000);
		d1.setPosizione("Manager");
		dc.addDipendente(d1);
	}
	
}

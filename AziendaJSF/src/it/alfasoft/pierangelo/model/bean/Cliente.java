package it.alfasoft.pierangelo.model.bean;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@ManagedBean(name="cliente",eager=true)
public class Cliente extends Utente {

	
	private static final long serialVersionUID = 1L;
	
	private String ragioneSociale;
	private String partitaIVA;
	
	public Cliente() {}
	
	public Cliente(String nome, String cognome,
			String username, String password, char ruolo,String ragioneSociale, String partitaIVA) {
		super(nome,cognome,username,password,ruolo);
		this.ragioneSociale = ragioneSociale;
		this.partitaIVA = partitaIVA;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getpartitaIVA() {
		return partitaIVA;
	}

	public void setpartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	@Override
//	public boolean isValid() {
//
//		boolean result=false;
//		
//		if(!nome.isEmpty() && nome!=null && 
//				!cognome.isEmpty() && cognome!=null &&
//				!username.isEmpty() && username!=null &&
//				!password.isEmpty() && password!=null &&
//				ruolo=='C' &&
//				!ragioneSociale.isEmpty() && ragioneSociale!=null &&
//				!pIVA.isEmpty() && pIVA!=null) {
//			result=true;
//		}
//		
//		return result;
//	}
//	
}


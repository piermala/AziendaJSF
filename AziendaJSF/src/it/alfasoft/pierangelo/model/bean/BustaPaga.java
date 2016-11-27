package it.alfasoft.pierangelo.model.bean;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@ManagedBean(name="bustapaga", eager=true)
public class BustaPaga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_BustaPaga;
	
	@ManyToOne
	private Dipendente dipendente;
	
	private Date data;
	private long importo;
	
	public BustaPaga() {
	}

	public long getId_BustaPaga() {
		return id_BustaPaga;
	}

	public void setId_BustaPaga(long id_BustaPaga) {
		this.id_BustaPaga = id_BustaPaga;
	}
	
	public Dipendente getDipendente() {
		return dipendente;
	}
	
	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public long getImporto() {
		return importo;
	}

	public void setImporto(long importo) {
		this.importo = importo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
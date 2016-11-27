package it.alfasoft.pierangelo.controller;

import it.alfasoft.pierangelo.model.bean.Dipendente;
import it.alfasoft.pierangelo.servizi.ServiziDipendente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean(name="controllerDipendente",eager=true)
@SessionScoped
public class DipendenteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Dipendente> listaDipendenti;
	private ServiziDipendente servDipendente;
	
	
	//// GETTERS AND SETTERS
	public List<Dipendente> getListaDipendenti() {
		return listaDipendenti;
	}

	public void setListaDipendenti(List<Dipendente> listaDipendenti) {
		this.listaDipendenti = listaDipendenti;
	}
	
	
	//// COSTRUTTORI
	public DipendenteController(){
		
	}

	public DipendenteController(List<Dipendente> listaDipendenti) {
		super();
		this.listaDipendenti = listaDipendenti;
	}
	
	@PostConstruct
    public void init() {
		listaDipendenti = new ArrayList<Dipendente>();
		servDipendente = new ServiziDipendente();	
	}
	
	
	
	
	/// AGGIUNGI CLIENTE
	public String addDipendente(Dipendente dipendente){		
			
		servDipendente.createDipendente(dipendente.getNome(), dipendente.getCognome(), dipendente.getUsername(), dipendente.getPassword(), dipendente.getPosizione(), dipendente.getStipendio());	/// aggiungi nel database
		aggiornaDipendenti();
		return "HomepageAdmin?faces-redirect=true";
		
	}	
	

	///  MODIFICA CLIENTE
	public String editDipendente(String username) {

		Dipendente cliente = servDipendente.trovaDipendenteConUsername(username);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Map<String,Object> requestMap= context.getRequestMap();
		requestMap.put("c", cliente);
		
		return "modificaCliente";
		
	}
	
	
	///  ELIMINA CLIENTE
	public String deleteDipendente(Dipendente dipendente) {

		servDipendente.eliminaDipendente(dipendente);
		aggiornaDipendenti();

		return "HomepageAdmin?faces-redirect=true";

	}
	
	
	
	
	/// AGGIORNA LISTA CLIENTI
	public void aggiornaDipendenti(){
		setListaDipendenti(servDipendente.getTuttiDipendenti());
	}
	


	
	
	
	
	
}

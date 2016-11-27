package it.alfasoft.pierangelo.controller;

import it.alfasoft.pierangelo.model.bean.Cliente;
import it.alfasoft.pierangelo.servizi.ServiziCliente;
import it.alfasoft.pierangelo.servizi.ServiziUtente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;




@ManagedBean(name="controllerCliente",eager=true)
@SessionScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Cliente> listaClienti;
	private ServiziCliente servCliente;
	
	
	//// GETTERS AND SETTERS
	public List<Cliente> getListaClienti() {
		return listaClienti;
	}

	public void setListaClienti(List<Cliente> listaClienti) {
		this.listaClienti = listaClienti;
	}
	
	
	//// COSTRUTTORI
	public ClienteController(){
		
	}

	public ClienteController(List<Cliente> listaClienti) {
		super();
		this.listaClienti = listaClienti;
	}
	
	@PostConstruct
    public void init() {
		listaClienti = new ArrayList<Cliente>();
		servCliente = new ServiziCliente();	
	}
	
	
	
	
	/// AGGIUNGI CLIENTE
	public String addCliente(Cliente cliente){		
			
		servCliente.createCliente(cliente.getNome(), cliente.getCognome(), cliente.getUsername(), cliente.getPassword(), cliente.getpartitaIVA(), cliente.getRagioneSociale());	/// aggiungi nel database
		aggiornaClienti();
		return "HomepageAdmin?faces-redirect=true";
		
	}	
	

	///  MODIFICA CLIENTE
	public String editCliente(String username) {

		Cliente cliente = servCliente.trovaClienteConUsername(username);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Map<String,Object> requestMap= context.getRequestMap();
		requestMap.put("c", cliente);
		
		return "modificaCliente";
		
	}
	
	
	///  ELIMINA CLIENTE
	public String deleteCliente(Cliente cliente) {

		servCliente.eliminaCliente(cliente);
		aggiornaClienti();

		return "HomepageAdmin?faces-redirect=true";

	}
	
	
	
	
	/// AGGIORNA LISTA CLIENTI
	public void aggiornaClienti(){
		setListaClienti(servCliente.getTuttiClienti());
	}
	

	
}

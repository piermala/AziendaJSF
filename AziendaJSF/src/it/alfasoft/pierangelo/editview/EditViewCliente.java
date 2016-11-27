package it.alfasoft.pierangelo.editview;

import it.alfasoft.pierangelo.controller.ClienteController;
import it.alfasoft.pierangelo.model.bean.Cliente;
import it.alfasoft.pierangelo.servizi.ServiziCliente;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name="clEditView")
@SessionScoped
public class EditViewCliente implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private ServiziCliente servCliente;	
	private List<Cliente> listaClienti;	
	
	@ManagedProperty("#{controllerCliente}")
    private ClienteController controller;
	
	
	
	/// GETTERS AND SETTERS
	public List<Cliente> getListaClienti() {
		return listaClienti;
	}
	public void setListaClienti(List<Cliente> listaClienti) {
		this.listaClienti = listaClienti;
	}
	public ServiziCliente getServCliente() {
		return servCliente;
	}
	public void setServCliente(ServiziCliente servCliente) {
		this.servCliente = servCliente;
	}	
	public ClienteController getController() {
		return controller;
	}
	public void setController(ClienteController controller) {
		this.controller = controller;
	}
	
	
	
	/// COSTRUTTORI
	
	public EditViewCliente(){
		super();
	}
	
	
	@PostConstruct
	public void init(){
		
		servCliente = new ServiziCliente();
		listaClienti = servCliente.getTuttiClienti();
		
	}
	
	
	
	
	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cliente modificato", ((Cliente) event.getObject()).getUsername());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        servCliente.modificaCliente((Cliente) event.getObject());
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cliente eliminato", ((Cliente) event.getObject()).getUsername());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proprietà cambiata", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    
    public String delete(Cliente cliente){
    	controller.deleteCliente(cliente);
    	return "HomepageAdmin";
    }
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
}

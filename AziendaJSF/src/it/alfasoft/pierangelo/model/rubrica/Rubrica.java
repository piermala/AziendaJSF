package it.alfasoft.pierangelo.model.rubrica;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Rubrica {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_rubrica;
	private String nome;
	
	@OneToMany(mappedBy="rubrica",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<Voce> voci = new ArrayList<>();
	
	
	/// GETTERS AND SETTERS
	public long getId_rubrica() {
		return id_rubrica;
	}
	public void setId_rubrica(long id) {
		this.id_rubrica = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Voce> getVoci() {
		return voci;
	}
	public void setVoci(List<Voce> voci) {
		this.voci = voci;
	}
	
	/// CONSTRUCTORS
	public Rubrica(int id_rubrica, String nome, List<Voce> voci) {
		super();
		this.id_rubrica = id_rubrica;
		this.nome = nome;
		this.voci = voci;
	}
	
	public Rubrica(){
		
	}
}


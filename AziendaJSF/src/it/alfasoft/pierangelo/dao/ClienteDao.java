package it.alfasoft.pierangelo.dao;

import it.alfasoft.pierangelo.model.bean.Cliente;

import java.util.ArrayList;
import java.util.List;

import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {

	
	/// AGGIUNGI
	public Cliente createCliente(String nome, String cognome, String username, String password, String partitaIVA, String ragioneSociale){
		
		Cliente cliente = null;
			
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
			
			cliente = new Cliente(nome, cognome, username, password, 'C', ragioneSociale, partitaIVA);
			session.persist(cliente);
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
			
		return cliente;	
	}
		
	
	
	/// CERCA CON ID
	public Cliente trovaClienteConId(long id) {

		Cliente cliente = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from Utente where idUtente=:id");
			query.setLong("id", id);

			cliente = (Cliente) query.uniqueResult();

			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return cliente;
	}
	
	
	/// CERCA CON ID
	public Cliente trovaClienteConUsername(String username) {

		Cliente cliente = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session.createQuery("from Utente where username=:username");
			query.setString("username", username);

			cliente = (Cliente) query.uniqueResult();

			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return cliente;
	}
	
	
	
	/// TUTTI I CLIENTI
	public List<Cliente> leggiTuttiClienti() {
		
		List<Cliente> clienti = new ArrayList<Cliente>();
			
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query=session.createQuery("from Cliente");
				
			clienti = (List<Cliente>)query.list();
				
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return clienti;			
	}
	
	
	
	
	/// MODIFICA CLIENTE
	public void modificaCliente(Cliente c) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.update(c);

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	
	
	// ELIMINA CLIENTE
	public void eliminaDipendente(Cliente c) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.delete(c);

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
}

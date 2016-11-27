package it.alfasoft.pierangelo.dao;

import it.alfasoft.pierangelo.model.bean.Utente;
import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UtenteDao {

	
	/// AGGIUNGI
	public Utente createUtente(String nome, String cognome, String username, String password, char ruolo)
	{
		Utente utente = null;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		utente = new Utente(nome, cognome, username, password, ruolo);
		session.persist(utente);
		
		tx.commit();
		
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return utente;	
	}
	
	
	
	/// CERCA CON ID
	public Utente trovaUtenteConId(long id) {
		
		Utente u = null;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
		
			Query query=session.createQuery("from Utente where idUtente=:id");
			query.setLong("id", id);
			
			u =(Utente)query.uniqueResult();
			
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return u;
		
	}
	
	
	
	/// CERCA CON USERNAME 
	public Utente cercaConUsername(String username) {
		
		Utente u = null;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
		
			Query query=session.createQuery("from Utente where username=:username");
			query.setString("username", username);
			
			u =(Utente)query.uniqueResult();
	
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return u;		
	}
	
	
	
	/// ELIMINA UTENTE
	public void eliminaUtente(Utente u) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.delete(u);
			
			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
}

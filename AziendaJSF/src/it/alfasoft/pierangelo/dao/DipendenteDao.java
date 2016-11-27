package it.alfasoft.pierangelo.dao;

import it.alfasoft.pierangelo.model.bean.Dipendente;

import java.util.ArrayList;
import java.util.List;

import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DipendenteDao {
	

	/// AGGIUNGI
	public Dipendente createDipendente(String nome, String cognome, String username, String password, String posizione, double stipendio){
		
		Dipendente dipendente = null;
			
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
			
			dipendente = new Dipendente(nome, cognome, username, password, 'D', posizione, stipendio);
			session.persist(dipendente);
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
			
		return dipendente;	
	}
		
		
		
	/// CERCA CON USERNAME
	public Dipendente trovaDipendenteConUsername(String username) {
			
		Dipendente dipendente = null;
			
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query=session.createQuery("from Dipendente where username=:username");
			query.setString("username", username);
				
			dipendente = (Dipendente)query.uniqueResult();
		
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return dipendente;			
	}
	
	
	/// CERCA DIPENDENTE DA ID
	public Dipendente getDipendenteDaId(long id) {

		Dipendente dipendente = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from Dipendente where idutente=:id");
			query.setLong("id", id);

			dipendente = (Dipendente) query.uniqueResult();

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return dipendente;
	}
		
	
	/// TUTTI I DIPENDENTI
	public List<Dipendente> leggiTuttiDipendenti() {
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		
		List<Dipendente> dipendenti = new ArrayList<Dipendente>();

		try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query=session.createQuery("from Dipendente");
				
			dipendenti = (List<Dipendente>)query.list();
				
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return dipendenti;			
	}
	
	
	/// MODIFICA DIPENDENTE
	public void modificaDipendente(Dipendente d) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.update(d);

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
		
		
	
	/// ELIMINA DIPENDENTE
	public void eliminaDipendente(Dipendente d) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.delete(d);
			
			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
}

package it.alfasoft.pierangelo.dao;

import it.alfasoft.pierangelo.model.rubrica.Rubrica;
import it.alfasoft.pierangelo.model.rubrica.Voce;

import java.util.List;

import hibernateUtil.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class VoceDao {

	/// AGGIUNGI 
	public Voce aggiungiVoce(String nome, String cognome, String telefono, Rubrica r){
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		
		Voce v = null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		v = new Voce(nome,cognome,telefono, r);
		
		session.persist(v);
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return v;
	}
	
	
	
	/// CERCA VOCE
	public Voce cercaVoce(long id){
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		
		Voce v = null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		Query query = session.createQuery("from Voce where id_voce=:id");
		query.setParameter("id", id);
		
		v = (Voce) query.uniqueResult();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return v;
	}
	
	
	
	/// LEGGI DA TELEFONO
	public Voce cercaTelefono(String telefono){
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		
		Voce v = null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		Query query = session.createQuery("from Voce where telefono=:telefono");
		query.setParameter("telefono", telefono);
		
		v = (Voce) query.uniqueResult();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return v;
	}
	
	/// LEGGI TUTTE LE VOCI
	public List<Voce> getTutteLeVoci(long id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		List<Voce> v = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from Voce where Rubrica_id_rubrica=:id");
			query.setLong("id", id);

			v = (List<Voce>) query.list();

			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return v;
	}
	
	
	/// MODIFICA
	public boolean modificaVoce(Voce v){
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		
		boolean modificato = false;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.update(v);
		modificato = true;
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return modificato;
	}
	
	
	/// ELIMINA
	public void eliminaVoce(Voce v){
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			
		tx=session.getTransaction();
		tx.begin();
		
		session.delete(v);
		
		tx.commit();
		
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
}

package it.alfasoft.pierangelo.dao;

import it.alfasoft.pierangelo.model.rubrica.Rubrica;
import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RubricaDao {

	
	/// AGGIUNGI 
	public Rubrica aggiungiRubrica(String name){
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		
		Rubrica r = null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		r = new Rubrica();
		r.setNome(name);
		
		session.persist(r);
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;
	}
	
	
	
	/// LEGGI DA NOME E COGNOME
	public Rubrica cercaRubrica(long id){
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		
		Rubrica r = null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		Query query = session.createQuery("from Rubrica where id_rubrica=:id");
		query.setLong("id", id);
		
		r = (Rubrica) query.uniqueResult();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;		
	}
	
	
	
	/// LEGGI ID DA RUBRICA
	public long leggiIdRubrica(String username){
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		
		long id = -1;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		Query query = session.createQuery("from Rubrica where nome=:nome");
		query.setString("nome", username);
		
		Rubrica r = (Rubrica) query.uniqueResult();
		id = r.getId_rubrica();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return id;		
	}
	
	
	
	/// ELIMINA
	public void eliminaRubrica(Rubrica r){
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.delete(r);
		
//		Query query = session.createQuery("delete from Rubrica where nome=:nome");
//		query.setString("nome", username);
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}		
	}
	
}

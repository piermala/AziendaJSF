package it.alfasoft.pierangelo.dao;

import it.alfasoft.pierangelo.model.bean.Admin;
import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDao {

	/// AGGIUNGI
	public Admin createAdmin(String nome, String cognome, String username, String password, String livelloAccesso){
			
		Admin admin = null;
			
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
			
			admin = new Admin(nome, cognome, username, password, 'A', livelloAccesso);
			session.persist(admin);
			
			tx.commit();
			
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
			
		return admin;	
	}
		
		
		
		/// CERCA CON USERNAME
		public Admin trovaAdminConUsername(String username) {
			
			Admin admin = null;
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();
			
				Query query=session.createQuery("from Admin where username=:username");
				query.setString("username", username);
				
				admin=(Admin)query.uniqueResult();
		
				tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return admin;			
		}
}

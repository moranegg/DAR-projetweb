package com.lmo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.jobs.ApiMusee;
import com.lmo.model.Affluence;
import com.lmo.model.Musee;
import com.lmo.model.User;

/**
 * 
 * @author lina
 *
 */
public class UserDao 
{
	
	  /**
	   *  Cette méthode permer de récupérer les nformations d'un utilisateur à partir de son mail
	   * @param email
	   * @return User
	   */
	   public static User getUserByUserEmail(String email) 
	    {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null;
	        User user = null;
	        try 
	        {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from User where email='"+email+"'");
	            user = (User)query.uniqueResult();
	            tx.commit();
	        }
	        catch (Exception e) 
	        {
	            if (tx != null) 
	            {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            session.close();
	        }
	        return user;
	    }
	   
	   /**
	    * Cette méthode permet de récupérer les informations d'un utilisateur à partir de son id
	    * @param id
	    * @return User
	    */
	   public static User getUserById(String id) 
	    {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null;
	        User user = null;
	        try 
	        {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from User where id='"+id+"'");
	            user = (User)query.uniqueResult();
	            tx.commit();
	        }
	        catch (Exception e) 
	        {
	            if (tx != null) 
	            {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            session.close();
	        }
	        return user;
	    }
	   
	   /**
	    * Cette méthode permet d'insérer un nouvel utilisateur en base de données 
	    * 
	    * @param nom
	    * @param prenom
	    * @param codep
	    * @param email
	    * @param password
	    * @return User
	    */
	   public static User createUser(String nom ,String prenom ,String codep, String email,String password)
	    	    {
        	        User user = null;

	    	    	SessionFactory sessFact = new 
	    	    			Configuration().configure().buildSessionFactory();
	    	    	Session sess = sessFact.openSession();
	    	    	Transaction tran =sess.beginTransaction();
	    	    	Query query = sess.createQuery("from User where email = :email");
	    	    	query.setParameter("email", email);
	    	    	List list = query.list();
	    	    	if(list.isEmpty())
	    	    	{
 	    	        	user = new User();
	    	        	user.setNom(nom);
	    	        	user.setPrenom(prenom);
	    	        	user.setCodep(codep);
	    	        	user.setEmail(email);
	    	        	user.setPassword(password);
	    	        	sess.save(user);
	    	        	tran.commit();
	    	    	}

	    	    	
	    	    	return user;
	    	    	
	    	    	
	    	    }
	     
	    /**
	     * Cette méthode permet de mettre à jour les informations d'un utilisateur
	     * 
	     * @param olduser : les ancienneces informations de l'utilisateur
	     * @param nom : nouveau nom saisi par l'utilisateur
	     * @param prenom : nouveau prénom saisi par l'utilisateur
	     * @param codep : nouveau codep saisi par l'utilisateur
	     * @param email : nouvel email saisi par l'utilisateur
	     * @param password : nouveau mdp saisi par l'utilisateur
	     */
	    public static void updateUser(User olduser,
	    		String nom, String prenom, String codep, String email, String password)
	    {
	    	
	    	SessionFactory sessFact = new 
	    			Configuration().configure().buildSessionFactory();
	    	Session sess = sessFact.openSession();
	    	Transaction tran =sess.beginTransaction();
	    	
	    	if(nom!="")
	        	olduser.setNom(nom);
	    	if(prenom != "")
	        	olduser.setPrenom(prenom);
	    	if(codep!="")
	        	olduser.setCodep(codep);
	    	if(email!="")
	        	olduser.setEmail(email);
	    	if(password!="")
	        	olduser.setPassword(password);
	    	
	        	sess.saveOrUpdate(olduser);
	        	tran.commit();   	
	    	
	    }
 

	    
	   /**
	    * Cette méthode retourne l'id d'un utilisateur à partir de son email
	    * @param email
	    * @return l'id d'un utilisateur
	    */
	     public static int getUserId(String email) 
	    
	    {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null;
	        int id=0;
	        try 
	        {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("select user.id from User user where user.email='"+email+"'");
	            id = (int)query.uniqueResult();
	            tx.commit();
	        }
	        catch (Exception e) 
	        {
	            if (tx != null) 
	            {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            session.close();
	        }
	        return id;
	    }
	    
		
	    /**
	     * Cette méthode permet d'ajouter un musée aux favoris d'un utilisateur
	     * 
	     * @param iduser
	     * @param idmusee
	     * @return User
	     * @throws JSONException
	     */
	    public static User addFavoris (int iduser, int idmusee)
				throws JSONException
		{

			Session session = HibernateUtil.getSessionFactory().openSession();
			User user = UserDao.getUserById(String.valueOf(iduser));
			Musee musee = MuseeDao.getMuseeById(String.valueOf(idmusee));
			Set<Musee> c = user.getMusees();

       		boolean trouve= false; 
		     
            for (Musee m :c)
            {
            	if (trouve!=true)
            	{
            		if (m.getId()==musee.getId()) trouve=true;
            	}
            }
			
		    if (trouve==false) 
		    {
		    	
			Transaction tx = null;	
			try {
				tx = session.getTransaction();
				tx.begin();

			    c.add(musee);
			    user.setMusees(c);	
			    session.saveOrUpdate(user);	

				tx.commit();
				return user;
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} 
			finally {
				session.close();
			}
		    }

			

			return null;	
		}
		
		/**
		 * Cette méthode retourne les musées favoris d'un utilisateur
		 * @param iduser
		 * @return Set<Musee>
		 * @throws JSONException
		 */
		public static Set<Musee> listFavoris (String iduser)
				throws JSONException
		{

			Session session = HibernateUtil.getSessionFactory().openSession();

			Transaction tx = null;	
			try {
				tx = session.getTransaction();
				tx.begin();
				User user = UserDao.getUserById(iduser);
			    Set<Musee> c = user.getMusees();
			    tx.commit();
				return c;
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
			return null;	
		}

	   


}




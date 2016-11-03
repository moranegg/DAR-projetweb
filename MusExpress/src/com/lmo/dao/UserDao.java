package com.lmo.dao;

import java.util.ArrayList;
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
import com.lmo.model.Musee;
import com.lmo.model.User;

public class UserDao 
{
	
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
 
	    public List<User> getListOfUsers(){
	        List<User> list = new ArrayList<User>();
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = null;       
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            list = session.createQuery("from User").list();                       
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return list;
	    }
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
	    
		public static User addFavoris (int iduser, int idmusee)
				throws JSONException
		{

			Session session = HibernateUtil.getSessionFactory().openSession();

			Transaction tx = null;	
			try {
				tx = session.getTransaction();
				tx.begin();
				User user = UserDao.getUserById(String.valueOf(iduser));
				Musee musee = MuseeDao.getMuseeById(String.valueOf(idmusee));
			    Set<Musee> c = user.getMusees();
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
			} finally {
				session.close();
			}
			return null;	
		}
		
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



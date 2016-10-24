package com.lmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.model.User;
import com.lmo.utils.Tools;

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
	   
	    public static User createUser(String nom ,String prenom ,String codep, String email,String password)
	    	    {
        	        User user = null;

	    	    	SessionFactory sessFact = new 
	    	    			Configuration().configure().buildSessionFactory();
	    	    	Session sess = sessFact.openSession();
	    	    	Transaction tran =sess.beginTransaction();;
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
	}



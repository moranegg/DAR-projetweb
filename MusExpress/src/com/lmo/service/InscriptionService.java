package com.lmo.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.model.User;

public class InscriptionService 
{
//	Transaction tx = null;
//    Session session = null;
   // User user = null;
    
    public boolean createUser(String nom ,String prenom ,String codep, String email,String password)
    {
    	SessionFactory sessFact = new 
    			Configuration().configure().buildSessionFactory();
    	Session sess = sessFact.openSession();
    	Transaction tran =sess.beginTransaction();;
        
        try {
        	
        	User user = new User();
        	user.setNom(nom);
        	user.setPrenom(prenom);
        	user.setEmail(email);
        	user.setPassword(password);
        	sess.save(user);
        	tran.commit();
            return true;
        } 
        catch (Exception e) 
        {
            if (tran != null) 
            {
                tran.rollback();
            }
            e.printStackTrace();
        } finally {
            sess.close();
        }
    	return false;	
    	
    	
    }
}

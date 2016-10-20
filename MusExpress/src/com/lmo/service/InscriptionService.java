package com.lmo.service;


import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.model.User;

import com.lmo.utils.Tools;

public class InscriptionService 
{
//	Transaction tx = null;
//    Session session = null;
   // User user = null;
    
    public static JSONObject createUser(String nom ,String prenom ,String codep, String email,String password)
    throws JSONException
    {
    	SessionFactory sessFact = new 
    			Configuration().configure().buildSessionFactory();
    	Session sess = sessFact.openSession();
    	Transaction tran =sess.beginTransaction();;
    	Query query = sess.createQuery("from User where email = :email");
    	query.setParameter("email", email);
    	List list = query.list();
    	if(list.isEmpty())
    	{
    	//ResultSet rs = st.executeQuery(query);
//        try {
     // if()  	
        	User user = new User();
        	user.setNom(nom);
        	user.setPrenom(prenom);
        	user.setCodep(codep);
        	user.setEmail(email);
        	user.setPassword(password);
        	sess.save(user);
        	tran.commit();
        	return Tools.serviceMessage(1);
    	}
//        } 
//        catch (Exception e) 
//        {
//            if (tran != null) 
//            {
//                tran.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            sess.close();
//        }
//        
    	else
    		{
    			return Tools.serviceMessage("Email existant ! ");
    		}
    	
    	
    }
}
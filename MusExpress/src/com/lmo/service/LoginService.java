package com.lmo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.model.User;


import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.utils.Tools;
 
public class LoginService 
{
	
    Transaction tx = null;
    Session session = null;
    User user = null;
    
    
    public  JSONObject authenticateUser(String email, String password) throws SQLException, JSONException
    {
        User user = getUserByUserEmail(email);         
        if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password))
        {
            return Tools.serviceMessage(1);
            //return true;
        }
        else
        {
            return com.lmo.utils.Tools.serviceMessage("Invalid email or password");
            //return false;
        }
    	   
    }
    

 
    public User getUserByUserEmail(String email) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where email='"+email+"'");
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
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
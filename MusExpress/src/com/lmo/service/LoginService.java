package com.lmo.service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.lmo.hibernate.util.HibernateUtil;
import com.lmo.model.User;
 
public class LoginService 
{
	
    Transaction tx = null;
    Session session = null;
    User user = null;
    
    
    public boolean authenticateUser(String email, String password) 
    {
        User user = getUserByUserEmail(email);         
        if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password))
        {
            return true;
        }
        else
        {
            return false;
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
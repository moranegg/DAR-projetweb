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
import com.lmo.dao.UserDao;

public class LoginService 
{
	
    Transaction tx = null;
    Session session = null;
    User user = null;
    
    
    public  JSONObject authenticateUser(String email, String password) throws SQLException, JSONException
    {
        User user = UserDao.getUserByUserEmail(email);         
        if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password))
        {
        	
        	JSONObject jo = new JSONObject().put("id_user",UserDao.getUserId(email));
        	jo.put("message", 1);
            return jo;
            
            //return true;
        }
        else
        {
            return Tools.serviceMessage("Invalid email or password");
            //return false;
        }
    	   
    }
    
    
	public static User getUserByUserEmail(String email) throws SQLException, Exception 
	{
		User user = UserDao.getUserByUserEmail(email);
		if (user != null)
			return user;
		return null;
	}
}
    

 
 
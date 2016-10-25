package com.lmo.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.UserDao;
import com.lmo.model.User;
import com.lmo.utils.Tools;

public class ConsulterUserService {
	public static JSONObject getUser(String id)
    	    throws JSONException
    {
        
		User user = UserDao.getUserById(id);
		
        if(user!=null)
        {
        	       	
        	//on retourne l'utilisateur
        	
        	return Tools.serviceMessage(user);
            //return true;
        }
        else
        {
            return Tools.serviceMessage("Problème !");
            //return false;
        }
    	   
    }
}

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
        	
        	//return Tools.serviceMessage(user);
        	JSONObject jo = new JSONObject().put("id_user",id);
        	jo.put("nom", user.getNom());
        	jo.put("prenom", user.getPrenom());
        	jo.put("codep", user.getCodep());
        	jo.put("email", user.getEmail());
        	jo.put("password", user.getPassword());
        	jo.put("message", 1);
            return jo;
        	
            //return true;
        }
        else
        {
            return Tools.serviceMessage("Probleme !");
            //return false;
        }
    	   
    }
}
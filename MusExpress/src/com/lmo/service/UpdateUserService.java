package com.lmo.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.UserDao;
import com.lmo.model.User;
import com.lmo.utils.Tools;

public class UpdateUserService {
	public static JSONObject updateUser(String id, String nom, String prenom, String codep, String email, String password)
    	    throws JSONException
    {
        
		User user = UserDao.getUserById(id);
		
        if(user!=null)
        {
        	//la modif 
        	UserDao.updateUser(user, nom, prenom, codep, email, password);
        	
        	//on retourne l'identifiant de l'utilisateur
        	//return Tools.serviceMessage(""+id);
            //return true;
        	JSONObject jo = new JSONObject().put("id_user",id);
        	jo.put("message", 1);
            return jo;
        }
        else
        {
            return Tools.serviceMessage("Problème !");
            //return false;
        }
    	   
    }
}
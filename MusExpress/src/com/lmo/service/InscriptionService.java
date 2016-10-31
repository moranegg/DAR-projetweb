package com.lmo.service;


import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.utils.Tools;
import com.lmo.dao.UserDao;
import com.lmo.model.User;

public class InscriptionService 
{

    public static JSONObject createUser(String nom ,String prenom ,String codep, String email,String password)
    	    throws JSONException
    {
        User user = UserDao.createUser(nom,prenom,codep,email,password);         
        if(user!=null)
        {
        	JSONObject jo = new JSONObject().put("id_user",UserDao.getUserId(email));
        	jo.put("message", 1);
            return jo;
        }
        else
        {
            return Tools.serviceMessage("Email existant");
            //return false;
        }
    	   
    }
}
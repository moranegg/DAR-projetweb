package com.lmo.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.UserDao;
import com.lmo.model.User;

import com.lmo.utils.Tools;

public class InscriptionService 
{

    public static JSONObject createUser(String nom ,String prenom ,String codep, String email,String password)
    	    throws JSONException
    {
        User user = UserDao.createUser(nom,prenom,codep,email,password);         
        if(user!=null)
        {
        	return Tools.serviceMessage(""+UserDao.getUserId(email));
            //return true;
        }
        else
        {
            return Tools.serviceMessage("Email existant");
            //return false;
        }
    	   
    }
}
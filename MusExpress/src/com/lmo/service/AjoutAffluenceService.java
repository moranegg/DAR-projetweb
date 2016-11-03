package com.lmo.service;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.AffluenceDao;
import com.lmo.dao.UserDao;
import com.lmo.model.Affluence;
import com.lmo.model.User;

public class AjoutAffluenceService
{
	
	public static JSONObject addAffluence (int id_user, int id_musee, String longueur_file, String commentaire, int file, Date date)
			throws JSONException
	{
		JSONObject jo = new JSONObject();
		Affluence affluence = AffluenceDao.addAffluence(id_user, id_musee, longueur_file, commentaire, file, date);         
		if(affluence!=null)
		{
			jo.put("message", "1");
			jo.put("affluence", affluence);
			return jo;
		}
		else
		{
			jo.put("message", "Problème");
			jo.put("affluence", "");
			return jo;		
		}

	}

}

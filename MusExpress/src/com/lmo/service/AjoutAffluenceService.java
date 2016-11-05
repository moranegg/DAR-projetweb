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
	
	public static JSONObject addAffluence (String id_user, String id_musee, String duree, String text, String emplacement)
			throws JSONException
	{
		JSONObject jo = new JSONObject();
		Affluence affluence = AffluenceDao.addAffluence(id_user, id_musee, duree, text, emplacement);         
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

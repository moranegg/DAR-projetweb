package com.lmo.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.MuseeDao;
import com.lmo.model.Musee;
import com.lmo.utils.Tools;

public class ConsulterMuseeService 
{
	public static JSONObject getMusee(String id)
			throws JSONException
	{

		Musee musee = MuseeDao.getMuseeById(id);

		if(musee!=null)
		{

			//on retourne le musée

			return Tools.serviceMessage(musee);
			//return true;
		}
		else
		{
			return Tools.serviceMessage("Problème !");
			//return false;
		}

	}
}

package com.lmo.service;

import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.MuseeDao;
import com.lmo.dao.UserDao;
import com.lmo.model.Musee;

public class AfficherMuseesProximite 
{

	public static JSONObject listProximite(String id)
			throws JSONException
	{

		List<Musee> museelist = MuseeDao.getListMuseesProximite(id);
		JSONArray array = new JSONArray();
		JSONObject response = new JSONObject();

		int i;
		if (museelist!=null)
		{
			response.put("message", "1");
			for(Musee m : museelist)
			{
				JSONObject museeJSON = new JSONObject();

				museeJSON.put("id", m.getId());
				museeJSON.put("nomMusee", m.getNom());
				JSONObject localisation = new JSONObject();
				localisation.put("lat", m.getLatitude());
				localisation.put("lng", m.getLongitude());
				museeJSON.put("localisation", localisation);
				array.put(museeJSON);
			}
			
			response.put("musee",array);
			return response;

			
		}
		

		else
		{
			response.put("message","problème!");
			response.put("musee","");
			return response;

		}

	}
	

}

package com.lmo.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.MuseeDao;
import com.lmo.model.Musee;

public class RechercherMuseeService 
{
	public static JSONObject getListOfMusees(String nom)
			throws JSONException
	{

		List<Musee> museelist = MuseeDao.getListOfMusees(nom);
		JSONArray array = new JSONArray();
		JSONObject response = new JSONObject();

		int i;
		if (museelist!=null)
		{
			response.put("message", "1");
			for(i=0; i<museelist.size(); i++)
			{
				JSONObject museeJSON = new JSONObject();

				museeJSON.put("id", museelist.get(i).getId());
				museeJSON.put("nom", museelist.get(i).getNom());
				museeJSON.put("adresse", museelist.get(i).getAdresse());
				museeJSON.put("ville", museelist.get(i).getVille());
				museeJSON.put("departement", museelist.get(i).getDepartement());
				museeJSON.put("codep", museelist.get(i).getCodep());
				museeJSON.put("ferme", museelist.get(i).getFerme());
				museeJSON.put("siteweb", museelist.get(i).getSiteweb());
				museeJSON.put("periode_ouvertue", museelist.get(i).getPeriode_ouvertue());
				museeJSON.put("fermeture_annuelle", museelist.get(i).getFermeture_annuelle());
				museeJSON.put("latitude", museelist.get(i).getLatitude());
				museeJSON.put("longitude", museelist.get(i).getLongitude());	
				museeJSON.put("type", museelist.get(i).getType());



				array.put(museeJSON);
			}
			
			response.put("musees",array);
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

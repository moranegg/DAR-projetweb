package com.lmo.service;

import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.MuseeDao;
import com.lmo.dao.UserDao;
import com.lmo.model.Musee;

public class AfficherFavorisService {


	
	public static JSONObject listFavoris(String id)
			throws JSONException
	{

		Set<Musee> museelist = UserDao.listFavoris(id);
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
				museeJSON.put("nom", m.getNom());
				/*museeJSON.put("adresse", m.getAdresse());
				museeJSON.put("ville", m.getVille());
				museeJSON.put("departement", m.getDepartement());
				museeJSON.put("codep", m.getCodep());
				museeJSON.put("ferme", m.getFerme());
				museeJSON.put("siteweb", m.getSiteweb());
				museeJSON.put("periode_ouvertue", m.getPeriode_ouvertue());
				museeJSON.put("fermeture_annuelle", m.getFermeture_annuelle());
				museeJSON.put("latitude", m.getLatitude());
				museeJSON.put("longitude", m.getLongitude());	
				museeJSON.put("type", m.getType());*/



				array.put(museeJSON);
			}
			
			response.put("musees",array);
			return response;

			
		}
		

		
		


		else
		{
			response.put("message","problème!");
			response.put("musees","");
			return response;

		}

	}

}

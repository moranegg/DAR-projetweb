package com.lmo.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.MuseeDao;
import com.lmo.model.Musee;

public class ConsulterMuseeService 
{
	public static JSONObject getMusee(String id)
			throws JSONException
	{

		Musee musee = MuseeDao.getMuseeById(id);

		if(musee!=null)
		{

			//on retourne le musée
			//return Tools.serviceMessage(musee);
			//return true;

			
            JSONObject museeJSON = new JSONObject();
			
			museeJSON.put("id", musee.getId());
			museeJSON.put("nom", musee.getNom());
			museeJSON.put("adresse", musee.getAdresse());
			museeJSON.put("ville", musee.getVille());
			museeJSON.put("departement", musee.getDepartement());
			museeJSON.put("codep", musee.getCodep());
			museeJSON.put("ferme", musee.getFerme());
			museeJSON.put("siteweb", musee.getSiteweb());
			museeJSON.put("periode_ouvertue", musee.getPeriode_ouvertue());
			museeJSON.put("fermeture_annuelle", musee.getFermeture_annuelle());
			museeJSON.put("latitude", musee.getLatitude());
			museeJSON.put("longitude", musee.getLongitude());
			
			
			
			return museeJSON;








		}
		else
		{
			return new JSONObject().put("musee","");

			//return false;
		}

	}
	
	
	
}
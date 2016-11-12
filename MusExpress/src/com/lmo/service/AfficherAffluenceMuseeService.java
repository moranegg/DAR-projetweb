package com.lmo.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.AffluenceDao;
import com.lmo.model.Affluence;

/**
 * 
 *
 */
public class AfficherAffluenceMuseeService 
{

	public static JSONObject listAffluence(String id)
			throws JSONException
	{

		List<Affluence> affluencelist = AffluenceDao.getListOfAffluences(id);
		JSONArray array = new JSONArray();
		JSONObject response = new JSONObject();

		int i;
		if (affluencelist!=null)
		{
			response.put("message", "1");
			for(Affluence a : affluencelist)
			{
				JSONObject affluenceJSON = new JSONObject();

				affluenceJSON.put("id", a.getId_commentaire());
				affluenceJSON.put("user", a.getUser());
				affluenceJSON.put("musee", a.getMusee());
				affluenceJSON.put("duree", a.getDuree());
				affluenceJSON.put("emplacement", a.getEmplacement());
				affluenceJSON.put("text", a.getText());
				affluenceJSON.put("date", a.getDate());

				array.put(affluenceJSON);
			}
			
			response.put("affluence",array);
			return response;

			
		}
		
		else
		{
			response.put("message","problème!");
			response.put("affluence","");
			return response;

		}

	}
	
	public static void main(String[] args) throws Exception 
	{

         System.out.println(listAffluence("1"));



	}


}

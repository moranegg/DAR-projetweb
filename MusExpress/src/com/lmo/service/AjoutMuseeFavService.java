package com.lmo.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.UserDao;
import com.lmo.model.User;
import com.lmo.utils.Tools;

public class AjoutMuseeFavService 
{
	/*   public static JSONObject ajoutFav(int iduser ,int idmusee)
	    	    throws JSONException
	    {
	        Favoris favoris = FavorisDao.addFavoris1(iduser,idmusee);         
	        if(favoris!=null)
	        {
	            return Tools.serviceMessage("1");

	        }
	        else
	        {
	            return Tools.serviceMessage("Une erreur s'est produite");
	        }

	    }*/

	public static JSONObject ajoutFav(int iduser ,int idmusee)
			throws JSONException
	{
		JSONObject jo = new JSONObject();
		User user = UserDao.addFavoris(iduser,idmusee);         
		if(user!=null)
		{
			jo.put("message", "1");
			jo.put("user", user);
			return jo;
		}
		else
		{
			jo.put("message", "Problème");
			jo.put("user", "");
			return jo;		
		}

	}

}

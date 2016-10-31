package com.lmo.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.FavorisDao;
import com.lmo.model.Favoris;
import com.lmo.utils.Tools;

public class AjoutMuseeFavService 
{
	   public static JSONObject ajoutFav(int iduser ,int idmusee)
	    	    throws JSONException
	    {
	        Favoris favoris = FavorisDao.addFavoris(iduser,idmusee);         
	        if(favoris!=null)
	        {
	            return Tools.serviceMessage("1");

	        }
	        else
	        {
	            return Tools.serviceMessage("Une erreur s'est produite");
	        }
	    	   
	    }

}

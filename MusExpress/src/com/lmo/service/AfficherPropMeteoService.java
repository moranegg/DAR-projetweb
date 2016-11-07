package com.lmo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.api.ApiMeteo;
import com.lmo.dao.AffluenceDao;
import com.lmo.dao.MuseeDao;
import com.lmo.model.Affluence;
import com.lmo.model.Musee;

public class AfficherPropMeteoService {

	public static JSONObject listPropMeteo()
			throws JSONException, IOException
	{
		JSONObject result = new JSONObject();
		result.put("message", "1");
		
		JSONObject jo = ApiMeteo.getMeteo();//il vaut meiux faire un seul appel ??? A revoir!!
		//JSONArray weather = jo.getJSONArray("weather");
		
		//Récupération de la description de la météo
		String climat = jo.getString("main");
		System.out.println("\n\n\n"+climat);
		
		//Récupération des files d'attentes pour les musées
		
//		JSONObject file = AfficherPropAffService.listPropAff();
//		JSONArray array = file.getJSONArray("affluence");
		
		//créer liste de musées parmi les musées proposé
		
//		ArrayList<String> attente_ext = null;
//		ArrayList<String> attente_int = null;
		
//		for(int i=0; i<array.length(); i++)
//		{
//			JSONObject x = array.getJSONObject(i);
////			x.getString("emplacement");
//			
//			if(x.getString("emplacement").equals("interieur")){
//				attente_int.add(x.getString("id"));//l'identifiant du musée
//			}
//			if(x.getString("emplacement").equals("exterieur")){
//				attente_ext.add(x.getString("id"));//l'identifiant du musée
//			}
//		}
		List<Musee> propositions = null;
		// Récupération des musées et des parcs
		List<Musee> lieux = MuseeDao.getAllMusees();
		List<Musee> musees = null;
		List<Musee> parcs = null;
		for(Musee m : lieux)
		{
			if(m.getType().equals("musée"))
			{
				musees.add(m);
			}
			
			if(m.getType().equals("parc"))
			{
				parcs.add(m);
			}
		}
		
		// Récupération des musées selon les files d'attentes
		
		List<Affluence> aff_int = AffluenceDao.getAffluenceByEmplacement("interieur");
		List<Affluence> aff_ext = AffluenceDao.getAffluenceByEmplacement("exterieur");
		
		if(climat.equals("Mist") || climat.equals("Rain") || climat.equals("Snow"))
		{ int i=0;
			for(Musee m : musees)
			{// pour chaque musée vérifier si la queue est interieure ou ext
				// et ce à partir de la table affluence
				for(Affluence a : aff_int)
				{
					if(m.getId()==a.getMusee().getId() && i<10)
					{
						propositions.add(m);
						i++;
					}	
				}
			}
			//retourner 10 musées
		}
		
		if(climat.equals("Clear sky"))
		{int i=0;
			for(Musee m : parcs)
			{
				if(i<10)
				{
					propositions.add(m);
					i++;
				}
			}
			for(Musee m : musees)
			{
				for(Affluence a : aff_ext)
				{
					if(m.getId()==a.getMusee().getId() && i<10)
					{
						propositions.add(m);
						i++;
					}	
				}
			}
			//retourner 10 parcs et/ou musées
		}
		result.put("propositions", propositions);
		return result;
		//je dois retourner un json contenant les musées ou les parcsà visiter selon la météo et
		// la file d'attente
	}
	
	public static void main(String[] args) throws JSONException, IOException
	{
		System.out.println(listPropMeteo());
	}
}

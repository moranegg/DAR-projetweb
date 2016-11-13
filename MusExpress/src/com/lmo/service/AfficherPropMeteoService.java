package com.lmo.service;



import java.io.IOException;

import java.util.ArrayList;

import java.util.List;



import org.json.JSONArray;

import org.json.JSONException;

import org.json.JSONObject;

import com.lmo.dao.AffluenceDao;

import com.lmo.dao.MuseeDao;
import com.lmo.jobs.ApiMeteo;
import com.lmo.model.Affluence;

import com.lmo.model.Musee;


/**
 * 
 * Service that gets propositions by meteo of the day
 *
 */
public class AfficherPropMeteoService {


	/**
	 * Retourne un objet JSON qui contient le message 1 de r�ussite et la liste des propositions
	 * @return
	 * @throws JSONException
	 */
	public static JSONObject listPropMeteo()

			throws JSONException, IOException

	{

		JSONObject result = new JSONObject();
		result.put("message", "1");
		JSONObject meteoDuMoment = ApiMeteo.getMeteo();

		JSONArray ja = new JSONArray();

		//initialisation de la liste vide
		ArrayList propositions = new ArrayList<>();
		ArrayList<Musee> toReturn = new ArrayList<Musee>();

		// Récupération des musées et des parcs
		ArrayList<Musee> lieux = MuseeDao.getAllMusees();
		ArrayList<Musee> musees = new ArrayList<Musee>();
		ArrayList<Musee> parcs = new ArrayList<Musee>();


		//Récupération de la description de la météo
		String climat = meteoDuMoment.getString("main");
		String[] climatOptions = {"Clear","Sunny","Clouds","Mist","Rain","Snow","Drizzle",""};
		//test de la meteo du moment
		//String climat = climatOptions[6];
		//System.out.println(climat);
		
		if(climat.equals("Clear") ||  climat.equals("Sunny") ){//si il fait beau=> parc
			//System.out.println(climat);
			for(int i=0;i<lieux.size()&& propositions.size()<5;i++ )
			{
				//m c'est un parc
				Musee m= lieux.get(i);
				if(lieux.get(i).getType().equals("parc"))
				{
					//pour ne pas ajouter deux fois le meme musee
					if(!toReturn.contains(m)){
						JSONObject jm = toJsonObject(m);
						toReturn.add(m);
						propositions.add(jm);
					}

				}
			}


		}else if( climat.equals("Clouds")|| climat.equals("Drizzle")){ //si nuageux  =>  musee + file d'attente ext	
			List<Affluence> aff_ext = AffluenceDao.getAffluenceByEmplacement("exterieur");
			for(int j=0; j<aff_ext.size()&& propositions.size()<5; j++){
				Musee m=aff_ext.get(j).getMusee();
				if(m.getType().equals("musee"))
				{
					//pour ne pas ajouter deux fois le meme musee
					if(!toReturn.contains(m)){
						JSONObject jm = toJsonObject(m);
						toReturn.add(m);
						propositions.add(jm);
					}
				}	
			}

		}else if(climat.equals("Mist") || climat.equals("Rain") || climat.equals("Snow")){//si il pleut => musee + file d'attente in
			//System.out.println(climat);
			// Récupération des musées selon les files d'attentes
			List<Affluence> aff_int = AffluenceDao.getAffluenceByEmplacement("interieur");
			for(int j=0; j<aff_int.size()&& propositions.size()<5; j++){
	
				Musee m=aff_int.get(j).getMusee();
				if(m.getType().equals("musee"))
				{
					//pour ne pas ajouter deux fois le meme musee
					if(!toReturn.contains(m)){
						JSONObject jm = toJsonObject(m);
						toReturn.add(m);
						propositions.add(jm);
					}

				}	
			}
		}
		//si aucun musee a ete ajoute-> ajouter les 5 premiers musees
		if(propositions.isEmpty()){
			for(int i=0; propositions.size()<5;i++)
			{
				int x=0;
				x=(int)( Math.random()*100);
				//System.out.println(x);
				
				Musee m= lieux.get(x);
				//pour ne pas ajouter deux fois le meme musee
				if(!toReturn.contains(m)){
					JSONObject jm = toJsonObject(m);
					toReturn.add(m);
					propositions.add(jm);
				}

			}	
		}
		//System.out.println(climat);
		result.put("propositions", propositions);
		
		return result;

	}



	public static void main(String[] args) throws JSONException, IOException

	{

		System.out.println(listPropMeteo());

	}
	
	/**
	 * Retourne un objet JSON � partir d'un musee
	 * @param m
	 * @return
	 */
	public static JSONObject toJsonObject(Musee m){
		JSONObject jm = new JSONObject();
		JSONObject localisation = new JSONObject();
		try {
			localisation.put("lng", m.getLongitude());
			localisation.put("lat", m.getLatitude());
			jm.put("nom",m.getNom());
			jm.put("id",m.getId());
			jm.put("localisation", localisation);
		} catch (JSONException e) {

		}
		
		
		return jm;
	}

}
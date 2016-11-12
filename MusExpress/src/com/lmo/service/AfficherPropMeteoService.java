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

		//System.out.println("\n\n\n"+climat);



		ArrayList propositions = new ArrayList<>();

		// Récupération des musées et des parcs

		ArrayList<Musee> lieux = MuseeDao.getAllMusees();

		ArrayList<Musee> musees = new ArrayList<Musee>();

		ArrayList<Musee> parcs = new ArrayList<Musee>();

		for(int i=0;i<lieux.size();i++)

		{

			if(lieux.get(i).getType().equals("musée"))

			{

				musees.add(lieux.get(i));

			}



			if(lieux.get(i).getType().equals("parc"))

			{

				parcs.add(lieux.get(i));

			}

		}

		// Récupération des musées selon les files d'attentes

		List<Affluence> aff_int = AffluenceDao.getAffluenceByEmplacement("interieur");

		List<Affluence> aff_ext = AffluenceDao.getAffluenceByEmplacement("exterieur");

		

		JSONArray ja = new JSONArray();



		if(climat.equals("Mist") || climat.equals("Rain") || climat.equals("Snow"))

		{ int i=0;

		for(Musee m : musees)

		{// pour chaque musée vérifier si la queue est interieure ou ext

			// et ce à partir de la table affluence

			for(Affluence a : aff_int)

			{

				if(m.getId()==a.getMusee().getId() && i<5)

				{

					JSONObject jm = new JSONObject();

					JSONObject localisation = new JSONObject();

					localisation.put("lng", m.getLongitude());

					localisation.put("lat", m.getLatitude());

					

					jm.put("nom",m.getNom());

					
					jm.put("id",m.getId());
					jm.put("localisation", localisation);

					propositions.add(jm);

					i++;

				}	

			}

		}

		//retourner 10 musées

		}



		if(climat.equals("Clear") || climat.equals("Clouds"))

		{

			int i=0;

			for(Musee m : parcs)

			{

				if(i<5)

				{

					JSONObject jm = new JSONObject();

					JSONObject localisation = new JSONObject();

					localisation.put("lng", m.getLongitude());

					localisation.put("lat", m.getLatitude());

					

					jm.put("nom",m.getNom());

					jm.put("id",m.getId());

					jm.put("localisation", localisation);

					propositions.add(jm);

					i++;

				}

			}

			for(Musee m : musees)

			{

				for(Affluence a : aff_ext)

				{

					if(m.getId()==a.getMusee().getId() && i<5)

					{

						JSONObject jm = new JSONObject();

						JSONObject localisation = new JSONObject();

						localisation.put("lng", m.getLongitude());

						localisation.put("lat", m.getLatitude());

						jm.put("id",m.getId());

						jm.put("nom",m.getNom());

						

						jm.put("localisation", localisation);

						propositions.add(jm);

						i++;

					}	

				}

			}

			//retourner 10 parcs et/ou musées

		}



		result.put("propositions", propositions);

		return result;

	}



	public static void main(String[] args) throws JSONException, IOException

	{

		System.out.println(listPropMeteo());

	}

}
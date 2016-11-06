package com.lmo.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.MuseeDao;



public class ApiMusee 

{
	public static void main(String[] args) throws Exception 
	{

		ApiMusee http = new ApiMusee();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGetMusees();
		http.sendGetParcs();



	}

	private void sendGetMusees() throws Exception 
	{

		String url = "http://data.iledefrance.fr/api/records/1.0/search/?dataset=liste_des_musees_franciliens&rows=139";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		System.out.println(response.toString());

		try 
		{
			JSONObject j = new JSONObject(response.toString());

			if ( j.getJSONArray( "records" ).length() >0) 
			{
				JSONArray musees = j.getJSONArray( "records" );

				for ( int i = 0 ; i < musees.length() ; i++ ) 
				{
					JSONObject jo = musees.getJSONObject( i );
					JSONObject ja = jo.getJSONObject("fields");
					String nom_du_musee = "", adresse = "", ville = "", ferme = "", sitweb = "", periode_ouverture = "", fermeture_annuelle = "";
					int dept = 0, cp =0;
					double latitude = 0, longitude =0;
					
					if (ja.has("nom_du_musee"))
						nom_du_musee = ja.getString("nom_du_musee");
					
					if (ja.has("adresse"))
						adresse = ja.getString("adresse");
					
					if (ja.has("ville"))
						ville = ja.getString("ville");
					
					if (ja.has("dept"))
						dept = ja.getInt("dept");
					
					if (ja.has("cp"))
						cp = ja.getInt("cp");
					
					if (ja.has("ferme"))
						ferme = ja.getString("ferme");
					
					if (ja.has("sitweb"))
						sitweb = ja.getString("sitweb");
					
					if (ja.has("periode_ouverture"))
						periode_ouverture = ja.getString("periode_ouverture");
					
					if (ja.has("fermeture_annuelle"))
						fermeture_annuelle = ja.getString("fermeture_annuelle");
					
					if (ja.has("wgs84"))
					{
						if (ja.getJSONArray("wgs84").length()>0)
						{
							latitude = ja.getJSONArray("wgs84").getDouble(0);
							longitude = ja.getJSONArray("wgs84").getDouble(1);						
						}
					}
					
					
						
					System.out.println(i);

					
					MuseeDao.addMusee
					(nom_du_musee, 
							adresse, 
							ville, 
							dept, 
							cp, 
							ferme, 
							sitweb, 
							periode_ouverture, 							
							fermeture_annuelle, 
							latitude, 
							longitude,"musée");
					

					
				}
			}
		}

			catch (JSONException e) 
			{
				e.printStackTrace();
			}

		}
	
	private void sendGetParcs() throws Exception 
	{

		String url = "http://data.iledefrance.fr/api/records/1.0/search/?dataset=parcs-naturels-regionaux&q=musée&rows=51";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

//		System.out.println(response.toString());

		try 
		{
			JSONObject j = new JSONObject(response.toString());

			if ( j.getJSONArray( "records" ).length() >0) 
			{
				JSONArray parcs = j.getJSONArray( "records" );

				for ( int i = 0 ; i < parcs.length() ; i++ ) 
				{
					JSONObject jo = parcs.getJSONObject( i );
					JSONObject ja = jo.getJSONObject("fields");
					String titre="", parc="", adresse = "", ville = "", ferme = "", sitweb = "", periode_ouverture = "", fermeture_annuelle = "";
					int dept = 0, cp =0;
					double latitude = 0, longitude =0;
					
					
					if (ja.has("titre"))
						titre = ja.getString("titre");
					
					if (ja.has("parc"))
						parc = ja.getString("parc");
					
					
					if (ja.has("adresse"))
						adresse = ja.getString("adresse");
					
					if (ja.has("ville"))
						ville = ja.getString("ville");
					
					if (ja.has("departement"))
						dept = ja.getInt("departement");
					
					if (ja.has("code_postal"))
						cp = ja.getInt("code_postal");
					
					if (ja.has("ferme"))
						ferme = ja.getString("ferme");
					
					if (ja.has("site_web"))
						sitweb = ja.getString("site_web");
					
					if (ja.has("horaires"))
						periode_ouverture = ja.getString("horaires");
					

					
					if (ja.has("wgs84"))
					{
						if (ja.getJSONArray("wgs84").length()>0)
						{
							latitude = ja.getJSONArray("wgs84").getDouble(0);
							longitude = ja.getJSONArray("wgs84").getDouble(1);						
						}
					}
					
					
						
					System.out.println(i);

					
					MuseeDao.addMusee
					(titre+", Parc " +parc, 
							adresse, 
							ville, 
							dept, 
							cp, 
							ferme, 
							sitweb, 
							periode_ouverture, 							
							fermeture_annuelle, 
							latitude, 
							longitude,
							"parc");
					

					
				}
			}
		}

			catch (JSONException e) 
			{
				e.printStackTrace();
			}

		}
	}
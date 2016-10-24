package com.lmo.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.model.Musee;
import com.lmo.dao.MuseeDao;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;



public class ApiMusee 

{
	public static void main(String[] args) throws Exception 
	{

		ApiMusee http = new ApiMusee();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();


	}

	private void sendGet() throws Exception 
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

//		System.out.println(response.toString());

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
							longitude);
					

					
				}
			}
		}

			catch (JSONException e) 
			{
				e.printStackTrace();
			}

		}
	}
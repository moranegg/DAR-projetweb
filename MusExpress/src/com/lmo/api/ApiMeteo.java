package com.lmo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ApiMeteo {
	public static void main(String[] args) throws Exception 
	{
		ApiMeteo req = new ApiMeteo();
		req.getMeteo();
	}

	public static JSONObject getMeteo() throws IOException, JSONException {
		
		// Vous remarquerez qu'ici l'id correspond à l'id de Paris
		String url ="http://api.openweathermap.org/data/2.5/weather?id=6942553&appid=5f874cd5ab9513b09966412504731102";
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
		
		JSONObject j = new JSONObject(response.toString());
		
		JSONObject resp = new JSONObject();

		// DATA RECEIVING TIME
		String dt=j.getString("dt");
		resp.append("dt", dt);
		
		// Coordonnées de la ville de Paris
		JSONObject coord=j.getJSONObject("coord");
		String lon = coord.getString("lon");
		String lat = coord.getString("lat");
		
		resp.append("lon", lon);
		resp.append("lat", lat);
		
		// Visibilité
		String visibility=j.getString("visibility");
		
		resp.append("visibility", visibility);
		
		//Weather
		JSONArray weather = j.getJSONArray("weather");
		resp.append("weather", weather);
		for(int i=0;i<weather.length();i++)
		{
			JSONObject jo = weather.getJSONObject(i);
			String icon = jo.getString("icon");
			String description = jo.getString("description");
			String main = jo.getString("main");
			//String id = jo.getString("id");
			
			jo.append("icon", icon);
			jo.append("description", description);
			jo.append("main", main);
		}
		
		//Le nom de la ville
		String name=j.getString("name");
		resp.append("name", name);
		
		//String cod=j.getString("cod");
		
		//Température, ...etc
		JSONObject main = j.getJSONObject("main"); 
		String temp = main.getString("temp");
		String temp_min = main.getString("temp_min");
		String humidity = main.getString("humidity");
		String pressure = main.getString("pressure");
		String temp_max = main.getString("temp_max");
		
		resp.append("temp", temp);
		resp.append("temp_min", temp_min);
		resp.append("humidity", humidity);
		resp.append("pressure", pressure);
		resp.append("temp_max", temp_max);

		// Clouds
		JSONObject clouds=j.getJSONObject("clouds"); 
		String all=clouds.getString("all"); //% cloudiness
		
		resp.append("clouds_all", all);
		
		//Identifiant de la ville
		String id =j.getString("id");
		
		resp.append("id", id);
		
		// Contient des infos sur sunrise et sunset
		JSONObject sys=j.getJSONObject("sys"); 
		String country = sys.getString("country"); // code du pays
		String sunrise = sys.getString("sunrise");
		String sunset = sys.getString("sunset");
		
		resp.append("country", country);
		resp.append("sunrise", sunrise);
		resp.append("sunset", sunset);
		
		//Vent
		JSONObject wind=j.getJSONObject("wind");
		String deg = wind.getString("deg");
		String speed = wind.getString("speed");
		
		resp.append("wind_deg", deg);
		resp.append("wind_speed", speed);
		
		return resp;
	}
	
}

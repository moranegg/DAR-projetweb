package com.lmo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.api.ApiMeteo;

/**
 * Servlet permettant de recevoir les données json de l'api OpenWeatherMap en appelant
 * la méthode getMeteo de la classe ApiMeteo
 */
public class GetWeatherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

public GetWeatherServlet()
{
	super();
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");

		try {
			
			JSONObject jo = ApiMeteo.getMeteo();
			jo.put("message", "1");
			response.getWriter().print(jo);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}

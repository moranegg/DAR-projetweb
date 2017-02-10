package com.lmo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.lmo.service.AfficherAffluenceMuseeService;

/**
 * Servlet permettant de retourner la liste des affluences (en json) pour un musée dont l'identifiant est id_musée
 * en appelant la méthode listAffluence de la classe AfficherAffluenceMuseeService
 */
public class CookieStealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CookieStealServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
     }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			response.setContentType("application/json");
			JSONObject result = new JSONObject();
			result.put("message", "We stole your cookies!!! MOUAahahaha");
			response.getWriter().print(result);
	       
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			//request.getRequestDispatcher("index.html").forward(request, response);
		}			
	}
	

}

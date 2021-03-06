package com.lmo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmo.service.RechercherMuseeService;

/**
 * Servlet permettant d'appeler la méthode getListOfMusees de la classe RechercherMuseeService
 * dans le but de chercher un musée dans la bdd
 */
public class RechercherMuseeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RechercherMuseeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	        response.setContentType("application/json");
			if(!request.getParameter ("nom_musee").equals("") )
			{  
				response.getWriter().print(
						RechercherMuseeService.getListOfMusees(request.getParameter ("nom_musee")));
				System.out.println(RechercherMuseeService.getListOfMusees(request.getParameter ("nom_musee")).toString());
			}
			else throw new Exception("Wrong Url! Missing parameters\n Il manque des parametres a l'URL!");
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			//request.getRequestDispatcher("index.html").forward(request, response);
		}	}

}

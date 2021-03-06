package com.lmo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmo.service.AjoutMuseeFavService;

/**
 * Servlet permettant d'envoyer un musée favori à la méthode ajoutFav de la classe AjoutMuseeFavService
 * dans le but de l'ajouter en bdd
 */
public class AjoutMuseeFavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjoutMuseeFavServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			response.setContentType("text/plain");
			if(!request.getParameter("iduser").equals("") && !request.getParameter("idmusee").equals(""))
			{
				response.getWriter().print(AjoutMuseeFavService.ajoutFav(Integer.parseInt(request.getParameter ("iduser")), 
						Integer.parseInt(request.getParameter ("idmusee"))));
			}

			else throw new Exception("Wrong Url! Missing parameters\n Il manque des parametres a l'URL!");
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

}

package com.lmo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmo.service.AfficherMuseesProximite;

/**
 * Servlet permettant de retourner la liste des musées à proximité (en json) d'un musée dont l'identifiant est id_musée
 * en appelant la méthode listProximité de la classe AfficherAffluenceMuseeServic
 */
public class AfficherMuseesProximiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AfficherMuseesProximiteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			response.setContentType("application/json");
			if(!request.getParameter ("id_musee").equals("") )

			{  
				response.getWriter().print(
						AfficherMuseesProximite.listProximite(request.getParameter ("id_musee")));
			}

			else throw new Exception("Wrong Url! Missing parameters\n Il manque des parametres a l'URL!");
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			//request.getRequestDispatcher("index.html").forward(request, response);
		}	
	}
}



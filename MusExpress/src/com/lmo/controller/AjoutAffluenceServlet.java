package com.lmo.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmo.service.AjoutAffluenceService;
import com.lmo.service.AjoutMuseeFavService;

/**
 * Servlet implementation class AjoutMuseefavServlet
 */
public class AjoutAffluenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjoutAffluenceServlet() {
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
			response.setContentType("application/json");

			if(!request.getParameter("id_user").equals("") && !request.getParameter("id_musee").equals("")&&
					!request.getParameter("duree").equals("") && !request.getParameter("text").equals("")&&
					!request.getParameter("emplacement").equals("") /*&& !request.getParameter("date").equals("")*/
					)
				

			{
				response.getWriter().print(AjoutAffluenceService.addAffluence
						(request.getParameter("id_user"),
								request.getParameter("id_musee"),
								request.getParameter("duree"),
								request.getParameter("text"),
								request.getParameter("emplacement")));


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

package com.lmo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lmo.service.InscriptionService;

public class InscriptionServlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Helllooooooo !! ");
		try
	{
		Map<String,String[]> map=request.getParameterMap();
		response.setContentType("text/plain");

		if(   	map.containsKey("password")     && !request.getParameter ("password").equals("")
				&& map.containsKey("nom")	 && !request.getParameter ("nom").equals("")
				&& map.containsKey("prenom")  && !request.getParameter ("prenom").equals("")
				&& map.containsKey("codep")  && !request.getParameter ("codep").equals("")
				&& map.containsKey("email") && !request.getParameter("email").equals("")
		  )
		
		{
	    
		response.getWriter().print(
				InscriptionService.createUser(request.getParameter ("nom"), request.getParameter ("prenom"),
						request.getParameter ("codep"), request.getParameter ("email"),
						request.getParameter("password")
						));
		
		}
		
		else throw new Exception("Wrong Url! Missing parameters\n Il manque des parametres a l'URL!");
	}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			request.getRequestDispatcher("error1.jsp").forward(request, response);
		}
	}
	

}
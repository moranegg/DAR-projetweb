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

//		String nom = request.getParameter("nom");	
//		String prenom = request.getParameter("prenom");	
//		String codep = request.getParameter("codep");	
//		String email = request.getParameter("email");	
//		String password = request.getParameter("user_password");	

		//InscriptionService inscriptionservice = new InscriptionService();
//		boolean result = inscriptionservice.createUser(nom, prenom, codep, email, password);
	    
		response.getWriter().print(
				InscriptionService.createUser(request.getParameter ("nom"), request.getParameter ("prenom"),
						request.getParameter ("codep"), request.getParameter ("email"),
						request.getParameter("password")
						));
		}
		
		else throw new Exception("Wrong Url! Missing parameters\n Il manque des parametres a l'URL!");
	}
//		/** Cas où l'inscription s'est bien faite : rediriger vers la page d'accueil */
//		if(result == true)
//	     {
//	         response.sendRedirect("home.jsp");
//	     }
//	     else
//	     {
//		/** Cas où l'inscription s'est bien faite : rediriger vers une page d'erreur */
//         response.sendRedirect("error1.jsp");
//         }
		
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			request.getRequestDispatcher("error1.jsp").forward(request, response);
		}
	}
	

}
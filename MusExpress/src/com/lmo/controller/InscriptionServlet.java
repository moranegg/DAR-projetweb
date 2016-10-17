package com.lmo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmo.model.User;
import com.lmo.service.InscriptionService;

public class InscriptionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String nom = request.getParameter("nom");	
		String prenom = request.getParameter("prenom");	
		String codep = request.getParameter("codep");	
		String email = request.getParameter("email");	
		String password = request.getParameter("user_password");	





		
		InscriptionService inscriptionservice = new InscriptionService();
		boolean result = inscriptionservice.createUser(nom, prenom, codep, email, password);
	    
		/** Cas où l'inscription s'est bien faite : rediriger vers la page d'accueil */
		if(result == true)
	     {
	         response.sendRedirect("home.jsp");
	     }
	     else
	     {
		/** Cas où l'inscription s'est bien faite : rediriger vers une page d'erreur */
         response.sendRedirect("error1.jsp");
         }
	}

}

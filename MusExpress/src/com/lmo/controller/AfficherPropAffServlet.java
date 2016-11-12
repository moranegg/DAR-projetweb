package com.lmo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmo.service.AfficherPropAffService;

/**
 * Servlet permettant de retourner la liste de propositions par affluences (en json)
 * en appelant la méthode listPropAff de la classe AfficherPropAffService
 */
public class AfficherPropAffServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public AfficherPropAffServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	        response.setContentType("application/json");
			response.getWriter().print(
						AfficherPropAffService.listPropAff());
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			//request.getRequestDispatcher("index.html").forward(request, response);
		}	
}
}

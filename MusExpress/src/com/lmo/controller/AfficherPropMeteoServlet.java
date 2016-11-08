package com.lmo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmo.service.AfficherPropAffService;
import com.lmo.service.AfficherPropMeteoService;

public class AfficherPropMeteoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    

    public AfficherPropMeteoServlet() {
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
						AfficherPropMeteoService.listPropMeteo());
			

		}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			//request.getRequestDispatcher("index.html").forward(request, response);
		}	
	}
}

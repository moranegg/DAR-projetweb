package com.lmo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.lmo.service.ConsulterMuseeService;


public class ConsulterMuseeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
	        response.setContentType("application/json");

			if(!request.getParameter ("id").equals("") )

			{  
				
				response.getWriter().print(
						ConsulterMuseeService.getMusee(request.getParameter ("id")));
				System.out.println(ConsulterMuseeService.getMusee(request.getParameter ("id")).toString());
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
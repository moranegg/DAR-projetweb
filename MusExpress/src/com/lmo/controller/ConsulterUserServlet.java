package com.lmo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmo.service.ConsulterUserService;
import com.lmo.service.UpdateUserService;

public class ConsulterUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
	{
		Map<String,String[]> map=request.getParameterMap();
		response.setContentType("text/plain");
		
		if( map.containsKey("id")   && !request.getParameter ("id").equals("") )
		
		{  
		response.getWriter().print(
				ConsulterUserService.getUser(request.getParameter ("id")));
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

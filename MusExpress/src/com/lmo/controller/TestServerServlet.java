package com.lmo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *This is a test class to test GET and POST from any page
 *
 */
public class TestServerServlet extends HttpServlet {
	 private String message;

	  public void init() throws ServletException
	  {
	      // Do required initialization
	      message = "Hello World";
	  }
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = "Update successfull"; //message you will recieve 
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.println(name + " " + text);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(message);
		 
	}

}
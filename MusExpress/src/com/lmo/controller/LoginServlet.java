package com.lmo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.lmo.model.User;
import com.lmo.service.LoginService;
 

 
 
public class LoginServlet extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
 
    /* String email = request.getParameter("email");   
     String password = request.getParameter("password");

     LoginService loginService = new LoginService();
     boolean result = loginService.authenticateUser(email, password);
     User user = loginService.getUserByUserEmail(email);
     if(result == true)
     {
         request.getSession().setAttribute("user", user);      
         response.sendRedirect("home.jsp");
     }
     else
     {
         response.sendRedirect("error.jsp");
     }*/
    	
    	try 
    	{
           Map<String, String[]> map=request.getParameterMap();
           response.setContentType("text/plain");
           String email = request.getParameter("email");
           String password = request.getParameter("password");
           if (map.containsKey("email") && !email.equals("")
        		   && map.containsKey("password") &&!password.equals(""))
           {
        	     LoginService loginService = new LoginService();
				response.getWriter().print(loginService.authenticateUser(email, password));
				
           }
           
           else 
        	   
           {
        	   throw new Exception("Wrong Url! Missing parameters\n Il manque des parametres à l'URL!");
           }
        		   
    	}
    	
    	catch (Exception e) 
    	{
			e.printStackTrace(); 
			request.setAttribute("error", e); 
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	
    }
}
 

 
package com.lmo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.lmo.dao.UserDao;
import com.lmo.model.User;
import com.lmo.service.LoginService;
 

 
 
public class LoginServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	public LoginServlet() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    	System.out.print(response);
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

           response.setContentType("text/plain");
           String email = request.getParameter("email");
           String password = request.getParameter("password");
            if (!email.equals("") && !password.equals(""))
 

           {
        	     LoginService loginService = new LoginService();
        	     JSONObject jo = loginService.authenticateUser(email, password);
        	     if (!jo.equals("Invalid email or password")) 
        	     {
        	             User user = LoginService.getUserByUserEmail(email);
                         request.getSession().setAttribute("userId", Integer.toString(user.getId())); 
//          				 Cookie cookieId = new Cookie("userId",Integer.toString(user.getId()));
//         				 response.addCookie(cookieId);                        
        				
        	     }
        	     
				 response.getWriter().print(jo);

        	    	 
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
			//request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	
    }
}
 

 
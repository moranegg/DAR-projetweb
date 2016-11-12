package com.lmo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import com.lmo.model.User;
import com.lmo.service.LoginService;



/**
 * Servlet permettant d'appeler la méthode auhentificateUser de la classe LoginService
 * dans le but d'authentifier un utilisateur
 */
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

		try 
		{

			response.setContentType("text/plain");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if (!email.equals("") && !password.equals(""))
			{
				//System.out.println(request.getParameter("email"));
				//System.out.println(request.getParameter("password"));

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
				response.getWriter().print("Wrong Url! Missing parameters\n Il manque des parametres � l'URL!");
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			response.getWriter().print(e);
		}
	}
}



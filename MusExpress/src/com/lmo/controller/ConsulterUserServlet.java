package com.lmo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import com.lmo.service.ConsulterUserService;
import com.lmo.utils.Tools;
/**
 * Servlet permettant de consulter un utilisateur dont l'identifiant est id_user en appelant
 * la méthode getUser de la classe ConsulterUserService
 */
public class ConsulterUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject jo = new JSONObject();	

		try
		{
			Map<String,String[]> map=request.getParameterMap();
			if( map.containsKey("id_user")   && !request.getParameter ("id_user").equals("") )
			{  
				jo = ConsulterUserService.getUser(request.getParameter ("id_user"));


			} else {
				jo = Tools.service("error","Wrong Url! Missing parameters\n Il manque des parametres a l'URL!");
			}

			response.getWriter().print(jo);

		}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			response.getWriter().print(e);
		}
	}
}
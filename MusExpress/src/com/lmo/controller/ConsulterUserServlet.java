package com.lmo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.model.User;
import com.lmo.service.ConsulterUserService;
import com.lmo.service.UpdateUserService;
import com.lmo.utils.Tools;

public class ConsulterUserServlet extends HttpServlet {
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
			if( map.containsKey("id")   && !request.getParameter ("id").equals("") )
			{  
				jo = ConsulterUserService.getUser(request.getParameter ("id"));


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
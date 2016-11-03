package com.lmo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmo.service.AfficherFavorisService;
import com.lmo.service.ConsulterMuseeService;


public class AfficherFavorisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AfficherFavorisServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

			if(!request.getParameter ("id").equals("") )

			{  

				
				response.getWriter().print(
						AfficherFavorisService.listFavoris(request.getParameter ("id")));
				System.out.println(AfficherFavorisService.listFavoris(request.getParameter ("id")).toString());
			}

			else throw new Exception("Wrong Url! Missing parameters\n Il manque des parametres a l'URL!");
		}
		catch (Exception e) 
		{
			e.printStackTrace(); //local debug
			request.setAttribute("error", e); //remote debug
			//request.getRequestDispatcher("index.html").forward(request, response);
		}	}

}

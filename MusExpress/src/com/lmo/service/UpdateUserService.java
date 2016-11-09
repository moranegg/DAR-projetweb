package com.lmo.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.lmo.dao.UserDao;
import com.lmo.model.User;
import com.lmo.utils.Tools;

public class UpdateUserService {
	public static JSONObject updateUser(String id, String nom, String prenom, String codep, String email, String password)
			throws JSONException
	{

		User user = UserDao.getUserById(id);
		User user2 = UserDao.getUserByUserEmail(email);

		if(user!=null)
		{
			if (user2!=null)
			{
				if (user.getId()!=user2.getId()) 
				{
					JSONObject jo = new JSONObject();
					jo.put("message", "Email existant");
					return jo;
				}
				
				else 


				{
					System.out.println("coucou");
					UserDao.updateUser(user, nom, prenom, codep, email, password);
					JSONObject jo = new JSONObject().put("id_user",id);
					jo.put("message", 1);
					return jo;
				}
			}
			
			else 


			{
				System.out.println("coucou");
				UserDao.updateUser(user, nom, prenom, codep, email, password);
				JSONObject jo = new JSONObject().put("id_user",id);
				jo.put("message", 1);
				return jo;
			}

			
		}
		else
		{
			return Tools.serviceMessage("Probl�me !");
			//return false;
		}

	}
}
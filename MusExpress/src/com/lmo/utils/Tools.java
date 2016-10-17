package com.lmo.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class Tools 
{

	
	public static JSONObject serviceMessage(Object msg) throws JSONException
	{
		return new JSONObject().put("message",msg);
	}
}
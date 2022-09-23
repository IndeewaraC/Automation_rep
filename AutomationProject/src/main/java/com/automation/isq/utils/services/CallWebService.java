package com.automation.isq.utils.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public abstract class CallWebService {

	/*
	 * Getters Setters
	 */
	String responseStr;
	public String getResponseStr(){
		return responseStr;
	}
	public void setResponseStr(String string){
		 this.responseStr = string;
	}



	/*
	 * Request
	 */
	public abstract void addHeader(String key, String value) throws Exception;
	public abstract void addParameter(String key, String value) throws Exception;
	public abstract void addBasicAuth(String username, String password) throws Exception;
	public abstract void send() throws Exception;


	/*
	 * Implemented methods
	 */
	public String readResponseAsString() throws Exception {
		return getResponseStr();
	}

	public JSONObject readResponseAsJson() throws Exception {
		JSONObject obj = new JSONObject();

		try {
			obj.put("values", readResponseAsJsonObject());
		} catch (Exception e) {
			try {
				obj.put("values", readResponseAsJsonArray());
			} catch (Exception e1) {
				System.out.print(e1);
				e1.printStackTrace();
			}
		}

		return obj;
	}

	public JSONObject readResponseAsJsonObject() throws Exception {
		JSONParser parser = new JSONParser();
		return (JSONObject) parser.parse(getResponseStr());
	}

	public JSONArray readResponseAsJsonArray() throws Exception {
		JSONParser parser = new JSONParser();
		return (JSONArray) parser.parse(getResponseStr());
	}
}

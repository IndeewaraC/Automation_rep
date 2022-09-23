package com.automation.isq.utils.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import java.util.*;


/**
 * 
 */
public class GETClient extends RestClient {
    /*
     * Properties
     */
    HttpGet get;
    HttpClient client;

    /*
	 * Constructor
	 */
    public GETClient(String url){
        this.get = new HttpGet(url);
        this.client = HttpClientBuilder.create().build();
    }

    @Override
    public void addHeader(String key, String value) {
        this.get.addHeader(key, value);
    }

    @Override
    public void send() throws Exception {
    	HttpResponse response = client.execute(get);
		setResponseStr(RestClient.getStrOfResponse(response));
    }

	@Override
	public void addParameter(String key, String value) throws Exception {
        URIBuilder builder = new URIBuilder(this.get.getURI());
        builder.setParameter(key, value);
        this.get.setURI(builder.build());
    }

	@Override
	public void addBasicAuth(String username, String password) throws Exception {
		byte[] encodedBytes = Base64.getEncoder().encode((username + ":" +password).getBytes());
		addHeader("Authorization", "Basic " + new String(encodedBytes));
	}
}

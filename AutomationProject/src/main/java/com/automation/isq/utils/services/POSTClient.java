package com.automation.isq.utils.services;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class POSTClient extends RestClient {
	/*
	 * Properties
	 */
	HttpPost post;
	HttpClient client;
    List<NameValuePair> parameters = new ArrayList<NameValuePair>();
	
	/*
	 * Constructor
	 */
	public POSTClient(String url) {
		this.post = new HttpPost(url);
		this.client = HttpClientBuilder.create().build();
	}
	

    @Override
	public void addHeader(String key, String value){ post.addHeader(key, value); }

    @Override
    public void addParameter(String key, String value) {
        this.parameters.add(new BasicNameValuePair(key, value));
    }

    @Override
    public void send() throws Exception {
		// to send json
		// StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
		// request.setEntity(params);

        if(parameters.size() > 0)
            this.post.setEntity(new UrlEncodedFormEntity(parameters));
        HttpResponse response = client.execute(this.post);
        setResponseStr(RestClient.getStrOfResponse(response));
    }

	@Override
	public void addBasicAuth(String username, String password) throws Exception {
		String encoding = Base64.encodeBase64((username + ":" + password).getBytes()).toString();
		addHeader("Authorization", "Basic " + encoding);
	}
}

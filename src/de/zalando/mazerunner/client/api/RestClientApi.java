package de.zalando.mazerunner.client.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestClientApi {

	final static String SERVER_URL = "http://localhost:8080";

	/**
	 * Sending a get REST request
	 * 
	 * @param request
	 * @return
	 */
	public static String executeGetRequest(String request) {

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(SERVER_URL + request);
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String line = "";
		StringBuilder responseString = new StringBuilder();
		while ((line = rd.readLine()) != null) {
			responseString.append(line);
		}
		return responseString.toString();
	}

	/**
	 * Sending a POST REST REQUEST
	 */
	public static String executePostRequest(String request, String jsonData) {

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(SERVER_URL + request);
		StringEntity input = new StringEntity(jsonData);
		input.setContentType("application/json");
		post.setEntity(input);
		HttpResponse response = client.execute(post);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String line = "";
		StringBuilder responseString = new StringBuilder();

		while ((line = rd.readLine()) != null) {
			responseString.append(line);
		}

		return responseString.toString();
	}

}

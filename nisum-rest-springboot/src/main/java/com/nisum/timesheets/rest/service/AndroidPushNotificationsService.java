package com.nisum.timesheets.rest.service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

public class AndroidPushNotificationsService {
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String AUTHORIZATION = "Authorization";
	private static final String NOTIFICATION = "notification";
	private static final String BODY = "body";
	private static final String TITLE = "title";
	private static final String PRIORITY = "priority";
	private static final String TO = "to";
	private static final String HIGH = "high";
	private static final String FIREBASE_SERVER_KEY = "AAAAzOsIGS0:APA91bFNdrfKo1K6jRxE2YTkJas9UHd8oTvEIaV7O8DvdCsHC-bi7BHae-hXFmnzXMUrBpmnfE5WKqRrkso8uCXbAES3AaS56QfY77LeJHTP6jBpPYIx-bm_vXlK74cKUnRPVbhXU18t";
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

	@Async
	public CompletableFuture<String> send(RestMessage message) {

		RestTemplate restTemplate = new RestTemplate();

		JSONObject body = new JSONObject();
		JSONObject notification = new JSONObject();
		
		try {
			body.put(TO, message.getTo());
			body.put(PRIORITY, HIGH);

			if (message.getData() != null) {
				notification.put(BODY, message.getData().getMessage());
				notification.put(TITLE, message.getData().getTitle());
			}
			body.put(NOTIFICATION, notification);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HttpEntity<String> entity = new HttpEntity<>(body.toString());

		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor(AUTHORIZATION, "key=" + FIREBASE_SERVER_KEY));
		interceptors.add(new HeaderRequestInterceptor(CONTENT_TYPE, MediaType.APPLICATION_JSON.toString()));
		restTemplate.setInterceptors(interceptors);

		String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}
	
	public static void main(String[] args) {
		AndroidPushNotificationsService androidPushNotificationsService = new AndroidPushNotificationsService();
		RestMessage message = new RestMessage();
		message.setTo("3073f42c6e3d956fed3769cdb93c2fba6301a9d7d0e3d468e597a66bd50fd687");
		RestData data = new RestData();
		data.setMessage("Hello World");
		data.setTitle("Timesheet Notification");
		message.setData(data );
		CompletableFuture<String> pushNotification = androidPushNotificationsService.send(message );
		try {
			System.out.println(pushNotification.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

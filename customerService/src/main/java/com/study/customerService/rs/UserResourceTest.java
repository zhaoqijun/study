package com.study.customerService.rs;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.study.customerService.bean.User;

public class UserResourceTest {

	public static void main(String[] args) {
		//TestQuery();
		
		TestAdd();
	}

	private static void TestQuery() {
		javax.ws.rs.client.Client client = javax.ws.rs.client.ClientBuilder.newClient();

		// Sent HTTP GET request to query customer info
		System.out.println("Sent HTTP GET request to query customer info");
		javax.ws.rs.client.WebTarget target = client.target("http://localhost:8082/ws/users").path("getTextByName/bob");
		String s = target.request(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(s);
		System.out.println("\n");
	}
	
	private static void TestAdd() {
		User user = new User();
		user.setName("SuperMan");
		
		Client client = ClientBuilder.newClient();

		// Sent HTTP GET request to query customer info
		System.out.println("Sent HTTP GET request to query customer info");
		javax.ws.rs.client.WebTarget target = client.target("http://localhost:8082/ws/users").path("addUser");
		Response response = target.request().buildPost(Entity.entity(user, MediaType.APPLICATION_JSON)).invoke();
		
		System.out.println(response.getEntity());
		response.close();
	}
	

}

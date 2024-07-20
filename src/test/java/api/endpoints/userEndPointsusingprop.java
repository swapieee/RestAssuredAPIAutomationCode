package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPointsusingprop {
	
	
	static ResourceBundle getURLs() {
		ResourceBundle routes = ResourceBundle.getBundle("Routes"); // load Routes.properties file
		return routes;
	}	

	public static Response createUser(user payload) {
		
		String postURL = getURLs().getString("post_url");
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)

							.when()
							.post(postURL);

		return response;

	}

	public static Response getUser(String Username) {
		
		String getURL = getURLs().getString("get_url");
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("username", Username)

							.when()
							.get(getURL);

		return response;

	}

	public static Response updateUser(String Username, user payload) {

		String updateURL = getURLs().getString("update_url");
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.pathParam("username", Username).body(payload)
							
							.when()
							.put(updateURL);

		return response;

	}

	public static Response deleteUser(String Username) {

		String deleteURL = getURLs().getString("delete_url");
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("username", Username)

							.when()
							.delete(deleteURL);

		return response;

	}

}

package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {

	public static Response createUser(user payload) {

		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)

							.when()
							.post(Routes.user_post_url);

		return response;

	}

	public static Response getUser(String Username) {

		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("username", Username)

							.when()
							.get(Routes.user_get_url);

		return response;

	}

	public static Response updateUser(String Username, user payload) {

		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.pathParam("username", Username).body(payload)
							
							.when()
							.put(Routes.user_put_url);

		return response;

	}

	public static Response deleteUser(String Username) {

		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("username", Username)

							.when()
							.delete(Routes.user_del_url);

		return response;

	}

}

package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {

	user userPayload;
	
	public static Logger logger = LogManager.getLogger("RestAssuredFramework");

	@Test(priority = 1, dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userID, String userName, String fName, String lName, String eMail,
			String Password, String Phone) {

		logger.info("=====DD - Create User Test Started=====");

		userPayload = new user();

		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstname(fName);
		userPayload.setLastname(lName);
		userPayload.setEmail(eMail);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);

		Response response = userEndPoints.createUser(userPayload);

		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("=====DD - Create User Test Ended=====");
	}

	@Test(priority = 2, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testGetUserData(String username) {

		logger.info("=====DD - Get User Test Started=====");

		Response response = userEndPoints.getUser(username);

		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("=====DD - Get User Test Ended=====");
	}

	@Test(priority = 3, dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testUpdateUser(String userID, String userName, String fName, String lName, String eMail,
			String Password, String Phone) {
		logger.info("=====DD - Update User Test Started=====");
		Response response = null;
		if (userName.equals("user1")) {
			userPayload.setEmail("z@gmail.com");
			response = userEndPoints.updateUser(userName, userPayload);

			// log response
			response.then().log().all();

			// validation
			Assert.assertEquals(response.getStatusCode(), 200);
			
			// Read User Data to check if email is updated
			Response updatedresponse = userEndPoints.getUser(userName);
			updatedresponse.then().log().all();
		}

		logger.info("=====DD - Update User Test Ended=====");
	}

	@Test(priority = 4, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {
		logger.info("=====DD - Delete User Test Started=====");

		Response response = userEndPoints.deleteUser(username);

		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("=====DD - Delete User Test Ended=====");
	}
}

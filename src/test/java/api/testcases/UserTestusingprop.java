 package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.userEndPointsusingprop;
import api.payload.user;
import io.restassured.response.Response;

public class UserTestusingprop {
	
	Faker faker;
	user userPayload;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		userPayload = new user();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());	
		
		logger = LogManager.getLogger("RestAssuredFramework-----");
	}
	
	
	@Test(priority = 1)
	public void testCreateUser() {
		
		logger.info("=====Create User Test Started=====");
		
		Response response = userEndPointsusingprop.createUser(userPayload);
		
		// log response 
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200); 
		logger.info("=====Create User Test Ended=====");
	}
	
	@Test(priority = 2)
	public void testGetUserData() {
		
		logger.info("======Get User Test Started========");
		
		Response response = userEndPointsusingprop.getUser(this.userPayload.getUsername());
		
		// log response 
		response.then().log().all();
		response.body().asString();
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("=====Get User Test Ended=====");
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		logger.info("=====Update User Test Started=====");
		
		userPayload.setEmail(faker.internet().emailAddress());
		Response response = userEndPointsusingprop.updateUser(this.userPayload.getUsername(), userPayload);
		
		// log response 
		response.then().log().all();
		
		// validation
		Assert.assertEquals(response.getStatusCode(), 200);
		
		// Read User Data to check if first name is updated
		Response updatedresponse = userEndPointsusingprop.getUser(this.userPayload.getUsername());
		updatedresponse.then().log().all();
		
		logger.info("=====Update User Test Ended=====");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		logger.info("=====Delete User Test Started=====");
		
		Response response = userEndPointsusingprop.deleteUser(this.userPayload.getUsername());
		
		// log response 
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("=====Delete User Test Ended=====");
	}
}

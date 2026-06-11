package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import api.endpoints.User_Endpoints_from_File_Routes;
import api.endpoints.User_Endpoints_from_Properties;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTTest_FromProperties {
	public Logger logger;
	
	@Test(priority =1, dataProvider="Data", dataProviderClass = DataProviders.class)
	public void testCreateUser(String id, String username, String firstName, String lastName, String email, String password, String phone)
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		//logs
		logger = LogManager.getLogger(this.getClass());
		
		Response response = User_Endpoints_from_Properties.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority =2, dataProvider="UserNames", dataProviderClass = DataProviders.class)
	public void testdeleteUserByName(String username)
	{
		logger.info("Deleting user with username: " + username);
		Response response = User_Endpoints_from_Properties.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}

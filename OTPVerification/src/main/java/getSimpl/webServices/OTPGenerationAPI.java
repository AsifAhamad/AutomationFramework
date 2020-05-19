package getSimpl.webServices;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import getSimpl.base.Base;
import io.restassured.*;
import io.restassured.response.Response;

public class OTPGenerationAPI extends Base{
	
    public String OTPGeneration(String token) {
 
    	//Headers are stored in Map container to pass it to the G
        Map<String,Object> headerMap = new HashMap<String,Object>();
        headerMap.put("X-API-KEY", "key-tobeplaced");
        headerMap.put("Content-Type", "application/json");
        Response response = RestAssured.given()
            .baseUri("https://unicornsimpl.com")
            .basePath("/automation/get_otp")
            .headers(headerMap)
            .queryParam("secret_token", token)
            .get();
 
        Assert.assertEquals(response.getStatusCode(), 200);
        
        //Extracting the OTP from JSON response message
        String otp = response.getBody().jsonPath().getString("otp");
        
        return otp;
    }
}

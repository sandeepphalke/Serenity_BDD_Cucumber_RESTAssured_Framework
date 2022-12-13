package steps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CommonSteps {
	
	public static Response res;
	public static RequestSpecification resSpe;
	
	
	@Step
	public Response getRequest(String URL){
		
		res = SerenityRest
				.given()
				.urlEncodingEnabled(false)
				.baseUri(URL)
				.log()
				.all()
				.when()
				.get();
		
		return res;
	}
	
	@Step
	public Response postRequest(){
		
		res = resSpe
				.log()
				.all()
				.post();
		
		return res;
	}

	@Step
	public void validateStatusCode(String statusCode){
		Assert.assertEquals(statusCode, String.valueOf(res.getStatusCode()));
	}
	
	@Step
	public void compareResponse(String key, String value){
		System.out.println(res.then().extract().body().asString());
		new JSONObject(res.then().extract().body().asString()).get(key).equals(value);
	}
	
	public void setHeader(String URL, String key, String value) throws IOException {
		
		resSpe = SerenityRest
					.given()
					.urlEncodingEnabled(false)
					.baseUri(URL)
					.header(key, value)
					.log()
					.all();
	}

	public void setBody(String fileName) throws IOException {
		
		String requestBody = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\src\\test\\resources\\RequestFiles\\"+fileName+".txt")));
		
					resSpe 
					.body(requestBody)
					.when();
	}
}

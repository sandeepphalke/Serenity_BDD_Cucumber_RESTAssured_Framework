package steps;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test {
	
	
	
	

	public static void main(String[] args) throws IOException {
		
		
		
		
		String a = "{\r\n"
				+ "    \"name\": \"testh\",\r\n"
				+ "    \"salary\": \"123\",\r\n"
				+ "    \"age\": \"23\"\r\n"
				+ "}";
		
		

		
		RequestSpecification res = given()
				.baseUri(util.URI.EMPLOYEE+util.Actions.CREATE)
				.header("Content-Type", "application/json")
				.log()
				.all()
				.body(a);

Response response = res.when()
					.post();

String responseBody = response.then().log().all().extract().body().asString();

System.out.println(responseBody);

JSONObject array = new JSONObject(responseBody);  

//JSONArray a = new JSONArray(String.valueOf(array.get("data")));
//
//System.out.println((a.getJSONObject(0)).getString("employee_name"));
//System.out.println((a.getJSONObject(5)).getString("employee_name"));


System.out.println(response.getStatusCode());
System.out.println(array.get("status"));
System.out.println(array.get("message"));
	}

}

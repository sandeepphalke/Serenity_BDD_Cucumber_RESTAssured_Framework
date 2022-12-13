package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.CommonSteps;
import util.Actions;
import util.URI;

public class CreateEmployeeDefinitions {
	
	@Steps
	CommonSteps cs;
	
	@Given("User set the request body as {string}")
	public void user_set_the_request_body(String fileName) throws IOException {
	    
		cs.setBody(fileName);
	}

	@When("User create an employee")
	public void user_create_an_employee() {
	    
		cs.postRequest();
	}
	
	@Given("User set the header {string} as {string}")
	public void user_set_the_header_as(String key, String value) throws IOException {

		cs.setHeader(URI.EMPLOYEE+Actions.CREATE, key, value);
	}

}

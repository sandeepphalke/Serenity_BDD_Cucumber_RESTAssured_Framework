package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import steps.CommonSteps;
import util.URI;

public class GetEmployeesDefinitions {
	
	@Steps
	CommonSteps cs;
	
	@And("User get {string} as {string} in response body")
	public void user_get_as_in_response_body(String key, String value) {
	    
		cs.compareResponse(key, value);
	}

	@Given("User get all employee")
	public void user_get_all_employee() {
	    
		cs.getRequest(URI.ALL_EMPLOYEE);
	}

	@Then("User get status code as {string}")
	public void user_get_status_code_as(String statusCode) {
	    
		cs.validateStatusCode(statusCode);
	}
}

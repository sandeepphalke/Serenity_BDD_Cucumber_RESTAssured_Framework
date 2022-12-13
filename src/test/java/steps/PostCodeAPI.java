package steps;

import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostCodeAPI {

    

    @Step("Get location by postcode {0} in country {1}")
    public void fetchLocationByPostCodeAndCountry(String postcode, String country) {
    	SerenityRest.given()
                .pathParam("postcode", postcode)
                .pathParam("country", country)
                .queryParam(country, "test")
                .get(util.URI.LOCATION_BY_POST_CODE_AND_COUNTRY);
    }
}

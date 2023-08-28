package PatternsJSON;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClient {

    private static final String BASE_URL = "/api/v1/courier";
    private static final String BASE_URL_LOGIN = "/api/v1/courier/login";



    public Response create(JCourier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(BASE_URL);
    }

    public Response login(CourierCreds creds) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(creds)
                .when()
                .post(BASE_URL_LOGIN);
    }

    public Response sameLoginCreate(CourierCreds same){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(same)
                .when()
                .post(BASE_URL);
    }
}

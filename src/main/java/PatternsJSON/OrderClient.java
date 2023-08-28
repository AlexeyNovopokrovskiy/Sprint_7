package PatternsJSON;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderClient {


    private static final String BASE_URL = "/api/v1/orders";

    public Response createOrder(JOrders orders) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(orders)
                .when()
                .post(BASE_URL);
    }

    public Response getAllOrders() {
        return given()
                .get(BASE_URL)
                ;
    }


}

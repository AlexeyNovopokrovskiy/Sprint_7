package PatternsJSON;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;

public class JCourierLoginTest {

    private static final String BASE_URI = "https://qa-scooter.praktikum-services.ru";


    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void courierLogin(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();
        Response response = courierClient.create(courier);
        Response courierLogin = courierClient.login(CourierCreds.credsFrom(courier));
        assertEquals(200, courierLogin.statusCode());
        courierLogin.then().assertThat().body(startsWith("{\"id\""));
        //System.out.println(courierLogin.asString());
    }

    @Test
    public void courierWrongLogin(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();
        Response response = courierClient.create(courier);
        Response courierLogin = courierClient.login(CourierCreds.credsChangedLogin(courier));
        assertEquals(404, courierLogin.statusCode());
    }

    @Test
    public void courierWrongPassword(){

        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();
        Response response = courierClient.create(courier);
        Response courierLogin = courierClient.login(CourierCreds.credsChangedPassword(courier));
        assertEquals(404, courierLogin.statusCode());

    }

    @Test
    public void courierNullifiedLogin(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();
        Response response = courierClient.create(courier);
        Response courierLogin = courierClient.login(CourierCreds.credsNullifiedLogin(courier));
        assertEquals(400, courierLogin.statusCode());
    }

    @Test
    public void courierNullifiedPassword(){

        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();
        Response response = courierClient.create(courier);
        Response courierLogin = courierClient.login(CourierCreds.credsNullifiedPassword(courier));
        assertEquals(400, courierLogin.statusCode());

    }

    @Test
    public void courietNotExists(){
        CourierClient courierClient = new CourierClient();
        Response courierLogin = courierClient.login(CourierCreds.randomCourierGet());
        assertEquals(404, courierLogin.statusCode());
    }

}
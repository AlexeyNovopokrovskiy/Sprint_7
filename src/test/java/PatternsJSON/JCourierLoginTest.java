package PatternsJSON;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
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

        Response courierDelete = courierClient.deleteCourier(courierLogin.as(JCourier.class).getId());
        assertEquals(courierDelete.statusCode(),200);


    }

    @Test
    public void courierWrongLogin(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();
        Response response = courierClient.create(courier);
        Response courierLogin = courierClient.login(CourierCreds.credsChangedLogin(courier));
        assertEquals(404, courierLogin.statusCode());

        Response courierLoginToGetId = courierClient.login(CourierCreds.credsFrom(courier));
        Response courierDelete = courierClient.deleteCourier(courierLoginToGetId.as(JCourier.class).getId());
        assertEquals(courierDelete.statusCode(),200);
    }

    @Test
    public void courierWrongPassword(){

        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();
        Response response = courierClient.create(courier);
        Response courierLogin = courierClient.login(CourierCreds.credsChangedPassword(courier));
        assertEquals(404, courierLogin.statusCode());

        Response courierLoginToGetId = courierClient.login(CourierCreds.credsFrom(courier));
        Response courierDelete = courierClient.deleteCourier(courierLoginToGetId.as(JCourier.class).getId());
        assertEquals(courierDelete.statusCode(),200);

    }

    @Test
    public void courierNullifiedLogin(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();
        Response response = courierClient.create(courier);
        Response courierLogin = courierClient.login(CourierCreds.credsNullifiedLogin(courier));
        assertEquals(400, courierLogin.statusCode());

        Response courierLoginToGetId = courierClient.login(CourierCreds.credsFrom(courier));
        Response courierDelete = courierClient.deleteCourier(courierLoginToGetId.as(JCourier.class).getId());
        assertEquals(courierDelete.statusCode(),200);
    }

    @Test
    public void courierNullifiedPassword(){

        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();
        Response response = courierClient.create(courier);
        Response courierLogin = courierClient.login(CourierCreds.credsNullifiedPassword(courier));
        assertEquals(400, courierLogin.statusCode());

        Response courierLoginToGetId = courierClient.login(CourierCreds.credsFrom(courier));
        Response courierDelete = courierClient.deleteCourier(courierLoginToGetId.as(JCourier.class).getId());
        assertEquals(courierDelete.statusCode(),200);

    }

    @Test
    public void courietNotExists(){
        CourierClient courierClient = new CourierClient();
        Response courierLogin = courierClient.login(CourierCreds.randomCourierGet());
        assertEquals(404, courierLogin.statusCode());
    }

}
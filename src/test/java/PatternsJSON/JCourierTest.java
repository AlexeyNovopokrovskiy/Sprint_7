package PatternsJSON;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class JCourierTest {

    private static final String BASE_URI = "https://qa-scooter.praktikum-services.ru";


    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void courierCreate(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();

        Response response = courierClient.create(courier);

        assertEquals(201, response.statusCode());
        response.then().assertThat().body("ok",equalTo(true));
        Response courierLogin = courierClient.login(CourierCreds.credsFrom(courier));
        assertEquals(200, courierLogin.statusCode());

        Response courierLoginToGetId = courierClient.login(CourierCreds.credsFrom(courier));
        Response courierDelete = courierClient.deleteCourier(courierLoginToGetId.as(JCourier.class).getId());
        assertEquals(courierDelete.statusCode(),200);
    }

    @Test
    public void courierSameCouriersCreate(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();

        Response response = courierClient.create(courier);
        Response response2 = courierClient.sameLoginCreate(CourierCreds.credsFromCreate(courier));

        assertEquals(409, response2.statusCode());
        Response courierLogin = courierClient.login(CourierCreds.credsFrom(courier));
        assertEquals(200, courierLogin.statusCode());

        Response courierLoginToGetId = courierClient.login(CourierCreds.credsFrom(courier));
        Response courierDelete = courierClient.deleteCourier(courierLoginToGetId.as(JCourier.class).getId());
        assertEquals(courierDelete.statusCode(),200);

    }

    @Test
    public void courierSameLoginsCreate(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourier();

        Response response = courierClient.create(courier);
        Response response2 = courierClient.create(courier);

        assertEquals(409, response2.statusCode());
        Response courierLogin = courierClient.login(CourierCreds.credsFrom(courier));
        assertEquals(200, courierLogin.statusCode());

        Response courierLoginToGetId = courierClient.login(CourierCreds.credsFrom(courier));
        Response courierDelete = courierClient.deleteCourier(courierLoginToGetId.as(JCourier.class).getId());
        assertEquals(courierDelete.statusCode(),200);

    }

    @Test
    public void courierNoLoginCreate(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourierNoLogin();
        Response response = courierClient.create(courier);
        assertEquals(400, response.statusCode());
    }

    @Test
    public void courierNoPasswordCreate(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourierNoPassword();
        Response response = courierClient.create(courier);
        assertEquals(400, response.statusCode());
    }

    @Test (expected = AssertionError.class)
    public void courierNoFirstNameCreate(){
        CourierClient courierClient = new CourierClient();
        JCourier courier = CourierGenerator.randomCourierNoFirstName();
        Response response = courierClient.create(courier);
        assertEquals(400, response.statusCode());
    }

}
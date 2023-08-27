package PatternsJSON;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class JCourierTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Test
    public void courierCreate(){
        JCourier courier = new JCourier("narutouzumaki", "test", "naruto");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");

        assertEquals(201, response.statusCode());

    }


    @Test
    public void courierSameCreate(){
        JCourier courier = new JCourier("narutouzumaki", "test", "naruto");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");

        assertEquals(409, response.statusCode());

    }

    @Test
    public void courierNoLoginCreate(){
        JCourier courier = new JCourier("", "test", "naruto");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");

        assertEquals(400, response.statusCode());

    }

    @Test
    public void courierNoPasswordCreate(){
        JCourier courier = new JCourier("saskeuchiha", "", "saske");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");

        assertEquals(400, response.statusCode());

    }

    @Test //либо firstName необязательный, либо ошибка отловлена. в документации не указано что оно обязательное
    public void courierNoFirstNameCreate(){
        JCourier courier = new JCourier("sakuraharuno", "test", "");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier");

        assertEquals(400, response.statusCode());

    }


}
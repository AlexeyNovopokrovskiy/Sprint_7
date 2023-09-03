package PatternsJSON;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class JOrdersTest {

    private static final String BASE_URI = "https://qa-scooter.praktikum-services.ru";


    @Parameterized.Parameter
    public String[] color;


    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] param() {
         String[] a = {"BLACK"};
         String[] b = {"GREY"};
         String[] c = {"BLACK","GREY"};

        return new Object[][]{
                {a},
                {b},
                {c}
        };
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void createOrderWithoutColor(){

        OrderClient orderClient = new OrderClient();
        JOrders order = OrderGenerator.orderNew();
        Response orderResponse = orderClient.createOrder(order);
        assertEquals(201, orderResponse.statusCode());
    }

    @Test
    public void createOrderWithColor(){

        OrderClient orderClient = new OrderClient();
        JOrders order = OrderGenerator.orders(color);
        Response orderResponse = orderClient.createOrder(order);
        assertEquals(201, orderResponse.statusCode());
        orderResponse.then().assertThat().body(startsWith("{\"track\""));
    }

    @Test
    public void getOrders(){
        OrderClient orderClient = new OrderClient();
        Response response = orderClient.getAllOrders();
        assertEquals(200,response.statusCode());
    }
}
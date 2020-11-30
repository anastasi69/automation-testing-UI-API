package tests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.junit.Test;

public class TestsGET {
    @Test
    public void getPurchaseOrderByID5(){

        given().get("https://petstore.swagger.io/v2/store/order/5").
                then().statusCode(200).
                and().body("id", equalTo(5));
    }

    @Test
    public void getPurchaseOrderByID13Negative(){

        given().get("https://petstore.swagger.io/v2/store/order/13").
                then().statusCode(404).
                and().body("type", equalTo("error"));

    }

    @Test
    public void getPurchaseOrderByID50(){
        given().get("https://petstore.swagger.io/v2/store/order/50").
                then().statusCode(200).
                and().body("id", equalTo(50)).
                and().body("petId", equalTo(0)).
                and().body("quantity", equalTo(0)).
                and().body("shipDate", equalTo("2020-09-28T01:51:39.193+0000")).
                and().body("status", equalTo("placed")).
                and().body("complete", equalTo(true));

    }
}
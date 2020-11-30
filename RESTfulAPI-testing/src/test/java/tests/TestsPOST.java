package tests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.junit.Test;

public class TestsPOST {
    @Test
    public void createOrderWithID13() {
        JSONObject request = new JSONObject();
        request.put("id", 13);
        request.put("petId", 12);
        request.put("quantity", 3);
        request.put("shipDate", "");
        request.put("status", "placed");
        request.put("complete", "false");

        given().header("Content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request).
                when().post("https://petstore.swagger.io/v2/store/order").
                then().statusCode(200);
    }

    @Test
    public void createOrderWithID0() {
        JSONObject request = new JSONObject();
        request.put("id", 0);
        request.put("petId", 1);
        request.put("quantity", 5);
        request.put("shipDate", "2020-11-30T14:50:37.541Z");
        request.put("status", "placed");
        request.put("complete", false);

        given().header("Content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request).
                when().post("https://petstore.swagger.io/v2/store/order").
                then().statusCode(200).
                body("id", not(hasValue(0)));
    }

    @Test
    public void createOrderWithIncorrectStatus() {
        JSONObject request = new JSONObject();
        request.put("id", 12);
        request.put("petId", 4);
        request.put("quantity", 1);
        request.put("shipDate", "2020-11-30T14:50:37.541Z");
        request.put("status", "places");
        request.put("complete", true);

        given().header("Content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request).
                when().post("https://petstore.swagger.io/v2/store/order").
                then().statusCode(200).
                body("status", equalTo(null));
    }
}

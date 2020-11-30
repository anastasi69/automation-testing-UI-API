package tests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.junit.Test;

public class TestsDELETE {
    @Test
    public void deleteExistedOrderWithID11() {
        given().header("Content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().delete("https://petstore.swagger.io/v2/store/order/11").
                then().statusCode(200).
                and().body("type", equalTo("unknown")).
                and().body("message", equalTo("11"));
    }

    @Test
    public void deleteNonexistentOrderWithID6() {
        given().header("Content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().delete("https://petstore.swagger.io/v2/store/order/6").
                then().statusCode(404);
    }

}

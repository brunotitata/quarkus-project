package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.acme.service.Climate;
import org.acme.service.OpenWeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ExampleResourceTest {

    @Autowired
    private OpenWeatherService service;

    @Test
    public void testHelloEndpoint() {
        given().when().get("/hello").then().statusCode(200).body(is("hello"));
    }

    @Test
    public void getTemperatureByCity() {
        Climate temperatureByCity = service.getTemperatureByCity("22.81", "-82.2");

        System.out.println(temperatureByCity);
    }

}
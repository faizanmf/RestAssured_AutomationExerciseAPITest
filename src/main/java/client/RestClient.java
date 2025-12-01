package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestClient {

    public Response get(String endpoint) {
        return RestAssured
                .given()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }


    public Response post(String endpoint, Object body) {
        return RestAssured
                .given()
                .spec(RestAssured.requestSpecification)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response put(String endpoint, Object body) {
        return RestAssured
                .given()
                .spec(RestAssured.requestSpecification)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response delete(String endpoint) {
        return RestAssured
                .given()
                .spec(RestAssured.requestSpecification)
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

}

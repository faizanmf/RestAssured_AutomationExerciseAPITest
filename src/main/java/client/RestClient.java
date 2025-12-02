package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

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


    public Response postDynamic(String endpoint,
                                Map<String, String> headers,
                                Object body,
                                Map<String, ?> formParams,
                                String contentType) {

        RequestSpecification req = RestAssured.given().spec(RestAssured.requestSpecification);

        if (headers != null)
            req.headers(headers);

        if (body != null)
            req.body(body);

        if (formParams != null)
            req.formParams(formParams);

        if (contentType != null)
            req.contentType(contentType);

        return req
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response deleteDynamic(String endpoint,
                                Map<String, String> headers,
                                Object body,
                                Map<String, ?> formParams,
                                String contentType) {

        RequestSpecification req = RestAssured.given().spec(RestAssured.requestSpecification);

        if (headers != null)
            req.headers(headers);

        if (body != null)
            req.body(body);

        if (formParams != null)
            req.formParams(formParams);

        if (contentType != null)
            req.contentType(contentType);

        return req
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getDynamic(String endpoint,
                                  Map<String, String> headers,
                                  Object body,
                                  Map<String, ?> formParams,
                                  String contentType) {

        RequestSpecification req = RestAssured.given().spec(RestAssured.requestSpecification);

        if (headers != null)
            req.headers(headers);

        if (body != null)
            req.body(body);

        if (formParams != null)
            req.formParams(formParams);

        if (contentType != null)
            req.contentType(contentType);

        return req
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response putDynamic(String endpoint,
                                Map<String, String> headers,
                                Object body,
                                Map<String, ?> formParams,
                                String contentType) {

        RequestSpecification req = RestAssured.given().spec(RestAssured.requestSpecification);

        if (headers != null)
            req.headers(headers);

        if (body != null)
            req.body(body);

        if (formParams != null)
            req.formParams(formParams);

        if (contentType != null)
            req.contentType(contentType);

        return req
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

}

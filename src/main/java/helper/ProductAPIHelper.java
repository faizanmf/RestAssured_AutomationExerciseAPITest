package helper;

import base.RequestSpec;
import client.RestClient;
import constants.APIEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProductAPIHelper {

    private final RestClient client = new RestClient();

    public Response getAllProducts() {
        return client.get(APIEndpoints.GET_ALL_PRODUCTS);
    }

    public Response postAllProducts()
    {
        return client.post(APIEndpoints.POST_ALL_PRODUCTS, "");
    }

}

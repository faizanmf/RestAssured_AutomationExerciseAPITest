package helper;

import client.RestClient;
import constants.APIEndpoints;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ProductAPIHelper  {

    private final RestClient client = new RestClient();

    public Response getAllProducts() {
        return client.get(APIEndpoints.GET_ALL_PRODUCTS);
    }

    public Response postAllProducts()
    {
        return client.post(APIEndpoints.POST_ALL_PRODUCTS, "");
    }

    public Response getAllBrands()
    {
       return client.get(APIEndpoints.GET_ALL_BRANDS);
    }

    public Response putAllBrands()
    {
        return client.put(APIEndpoints.PUT_ALL_BRANDS, "");
    }


    public Response postSearchProduct()
    {
        Map<String, Object> formParams = new HashMap<>();
        formParams.put("search_product", "tshirt");


        return client.postDynamic(APIEndpoints.POST_SEARCH_PRODUCT,
                null,
                null,
                formParams,
                "application/x-www-form-urlencoded");
    }

    public Response postSearchProductWithoutParameter()
    {
        return client.postDynamic(APIEndpoints.POST_SEARCH_PRODUCT, null, null, null, null);
    }

    public Response postLoginWithDetails()
    {
        Map<String, Object> LoginformParams = new HashMap<>();
        LoginformParams.put("email", "faizanmf.5252@gmail.com");
        LoginformParams.put("password", "Test@123");


        return client.postDynamic(APIEndpoints.POST_Login,
                null,
                null,
                LoginformParams,
                "application/x-www-form-urlencoded");
    }

    public Response postLoginWithoutEmail()
    {
        Map<String, Object> LoginformParams = new HashMap<>();
        LoginformParams.put("password", "Test@123");


        return client.postDynamic(APIEndpoints.POST_Login,
                null,
                null,
                LoginformParams,
                "application/x-www-form-urlencoded");
    }


}

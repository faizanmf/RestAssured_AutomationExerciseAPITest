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

    public Response deleteLogin()
    {
       return client.delete(APIEndpoints.POST_Login);
    }

    public Response verifyLoginInvalidDetails()
    {
        Map<String, Object> LoginformParams = new HashMap<>();
        LoginformParams.put("email", "faizanmf.5252");
        LoginformParams.put("password", "Test@123");


        return client.postDynamic(APIEndpoints.POST_Login,
                null,
                null,
                LoginformParams,
                "application/x-www-form-urlencoded");
    }

    public Response POSTCreateUserAcc()
    {
        Map<String, Object> Createform = new HashMap<>();
        Createform.put("name", "Faizan");
        Createform.put("email", "faizan123@example.com");
        Createform.put("password", "Password123");
        Createform.put("title", "Mr");
        Createform.put("birth_date", "10");
        Createform.put("birth_month", "12");
        Createform.put("birth_year", "1990");
        Createform.put("firstname", "Faizan");
        Createform.put("lastname", "MF");
        Createform.put("company", "ABC Corp");
        Createform.put("address1", "Street 1");
        Createform.put("address2", "Street 2");
        Createform.put("country", "India");
        Createform.put("zipcode", "560001");
        Createform.put("state", "Karnataka");
        Createform.put("city", "Bangalore");
        Createform.put("mobile_number", "9999999999");


        return client.postDynamic(APIEndpoints.POST_CREATE_ACCOUNT,
                null,
                null,
                Createform,
                "application/x-www-form-urlencoded");
    }

    public Response deleteUserAccount()
    {
        Map<String, Object> deleteformParams = new HashMap<>();
        deleteformParams.put("email", "faizan123@example.com");
        deleteformParams.put("password", "Password123");


        return client.deleteDynamic(APIEndpoints.DELETE_ACCOUNT,
                null,
                null,
                deleteformParams,
                "application/x-www-form-urlencoded");
    }

    public Response updateUserAccount()
    {
        Map<String, Object> updateForm = new HashMap<>();
        updateForm.put("name", "safa");
        updateForm.put("email", "faizan123@example.com");
        updateForm.put("password", "Password@123");
        updateForm.put("title", "Mr");
        updateForm.put("birth_date", "11");
        updateForm.put("birth_month", "1");
        updateForm.put("birth_year", "1999");
        updateForm.put("firstname", "safa");
        updateForm.put("lastname", "bakes");
        updateForm.put("company", "xyz Corp");
        updateForm.put("address1", "Street 11");
        updateForm.put("address2", "Street 21");
        updateForm.put("country", "US");
        updateForm.put("zipcode", "560002");
        updateForm.put("state", "Ohio");
        updateForm.put("city", "Cleveland");
        updateForm.put("mobile_number", "1111111111");


        return client.putDynamic(APIEndpoints.UPDATE_ACCOUNT,
                null,
                null,
                updateForm,
                ""
                );
    }

    public Response getDeletedUserDetail()
    {
        Map<String, Object> deletedUserFormParams = new HashMap<>();
        deletedUserFormParams.put("email", "faizan123@example.com");



        return client.getDynamic(APIEndpoints.DELETED_USER_ACCOUNT,
                null,
                null,
                deletedUserFormParams,
                "application/x-www-form-urlencoded");
    }


}

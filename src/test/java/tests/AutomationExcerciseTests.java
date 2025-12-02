package tests;

import base.BaseTest;
import helper.ProductAPIHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class AutomationExcerciseTests extends BaseTest {

    private final ProductAPIHelper productAPI = new ProductAPIHelper();
    public Response res;

    @Test
    public void verifyAllProductsAPI() {

        res = productAPI.getAllProducts();
        Assert.assertEquals(res.getStatusCode(), 200, "Status code mismatch!");
        int productCount = res.jsonPath().getList("products").size();
        Assert.assertTrue(productCount > 0, "Products list should not be empty");
    }

    @Test
    public void POSTToAllProductsList() {
        res = productAPI.postAllProducts();
        Assert.assertEquals(res.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(res.jsonPath().getInt("responseCode"), 405);
        Assert.assertEquals(res.jsonPath().getString("message"), "This request method is not supported.");
    }

    @Test
    public void GETallBrands() {
        res = productAPI.getAllBrands();
        Assert.assertEquals(res.getStatusCode(), 200, "Status code mismatch!");
        int productCount = res.jsonPath().getList("brands").size();
        Assert.assertTrue(productCount > 0, "Products list should not be empty");
    }

    @Test
    public void PUTallBrands() {
        res = productAPI.putAllBrands();
        Assert.assertEquals(res.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(res.jsonPath().getInt("responseCode"), 405);
        Assert.assertEquals(res.jsonPath().getString("message"), "This request method is not supported.");
    }

    @Test
    public void POSTtoSearchProduct() {
        res = productAPI.postSearchProduct();
        Assert.assertEquals(res.getStatusCode(), 200, "Status code mismatch!");

        List<Map<String, Object>> products = res.jsonPath().getList("products");
        Assert.assertTrue(products.size() > 0, "Products list is empty!");
    }

    @Test
    public void POSTSearchProductWithoutParameter() {
        res = productAPI.postSearchProductWithoutParameter();
        Assert.assertEquals(res.getStatusCode(), 200, "Status code mismatch!");

        Assert.assertEquals(res.jsonPath().getInt("responseCode"), 400);
        Assert.assertEquals(res.jsonPath().getString("message"), "Bad request, search_product parameter is missing in POST request.");
    }

    @Test
    public void POSTVerifyLogin()
    {
        res = productAPI.postLoginWithDetails();
        Assert.assertEquals(res.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(res.jsonPath().getString("message"), "User exists!");
    }

    @Test
    public void POSTVerifyLoginWithoutEmail()
    {
        res = productAPI.postLoginWithoutEmail();
        Assert.assertEquals(res.jsonPath().getInt("responseCode"), 400);
        Assert.assertEquals(res.jsonPath().getString("message"), "Bad request, email or password parameter is missing in POST request.");
    }
}

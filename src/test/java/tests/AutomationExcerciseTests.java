package tests;

import base.BaseTest;
import helper.ProductAPIHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationExcerciseTests extends BaseTest {

    private final ProductAPIHelper productAPI = new ProductAPIHelper();

    @Test
    public void verifyAllProductsAPI() {

        Response response = productAPI.getAllProducts();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        int productCount = response.jsonPath().getList("products").size();
        Assert.assertTrue(productCount > 0, "Products list should not be empty");
    }

    @Test
    public void POSTToAllProductsList()
    {
            Response res = productAPI.postAllProducts();
        Assert.assertEquals(res.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertEquals(res.jsonPath().getInt("responseCode"), 405);
        Assert.assertEquals(res.jsonPath().getString("message"),
                "This request method is not supported.");
    }
}

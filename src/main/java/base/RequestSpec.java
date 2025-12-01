package base;

import config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.filter.log.LogDetail.ALL;

public class RequestSpec {

    public static RequestSpecification getRequestSpec() {
        String uri = ConfigManager.get("baseUri");
        String path = ConfigManager.get("basePath");
        System.out.println("Base URI: " + uri);
        System.out.println("Base Path: " + path);

        if (uri == null || path == null) {
            throw new RuntimeException("Base URI or Base Path is null. Check config.properties!");
        }

        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setBasePath(path)
                .addHeader("Content-Type", "application/json")
                .log(ALL)
                .build();
    }

}

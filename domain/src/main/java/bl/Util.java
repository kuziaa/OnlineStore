package bl;

import entity.Category;
import entity.Product;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Util {

    protected final String BASE_URL = "http://localhost:8080";
    protected final String PRODUCTS = "/products";
    protected final String CATEGORIES = "/categories";
    protected final String CART = "/cart";

    private final String LOGIN = "anton";
    private final String PASSWORD = "anton";

    private final Map<String, String> headers = new HashMap<>();

    {
        headers.put("content-type", "application/json");
    }

    public RequestSpecification getRequestSpecification() {

        RequestSpecification requestSpecification =
                given()
                    .auth()
                    .basic(LOGIN, PASSWORD)
                    .headers(headers);

        return requestSpecification;
    }

    public RequestSpecification getRequestSpecification(Product product) {

        RequestSpecification requestSpecification =
                given()
                        .auth()
                        .basic(LOGIN, PASSWORD)
                        .headers(headers)
                        .body(product);

        return requestSpecification;
    }

    public RequestSpecification getRequestSpecification(Category category) {

        RequestSpecification requestSpecification =
                given()
                        .auth()
                        .basic(LOGIN, PASSWORD)
                        .headers(headers)
                        .body(category);

        return requestSpecification;
    }

}

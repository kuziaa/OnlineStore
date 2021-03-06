package service;

import bl.Util;
import dao.ProductDAO;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import entity.Product;

import java.util.Arrays;
import java.util.List;

public class ProductService extends Util implements ProductDAO {

    @Override
    public List<Product> getAll() {

        Response response = getRequestSpecification()
                .get(BASE_URL + PRODUCTS);

        List<Product> products = Arrays.asList(response.getBody().as(Product[].class));
        return products;
    }

    @Override
    public String add(Product product) {

        RequestSpecification requestSpecification = getRequestSpecification(product);
        String msg = requestSpecification
                .post(BASE_URL + PRODUCTS).getBody().asString();

        return msg;
    }

}

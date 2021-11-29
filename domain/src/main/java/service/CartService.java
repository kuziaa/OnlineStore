package service;

import bl.Util;
import dao.CartDAO;
import entity.Product;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.List;

public class CartService extends Util implements CartDAO {

    @Override
    public List<Product> getProductsFromCart() {
        Response response = getRequestSpecification()
                .get(BASE_URL + CART);

        List<Product> products = Arrays.asList(response.getBody().as(Product[].class));
        return products;
    }

    @Override
    public void addProductToCart(Product product) {

        RequestSpecification requestSpecification = getRequestSpecification(product);
        requestSpecification
                .post(BASE_URL + CART);
    }

    public void cleanCart() {
        getRequestSpecification()
                .delete(BASE_URL + CART);
    }
}

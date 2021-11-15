package dao;

import entity.Product;

import java.util.List;

public interface CartDAO {

    //read
    List<Product> getProductsFromCart();

    //create
    void addProductToCart(Product product);

    //delete
    void cleanCart();
}

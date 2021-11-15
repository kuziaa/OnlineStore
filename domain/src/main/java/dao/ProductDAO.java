package dao;

import entity.Product;

import java.util.List;

public interface ProductDAO {

    //read
    List<Product> getAll();

    //create
    String add(Product product);

}

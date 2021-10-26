package dao;

import category.CategoryName;
import product.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    //create
    void add(Product product) throws SQLException;

    //read
    List<Product> getAll() throws SQLException;

    Product getById(int id) throws SQLException;

    Product getByName(String productName) throws SQLException;

    List<Product> getAllByCategoryName(CategoryName categoryName) throws SQLException;

    //update
    void update(Product product) throws SQLException;

    //delete
    void delete(Product product) throws SQLException;

}

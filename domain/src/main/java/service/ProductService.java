package service;

import bl.Util;
import category.Category;
import category.CategoryName;
import dao.ProductDAO;
import product.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService extends Util implements ProductDAO {

    @Override
    public void add(Product product) {

        String sql = "INSERT INTO PRODUCTS (NAME, PRICE, RATE, CATEGORY_ID) VALUES(?, ?, ?, ?)";

        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getRate());
            preparedStatement.setInt(4, product.getCategory_id());

            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.printf("Product %s already exist in db", product.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS";

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Product product = new Product();
                product.setProductId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setRate(resultSet.getDouble("RATE"));
                product.setCategoryId(resultSet.getInt("CATEGORY_ID"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getById(int id) {

        String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
        Product product = null;

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = new Product();
                product.setProductId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setRate(resultSet.getDouble("RATE"));
                product.setCategoryId(resultSet.getInt("CATEGORY_ID"));
            } else {
                System.out.printf("There is no product with id: %d", id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product getByName(String productName) {

        String sql = "SELECT * FROM PRODUCTS WHERE NAME=?;";
        Product product = null;

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = new Product();
                product.setProductId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setRate(resultSet.getDouble("RATE"));
                product.setCategoryId(resultSet.getInt("CATEGORY_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllByCategoryName(CategoryName categoryName) {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.ID, p.NAME, p.RATE, p.PRICE, p.CATEGORY_ID " +
                "FROM PRODUCTS p JOIN CATEGORIES c ON p.CATEGORY_ID=c.ID " +
                "WHERE c.NAME=?";

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryName.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setRate(resultSet.getDouble("RATE"));
                product.setCategoryId(resultSet.getInt("CATEGORY_ID"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void update(Product product) {

        String sql = "UPDATE PRODUCTS SET NAME=?, PRICE=?, RATE=?, CATEGORY_ID=? WHERE ID=?";

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getRate());
            preparedStatement.setInt(4, product.getCategory_id());
            preparedStatement.setInt(5, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {

        String sql = "DELETE FROM PRODUCTS WHERE ID=?";

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllByCategoryName(CategoryName categoryName) {

        CategoryService categoryService = new CategoryService();
        Category category = categoryService.getByName(categoryName);
        int categoryId = category.getId();

        String sql = "DELETE FROM PRODUCTS WHERE CATEGORY_ID=?";

        try(Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllProducts() {
        for(CategoryName categoryName: CategoryName.values()) {
            deleteAllByCategoryName(categoryName);
        }
    }
}

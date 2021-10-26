package service;

import bl.Util;
import category.CategoryName;
import dao.ProductDAO;
import product.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService extends Util implements ProductDAO {

    Connection connection = getConnection();

    @Override
    public void add(Product product) throws SQLException {

        String sql = "INSERT INTO PRODUCTS (NAME, PRICE, RATE, CATEGORY_ID) " +
                     "VALUES(?, ?, ?, ?)";

        System.out.println(product);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setDouble(2, product.getRate());
            preparedStatement.setLong(4, product.getCategory_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Product> getAll() throws SQLException {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS;";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getLong("ID"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setRate(resultSet.getDouble("RATE"));
                product.setCategoryId(resultSet.getLong("CATEGORY_ID"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return products;
    }

    @Override
    public Product getById(int id) throws SQLException {

        String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
        Product product = new Product();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            product.setProductId(resultSet.getLong("ID"));
            product.setName(resultSet.getString("NAME"));
            product.setPrice(resultSet.getDouble("PRICE"));
            product.setRate(resultSet.getDouble("RATE"));
            product.setCategoryId(resultSet.getLong("CATEGORY_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return product;
    }

    @Override
    public Product getByName(String productName) throws SQLException {
        String sql = "SELECT * FROM PRODUCTS WHERE NAME=?;";
        Product product = new Product();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, productName);

            ResultSet resultSet = preparedStatement.executeQuery();

            product.setProductId(resultSet.getLong("ID"));
            product.setName(resultSet.getString("NAME"));
            product.setPrice(resultSet.getDouble("PRICE"));
            product.setRate(resultSet.getDouble("RATE"));
            product.setCategoryId(resultSet.getLong("CATEGORY_ID"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> getAllByCategoryName(CategoryName categoryName) throws SQLException {

        List<Product> products = new ArrayList<>();
        String sql = "" +
                "SELECT p.ID, p.NAME, p.RATE, p.PRICE, p.CATEGORY_ID " +
                "FROM PRODUCTS p JOIN CATEGORIES c ON p.CATEGORY_ID=c.ID" +
                "WHERE c.NAME=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, categoryName.toString());

            ResultSet resultSet = preparedStatement.executeQuery(categoryName.toString());

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getLong("ID"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setRate(resultSet.getDouble("RATE"));
                product.setCategoryId(resultSet.getLong("CATEGORY_ID"));

                products.add(product);
            }
        }
        return products;
    }

    @Override
    public void update(Product product) throws SQLException {

        String sql = "UPDATE PRODUCTS SET NAME=?, PRICE=?, RATE=?, CATEGORY_ID=? WHERE ID=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getRate());
            preparedStatement.setLong(4, product.getCategory_id());
            preparedStatement.setLong(5, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void delete(Product product) throws SQLException {

        String sql = "DELETE FROM PRODUCTS WHERE ID=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null); {
                connection.close();
            }
        }
    }
}

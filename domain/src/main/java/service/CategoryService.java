package service;

import bl.Util;
import category.Category;
import category.CategoryName;
import dao.CategoryDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService extends Util implements CategoryDAO {

    Connection connection = getConnection();

    @Override
    public void add(Category category) throws SQLException {
        String sql = "INSERT INTO CATEGORIES (NAME) VALUES(?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, category.getName().toString());

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
    public List<Category> getAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIES;";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("ID"));
                category.setName(CategoryName.valueOf(resultSet.getString("NAME")));

                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return categories;
    }

    @Override
    public Category getById(int id) throws SQLException {
        String sql = "SELECT * FROM CATEGORIES WHERE ID=?";
        Category category = new Category();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            category.setId(resultSet.getInt("ID"));
            category.setName(CategoryName.valueOf(resultSet.getString("NAME")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return category;
    }

    @Override
    public Category getByName(CategoryName categoryName) throws SQLException {

        String sql = "SELECT ID, NAME FROM CATEGORIES WHERE NAME=?";
        Category category = new Category();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, categoryName.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Category name: " + categoryName);

            System.out.println("Result set: " + resultSet);

            category.setId(resultSet.getInt("ID"));
            category.setName(CategoryName.valueOf(resultSet.getString("NAME")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return category;
    }

    @Override
    public void update(Category category) throws SQLException {

        String sql = "UPDATE CATEGORIES SET NAME=? WHERE ID=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, category.getName().toString());
            preparedStatement.setLong(5, category.getId());

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
    public void delete(Category category) throws SQLException {

        String sql = "DELETE FROM CATEGORIES WHERE ID=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, category.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}

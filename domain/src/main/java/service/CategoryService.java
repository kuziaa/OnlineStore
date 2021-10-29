package service;

import bl.Util;
import category.Category;
import category.CategoryName;
import dao.CategoryDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService extends Util implements CategoryDAO {

    @Override
    public void add(Category category) {

        String sql = "INSERT INTO CATEGORIES (NAME) VALUES(?)";

        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName().toString());
            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.printf("Category %s already exist in db", category.getName().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAll() {

        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIES;";

        try (Connection connection = getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("ID"));
                category.setName(CategoryName.valueOf(resultSet.getString("NAME")));

                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getById(int id) {

        String sql = "SELECT * FROM CATEGORIES WHERE ID=?";
        Category category = null;

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                category = new Category();
                category.setId(resultSet.getInt("ID"));
                category.setName(CategoryName.valueOf(resultSet.getString("NAME")));
            } else {
                System.out.printf("There is no categories with id: %d", id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category getByName(CategoryName categoryName) {

        String sql = "SELECT ID, NAME FROM CATEGORIES WHERE NAME=?";
        Category category = null;

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryName.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                category = new Category();
                category.setId(resultSet.getInt("ID"));
                category.setName(CategoryName.valueOf(resultSet.getString("NAME")));
            } else {
                System.out.printf("There is no categories with name: %s", categoryName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void update(Category category) {

        String sql = "UPDATE CATEGORIES SET NAME=? WHERE ID=?";

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, category.getName().toString());
            preparedStatement.setInt(2, category.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Category category) {

        String sql = "DELETE FROM CATEGORIES WHERE ID=?";

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllCategories() {
        List<Category> categories = getAll();

        for (Category category: categories) {
            delete(category);
        }
    }
}

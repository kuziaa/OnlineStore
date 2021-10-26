package dao;

import category.Category;
import category.CategoryName;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDAO {

    //create
    void add(Category category) throws SQLException;

    List<Category> getAll() throws SQLException;

    Category getById(int id) throws SQLException;

    Category getByName(CategoryName categoryName) throws SQLException;

    //update
    void update(Category category) throws SQLException;

    //delete
    void delete(Category category) throws SQLException;
}

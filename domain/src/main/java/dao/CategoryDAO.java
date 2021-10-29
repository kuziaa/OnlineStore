package dao;

import category.Category;
import category.CategoryName;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDAO {

    //create
    void add(Category category);

    List<Category> getAll();

    Category getById(int id);

    Category getByName(CategoryName categoryName);

    //update
    void update(Category category);

    //delete
    void delete(Category category);
}

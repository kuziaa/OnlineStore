package dao;

import entity.Category;

import java.util.List;

public interface CategoryDAO {

    //read
    List<Category> getAll();

    Category getCategoryByName(String categoryName);

    //create
    String add(Category category);
}

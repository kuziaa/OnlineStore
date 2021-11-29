package service;

import bl.Util;
import dao.CategoryDAO;
import entity.Category;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.List;

public class CategoryService extends Util implements CategoryDAO {

    @Override
    public List<Category> getAll() {
        Response response = getRequestSpecification()
                .get(BASE_URL + CATEGORIES);

        List<Category> categories = Arrays.asList(response.getBody().as(Category[].class));

        return categories;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Category category = getRequestSpecification()
                .get(BASE_URL + CATEGORIES + "/" + categoryName)
                .getBody().as(Category.class);

        return category;
    }

    @Override
    public String add(Category category) {
        RequestSpecification requestSpecification = getRequestSpecification(category);
        String msg = requestSpecification
                .post(BASE_URL + CATEGORIES).getBody().asString();

        return msg;
    }

}
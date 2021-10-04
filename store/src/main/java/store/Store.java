package store;

import category.Category;
import product.Product;

import java.util.ArrayList;

public class Store {

    private final ArrayList<Category> categories = new ArrayList<>();

    private void addCategory(Category newCategory) {
        if (isNewCategory(newCategory)) {
            categories.add(newCategory);
        } else {
            System.out.println("Category " + newCategory.getCategoryName() + " was not added. " +
                    "Category with such a name already existed");
        }
    }

    public void addCategoryByClassName(String newCategoryClassName) {
        try {
            Class<?> clazz = Class.forName("category." + newCategoryClassName);
            addCategoryByReflection(clazz);
        } catch (ClassNotFoundException e) {
            System.out.println("Class with name " + newCategoryClassName + " was not found.");
        }
    }

    private void addCategoryByReflection(Class<?> newCategoryReflection) {
        try {
            addCategory((Category) newCategoryReflection.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Cannot create object from class " + newCategoryReflection.getName() + "\n" + e);
        }
    }

    public void delCategoryByName(String delCategoryName) {
        for (Category category: categories) {
            if (category.getCategoryName().equals(delCategoryName)) {
                categories.remove(category);
                break;
            }
        }
        System.out.println("Category " + delCategoryName + " was not found to be deleted");
    }

    public void delAllCategories() {
        categories.clear();
    }

    public ArrayList<String> getCategoriesNames() {
        ArrayList<String> categoriesNames = new ArrayList<>();
        for (Category category : categories) {
            categoriesNames.add(category.getCategoryName());
        }
        return categoriesNames;
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        for(Category category: categories) {
            products.addAll(category.getAllProducts());
        }
        return products;
    }

    private boolean isNewCategory(Category newCategory) {
        String newCategoryName = newCategory.getCategoryName();
        for (Category category : categories) {
            String categoryName = category.getCategoryName();
            if (categoryName.equals(newCategoryName)) return false;
        }
        return true;
    }

    public void addProductInCategory(Product newProduct, String categoryName) {
        for (Category category : categories) {
            if (category.getCategoryName().equals(categoryName)) {
                category.addProduct(newProduct);
                return;
            }
        }
        System.out.println("Store does not have category " + categoryName + ". Product was not added.");
    }

    public void addProductsInCategory(ArrayList<Product> newProducts, String categoryName) {
        for (Category category : categories) {
            if (category.getCategoryName().equals(categoryName)) {
                category.addProducts(newProducts);
                return;
            }
        }
        System.out.println("Store does not have category " + categoryName + ". Products were not added.");
    }

    public void showInfo() {
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    @Override
    public String toString() {
        return "" + categories;
    }
}

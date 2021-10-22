package store;

import category.Category;
import category.CategoryFactory;
import product.Product;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Store {
    private String storeType;
    private final ArrayList<Category> categories = new ArrayList<>();

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    private boolean addCategory(Category newCategory) {
        if (!categories.contains(newCategory)) {
            categories.add(newCategory);
            return true;
        } else {System.out.println("Category " + newCategory.getCategoryName() + " was not added. " +
                "Category with such a name already existed");
            return false;
        }
    }

    public boolean addCategoryByName(String newCategoryName) {
        CategoryFactory categoryFactory = new CategoryFactory();
        Category category = categoryFactory.createCategory(newCategoryName);
        return addCategory(category);
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

    public ArrayList<Product> getAllProducts() {

        ArrayList<Product> products = categories.stream()
                .flatMap(category -> category.getAllProducts().stream())
                .collect(Collectors.toCollection(ArrayList::new));

        return products;
    }

    public ArrayList<String> getCategoriesNames() {

        ArrayList<String> categoriesNames = categories.stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toCollection(ArrayList::new));

        return categoriesNames;
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

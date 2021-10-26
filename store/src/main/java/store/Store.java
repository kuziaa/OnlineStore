package store;

import category.Category;
//import category.CategoryFactory;
import category.CategoryName;
import product.Product;
import service.CategoryService;
import service.ProductService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

//    private final ArrayList<Category> categories = new ArrayList<>();

    public void addCategory(Category category) {
        CategoryService categoryService = new CategoryService();
        try {
            categoryService.add(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Category> getAllCategories() {
        List<Category> categories = null;
        CategoryService categoryService = new CategoryService();
        try {
            categories = categoryService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Category getCategoryByCategoryName(CategoryName categoryName) {
        Category category = null;
        CategoryService categoryService = new CategoryService();
        try {
            category = categoryService.getByName(categoryName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public void addProduct(Product product) {
        ProductService productService = new ProductService();
        try {
            productService.add(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = null;
        ProductService productService = new ProductService();
        try {
            products = productService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> getProductsByCategoryName(CategoryName categoryName) {
        List<Product> products = null;
        ProductService productService = new ProductService();
        try {
            products = productService.getAllByCategoryName(categoryName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


//    private boolean addCategory(Category newCategory) {
//        if (!categories.contains(newCategory)) {
//            categories.add(newCategory);
//            return true;
//        } else {System.out.println("Category " + newCategory.getName() + " was not added. " +
//                "Category with such a name already existed");
//            return false;
//        }
//    }

//    public boolean addCategoryByName(String newCategoryName) {
//        CategoryFactory categoryFactory = new CategoryFactory();
//        Category category = categoryFactory.createCategory(newCategoryName);
//        return addCategory(category);
//    }

//    public void delCategoryByName(String delCategoryName) {
//        for (Category category: categories) {
//            if (category.getName().equals(delCategoryName)) {
//                categories.remove(category);
//                break;
//            }
//        }
//        System.out.println("Category " + delCategoryName + " was not found to be deleted");
//    }

//    public void delAllCategories() {
//        categories.clear();
//    }

//    public ArrayList<Product> getAllProducts() {
//
//        ArrayList<Product> products = categories.stream()
//                .flatMap(category -> category.getAllProducts().stream())
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        return products;
//    }

//    public ArrayList<String> getCategoriesNames() {
//
//        ArrayList<String> categoriesNames = categories.stream()
//                .map(Category::getName)
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        return categoriesNames;
//    }

//    public void addProductInCategory(Product newProduct, String categoryName) {
//        for (Category category : categories) {
//            if (category.getName().equals(categoryName)) {
//                category.addProduct(newProduct);
//                return;
//            }
//        }
//        System.out.println("Store does not have category " + categoryName + ". Product was not added.");
//    }

//    public void addProductsInCategory(ArrayList<Product> newProducts, String categoryName) {
//        for (Category category : categories) {
//            if (category.getName().equals(categoryName)) {
//                category.addProducts(newProducts);
//                return;
//            }
//        }
//        System.out.println("Store does not have category " + categoryName + ". Products were not added.");
//    }

    public void showInfo() {
        List<Category> categories = getAllCategories();
        for (Category category: categories) {

            System.out.println(category.getName());
            List<Product> products = getProductsByCategoryName(category.getName());

            products.forEach(System.out::println);
        }
    }
}

//
//    @Override
//    public String toString() {
//        return "" + categories;
//    }


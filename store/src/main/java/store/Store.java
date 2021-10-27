package store;

import category.Category;
import category.CategoryName;
import product.Product;
import service.CategoryService;
import service.ProductService;

import java.util.List;

public class Store {

    CategoryService categoryService = new CategoryService();
    ProductService productService = new ProductService();

    public void addCategory(Category category) {
        categoryService.add(category);
    }

    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    public Category getCategoryByCategoryName(CategoryName categoryName) {
        return categoryService.getByName(categoryName);
    }

    public void addProduct(Product product) {
        productService.add(product);
    }

    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    public List<Product> getProductsByCategoryName(CategoryName categoryName) {
        return productService.getAllByCategoryName(categoryName);
    }

    public void clearStore() {
        productService.deleteAllProducts();
        categoryService.deleteAllCategories();
    }

    public void showInfo() {
        for (Category category: getAllCategories()) {

            System.out.println();
            System.out.println(category);
            List<Product> products = getProductsByCategoryName(category.getName());
            products.forEach(System.out::println);
        }
    }
}


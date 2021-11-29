package store;

import entity.Category;
import entity.Product;
import service.CartService;
import service.CategoryService;
import service.ProductService;

import java.util.List;

public class Store {

    CategoryService categoryService = new CategoryService();
    ProductService productService = new ProductService();
    CartService cartService = new CartService();

    public void addCategory(Category category) {
        String msg = categoryService.add(category);
        System.out.println(msg);
    }

    public Category getCategoryByName(String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        return category;
    }

    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    public void addProduct(Product product) {
        String msg = productService.add(product);
        System.out.println(msg);
    }

    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    public List<Product> getCart() {
        List<Product> productsInCart = cartService.getProductsFromCart();
        return productsInCart;
    }

    public void showCart() {
        List<Product> productsInCart = getCart();
        if (productsInCart.size() == 0) {
            System.out.println(productsInCart);
        } else {
            productsInCart.forEach(System.out::println);
        }
    }

    public void addProductToCart(Product product) {
        cartService.addProductToCart(product);
    }

    public void cleanCart() {
        cartService.cleanCart();
    }

    public void showInfo() {

        for (Category category: getAllCategories()) {
            System.out.println();
            System.out.println(category);
            category.getProducts().forEach(System.out::println);
        }
    }
}


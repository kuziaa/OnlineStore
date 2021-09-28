package randomStorePopulator;

import com.github.javafaker.Faker;
import product.Product;
import store.Store;

import java.util.ArrayList;

public class RandomStorePopulator {

    private final Faker faker = new Faker();

    private String getRandomProductName() {
        return faker.food().ingredient();
    }

    private double getRandomRate() {
        return faker.number().randomDouble(2, 5, 25);
    }

    private double getRandomPrice() {
        return faker.number().randomDouble(2, 30, 300);
    }

    private Product getRandomProduct() {
        return new Product(getRandomProductName(), getRandomRate(), getRandomPrice());
    }

    private ArrayList<Product> getRandomProducts() {
        int numOfProducts = (int) (Math.random() * 10 + 1);
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < numOfProducts; i++)
            products.add(getRandomProduct());
        return products;
    }

    public void fillOnlineStoreWithRandomProducts(Store store) {
        ArrayList<String> categoriesNames = store.getCategoriesNames();
        for (String categoryName : categoriesNames) {
            store.addProductsInCategoryByName(getRandomProducts(), categoryName);
        }
    }
}

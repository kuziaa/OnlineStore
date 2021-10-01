package randomStorePopulator;

import com.github.javafaker.Faker;
import product.Product;
import store.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class RandomStorePopulator {

    private static final Faker faker = new Faker();
    private static final Map <String, Callable <String>> availableCategories = new HashMap<>();

    static {
        availableCategories.put("Fruits", () -> faker.food().fruit());
        availableCategories.put("Sushi", () -> faker.food().sushi());
        availableCategories.put("Beer", () -> faker.beer().name());
        availableCategories.put("Animal", () -> faker.animal().name());
        availableCategories.put("Book", () ->faker.book().title());
    }

    private String getRandomProductNameForCategory(String categoryName) throws Exception {
        return availableCategories.get(categoryName).call();
    }

    private double getRandomRate() {
        return faker.number().randomDouble(2, 5, 25);
    }

    private double getRandomPrice() {
        return faker.number().randomDouble(2, 30, 300);
    }

    private Product getRandomProductForCategory(String categoryName) throws Exception {
        return new Product(getRandomProductNameForCategory(categoryName), getRandomRate(), getRandomPrice());
    }

    private ArrayList<Product> getRandomProductsForCategory(String categoryName) {
        int numOfProducts = (int) (Math.random() * 10 + 1);
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < numOfProducts; i++)
            try {
                products.add(getRandomProductForCategory(categoryName));
            } catch (Exception e) {
                System.out.println("Failed to create a product for category " + categoryName + "\n" + e);
            }
        return products;
    }

    public void fillOnlineStore(Store store) {
        for(String categoryName: availableCategories.keySet()) {
            store.addCategoryByClassName(categoryName);
            ArrayList<Product> products = getRandomProductsForCategory(categoryName);
            store.addProductsInCategoryByName(products, categoryName);
        }
    }
}


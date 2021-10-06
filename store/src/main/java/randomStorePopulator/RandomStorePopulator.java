package randomStorePopulator;

import product.*;
import store.Store;

import java.util.ArrayList;

public class RandomStorePopulator {

    ArrayList<String> categoriesNames = new ArrayList<>();
    {
        categoriesNames.add("Fruit");
        categoriesNames.add("Sushi");
        categoriesNames.add("Beer");
        categoriesNames.add("Animal");
        categoriesNames.add("Book");
    }

    private void addCategories(Store store) {
        for (String categoryName: categoriesNames) {
            store.addCategoryByName(categoryName);
        }
    }

    private void addProducts(String categoryName, Store store) {
        ProductFactory productFactory = ProductFactories.getProductFactory(categoryName);
        int numOfProducts = (int) (Math.random() * 10 + 1);
        for (int i = 0; i < numOfProducts; i++) {
            Product product = productFactory.getProduct();
            store.addProductInCategory(product, categoryName);
        }
    }

    public void fillOnlineStore(Store store) {
        for(String categoryName: categoriesNames) {
            store.addCategoryByName(categoryName);
            addProducts(categoryName, store);
        }
    }
}


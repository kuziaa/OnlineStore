package randomStorePopulator;

import product.*;
import store.Store;

public class RandomStorePopulator {

    private void addProducts(String categoryName, Store store) {
        ProductFactory productFactory = ProductFactories.getProductFactory(categoryName);
        int numOfProducts = (int) (Math.random() * 10 + 1);
        for (int i = 0; i < numOfProducts; i++) {
            Product product = productFactory.getProduct();
            store.addProductInCategory(product, categoryName);
        }
    }

    public void fillOnlineStore(Store store) {
        for(String categoryName: store.getCategoriesNames()) {
            addProducts(categoryName, store);
        }
    }
}


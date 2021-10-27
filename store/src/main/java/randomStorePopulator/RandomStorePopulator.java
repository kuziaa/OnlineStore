package randomStorePopulator;

import category.Category;
import category.CategoryName;
import product.*;
import store.Store;

public class RandomStorePopulator {

    private void addProducts(CategoryName categoryName, int categoryId, Store store) {
        ProductFactory productFactory = ProductFactories.getProductFactory(categoryName, categoryId);
        int numOfProducts = (int) (Math.random() * 10 + 1);
        for (int i = 0; i < numOfProducts; i++) {
            Product product = productFactory.getProduct();
            store.addProduct(product);
        }
    }

    public void fillOnlineStore(Store store) {
        for(CategoryName categoryName: CategoryName.values()) {
            Category category = new Category();
            category.setName(categoryName);
            System.out.println("add category: " + categoryName);

            store.addCategory(category);

            Category categoryFromDB = store.getCategoryByCategoryName(categoryName);
            if (categoryFromDB != null) {
                int categoryId = categoryFromDB.getId();
                addProducts(categoryName, categoryId, store);
            }
        }
    }
}


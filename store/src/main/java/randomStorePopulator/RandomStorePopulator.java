package randomStorePopulator;

import entity.Category;
import entity.CategoryName;
import entity.Product;
import product_factory.ProductFactories;
import product_factory.ProductFactory;
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

            String strCategoryName = categoryName.toString();
            Category category = new Category();
            category.setName(strCategoryName);
            System.out.println("add category: " + categoryName);

            store.addCategory(category);

            Category categoryFromDB = store.getCategoryByName(strCategoryName);
            int categoryId = categoryFromDB.getId();
            addProducts(categoryName, categoryId, store);
        }
    }
}


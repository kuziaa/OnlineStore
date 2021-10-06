package store;

public class MallStoreBuilder extends StoreBuilder {
    @Override
    void buildStoreType() {
        store.setStoreType("Mall");
    }

    @Override
    void buildStoreCategories() {
        store.addCategoryByName("Animal");
        store.addCategoryByName("Beer");
        store.addCategoryByName("Book");
        store.addCategoryByName("Fruit");
        store.addCategoryByName("Sushi");

    }
}

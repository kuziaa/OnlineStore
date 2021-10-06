package store;

public class FruitStoreBuilder extends StoreBuilder {
    @Override
    void buildStoreType() {
        store.setStoreType("FruitStore");
    }

    @Override
    void buildStoreCategories() {
        store.addCategoryByName("Fruit");

    }
}

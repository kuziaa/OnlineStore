package store;

public abstract class StoreBuilder {
    Store store;

    void createStore() {
        store = new Store();
    }

    abstract void buildStoreType();

    abstract void buildStoreCategories();

    Store getStore() {
        return store;
    }
}

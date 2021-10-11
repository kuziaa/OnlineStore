package store;

public class StoreDirector {
    StoreBuilder builder;

    public void setBuilder(StoreBuilder builder) {
        this.builder = builder;
    }

    public Store buildStore() {
        builder.createStore();
        builder.buildStoreType();
        builder.buildStoreCategories();

        return builder.getStore();
    }
}

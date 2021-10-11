package storeApp;

public class StoreAppDirector {
    StoreAppBuilder builder;

    public void setStoreAppBuilder(StoreAppBuilder builder) {
        this.builder = builder;
    }

    public StoreApp buildStoreApp() {
        builder.createStoreApp();
        builder.buildStore();

        return builder.getStoreApp();
    }
}

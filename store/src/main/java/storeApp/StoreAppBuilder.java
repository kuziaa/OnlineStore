package storeApp;

public abstract class StoreAppBuilder {

    StoreApp storeApp;

    void createStoreApp() {
        storeApp = new StoreApp();
    }

    abstract void buildStore();

    StoreApp getStoreApp() {
        return storeApp;
    }
}

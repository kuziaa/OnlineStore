package consoleApp;

import storeApp.StoreApp;

public class consoleApp {
    public static void main(String[] args) {

        StoreApp storeApp = new StoreApp.Builder()
                .withStore()
                .withParser()
                .withRoot()
                .withSort()
                .withCart()
                .build();

        storeApp.fillStoreWithRandomCatAndProd();
        storeApp.showInfo();

        ConsoleHandler ch = new ConsoleHandler(storeApp);
        ch.run();
    }
}

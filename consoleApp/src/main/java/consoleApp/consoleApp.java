package consoleApp;

import storeApp.StoreApp;

public class consoleApp {
    public static void main(String[] args) {
        StoreApp myStoreApp = new StoreApp();
        myStoreApp.fillStoreWithRandomCatAndProd();
        myStoreApp.showInfo();

        ConsoleHandler ch = new ConsoleHandler(myStoreApp);
        ch.run();
    }
}

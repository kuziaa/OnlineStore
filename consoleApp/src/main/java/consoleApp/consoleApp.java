package consoleApp;

import storeApp.MallStoreAppBuilder;
import storeApp.StoreApp;
import storeApp.StoreAppDirector;

public class consoleApp {
    public static void main(String[] args) {
        StoreAppDirector storeAppDirectorDirector = new StoreAppDirector();
        storeAppDirectorDirector.setStoreAppBuilder(new MallStoreAppBuilder());
        StoreApp storeApp = storeAppDirectorDirector.buildStoreApp();

        storeApp.fillStoreWithRandomCatAndProd();
        storeApp.showInfo();

        ConsoleHandler ch = new ConsoleHandler(storeApp);
        ch.run();
    }
}

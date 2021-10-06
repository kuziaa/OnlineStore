package consoleApp;

import storeApp.MallStoreAppBuilder;
import storeApp.StoreApp;
import storeApp.StoreAppDirector;

// Current class will be deleted just after task be passed. Was created just to apply Facade Design Pattern

public class Facade {

    public void run() {
        StoreAppDirector storeAppDirectorDirector = new StoreAppDirector();
        storeAppDirectorDirector.setStoreAppBuilder(new MallStoreAppBuilder());
        StoreApp storeApp = storeAppDirectorDirector.buildStoreApp();

        storeApp.fillStoreWithRandomCatAndProd();
        storeApp.showInfo();

        ConsoleHandler ch = new ConsoleHandler(storeApp);
        ch.run();
    }
}

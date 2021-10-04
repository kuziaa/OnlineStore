package consoleApp;

import randomStorePopulator.RandomStorePopulator;
import store.Store;

public class consoleApp {
    public static void main(String[] args) {
        Store myStore = new Store();
        RandomStorePopulator rsp = new RandomStorePopulator();
        rsp.fillOnlineStore(myStore);
        myStore.showInfo();

        ConsoleHandler ch = new ConsoleHandler(myStore);
        ch.run();
    }
}

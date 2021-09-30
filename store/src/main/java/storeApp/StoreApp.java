package storeApp;

import randomStorePopulator.RandomStorePopulator;
import store.Store;

public class StoreApp {

    public static void main(String[] args) {
        Store myStore = new Store();
        RandomStorePopulator rsp = new RandomStorePopulator();
        rsp.fillOnlineStore(myStore);
        myStore.showInfo();
    }
}

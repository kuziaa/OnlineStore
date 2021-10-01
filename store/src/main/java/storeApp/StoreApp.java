package storeApp;

import randomStorePopulator.RandomStorePopulator;
import store.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class StoreApp {

    private final Store myStore = new Store();

    public boolean executeComand(String comand) {
        switch (comand) {
            case "Fill":
                this.fillStoreWithRandomCatAndProd();
                break;
            case "sort":
                this.showSortedProducts();
                break;
            case "help":
//                this.help();
            default:
                return false;
        }
        return true;
    }

    private void fillStoreWithRandomCatAndProd() {
        RandomStorePopulator rsp = new RandomStorePopulator();
        rsp.fillOnlineStore(myStore);
    }

    private void showSortedProducts() {

    }

    private void showFiveExpensiveProducts() {

    }

//    private ArrayList <String> sortProducts(ArrayList <String> products) {
//        Sort sort = new Sort();
//
//    }

}

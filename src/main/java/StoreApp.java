import randomStorePopulator.RandomStorePopulator;
import store.Store;

public class StoreApp {

    private static final String CATEGORIES_FILE_ADDRESS = "store/src/main/resources/StoreCategories.txt";

    public static void main(String[] args) {
        Store myStore = new Store();
        myStore.addCategoriesFromFile(CATEGORIES_FILE_ADDRESS);
        RandomStorePopulator rsp = new RandomStorePopulator();
        rsp.fillOnlineStoreWithRandomProducts(myStore);
        myStore.showInfo();
    }
}

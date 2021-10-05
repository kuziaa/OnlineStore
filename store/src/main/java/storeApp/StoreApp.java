package storeApp;

import model.Root;
import model.Sort;
import product.Product;
import parser.Parser;
import randomStorePopulator.RandomStorePopulator;
import store.Store;

import java.util.ArrayList;

public class StoreApp {

    private final Store myStore = new Store();
    private final Parser parser = new Parser();
    private final Root root = parser.parse();
    private final Sort sort = root.getSort();

    public void fillStoreWithRandomCatAndProd() {
        RandomStorePopulator rsp = new RandomStorePopulator();
        rsp.fillOnlineStore(myStore);
    }

    private ArrayList<Product> getSortedProducts(ArrayList<Product> products, Sort sort) {
        ArrayList<Product> sortedProducts = new ArrayList<>(products);

        sortedProducts.sort((o1, o2) -> {
            int nameComp = o1.getName().compareToIgnoreCase(o2.getName());
            int priceComp = Double.compare(o1.getPrice(), o2.getPrice());
            int rateComp = Double.compare(o1.getRate(), o2.getRate());
            switch (sort.getNameOrder()) {
                case "asc":
                    if (nameComp != 0) return nameComp;
                    break;
                case "desc":
                    if (nameComp != 0) return -nameComp;
                    break;
                case "no":
                    break;
            }
            switch (sort.getPriceOrder()) {
                case "asc":
                    if (priceComp != 0) return priceComp;
                    break;
                case "desc":
                    if (priceComp != 0) return -priceComp;
                    break;
                case "no":
                    break;
            }
            switch (sort.getRateOrder()) {
                case "asc":
                    return rateComp;
                case "desc":
                    return -rateComp;
                default:
                    return 0;
            }
        });
        return sortedProducts;
    }

    public void printAllSortedProducts() {
        ArrayList<Product> sortedProducts = getSortedProducts(myStore.getAllProducts(), sort);
        sortedProducts.forEach(System.out::println);
    }

    public void printFiveMostExpensiveProducts() {
        Sort sort = new Sort("no", "desc", "no");
        ArrayList<Product> sortedProducts = getSortedProducts(myStore.getAllProducts(), sort);
        for(int i = 0; i < 5; i++) {
            System.out.println(sortedProducts.get(i));
        }
    }

    public void showInfo() {
        myStore.showInfo();
    }
}

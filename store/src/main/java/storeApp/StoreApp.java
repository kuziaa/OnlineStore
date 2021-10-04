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
    private Parser parser = new Parser();
    private Root root = parser.parse();
    private Sort sort = root.getSort();

    public void fillStoreWithRandomCatAndProd() {
        RandomStorePopulator rsp = new RandomStorePopulator();
        rsp.fillOnlineStore(myStore);
    }

    private ArrayList<Product> getSortedProducts(ArrayList<Product> products, String nameOrder,
                                                 String priceOrder, String rateOrder) {
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
        ArrayList<Product> sortedProducts = getSortedProducts(myStore.getAllProducts(), sort.getNameOrder(),
                sort.getPriceOrder(), sort.getRateOrder());
        sortedProducts.forEach(System.out::println);
    }

    public void printFiveMostExpensiveProducts() {
        ArrayList<Product> sortedProducts = getSortedProducts(myStore.getAllProducts(),
                "no", "desc", "no");
        for(int i = 0; i < 5; i++) {
            System.out.println(sortedProducts.get(i));
        }
    }

    public void showInfo() {
        myStore.showInfo();
    }
}

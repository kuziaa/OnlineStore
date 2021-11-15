package storeApp;

import entity.Product;
import model.Root;
import model.Sort;
import model.SortOrder;
import parser.Parser;
import randomStorePopulator.RandomStorePopulator;
import store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StoreApp {

    private Store store;
    private Parser parser;
    private Root root;
    private Sort sort;
//    private Cart cart;

    public static class Builder {
        private final StoreApp storeApp;

        public Builder() {
            storeApp = new StoreApp();
        }

        public Builder withStore() {
            storeApp.store = new Store();
            return this;
        }

        public Builder withParser() {
            storeApp.parser = new Parser();
            return this;
        }

        public Builder withRoot() {
            storeApp.root = storeApp.parser.parse();
            return this;
        }

        public Builder withSort() {
            storeApp.sort = storeApp.root.getSort();
            return this;
        }

//        public Builder withCart() {
//            storeApp.cart = Cart.getCart();
//            return this;
//        }

        public StoreApp build() {
            return storeApp;
        }
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void fillStoreWithRandomCatAndProd() {
        RandomStorePopulator rsp = new RandomStorePopulator();
        rsp.fillOnlineStore(store);
    }

    private List<Product> getSortedProducts(List<Product> products, Sort sort) {
        List<Product> sortedProducts = products.stream().
                sorted((o1, o2) -> {
                    int nameComp = o1.getName().compareToIgnoreCase(o2.getName());
                    int priceComp = Double.compare(o1.getPrice(), o2.getPrice());
                    int rateComp = Double.compare(o1.getRate(), o2.getRate());

                    SortOrder nameSortOrder = SortOrder.valueOf(sort.getNameOrder().toUpperCase());
                    int sortNameCoef = nameSortOrder.getSortCoef();
                    nameComp *= sortNameCoef;
                    if (nameComp != 0) return nameComp;

                    SortOrder priceSortOrder = SortOrder.valueOf(sort.getPriceOrder().toUpperCase());
                    int sortPriceCoef = priceSortOrder.getSortCoef();
                    priceComp *= sortPriceCoef;
                    if (priceComp != 0) return priceComp;

                    SortOrder rateSortOrder = SortOrder.valueOf(sort.getRateOrder().toUpperCase());
                    int sortRateCoef = rateSortOrder.getSortCoef();
                    rateComp *= sortRateCoef;
                    return rateComp;
                }).collect(Collectors.toCollection(ArrayList::new));

        return sortedProducts;
    }

    public void printAllSortedProducts() {
        List<Product> sortedProducts = getSortedProducts(store.getAllProducts(), sort);
        sortedProducts.forEach(System.out::println);
    }

    public void printFiveMostExpensiveProducts() {
        Sort sort = new Sort("no", "desc", "no");

        List<Product> sortedProducts = getSortedProducts(store.getAllProducts(), sort);
        sortedProducts.stream().limit(5).forEach(System.out::println);
    }

    public void showInfo() {
        store.showInfo();
    }

    private void printProductsWithNumbers(List<Product> products) {
        int i = 1;

        for (Product product: products) {
            System.out.println(i + ") " + product);
            i++;
        }
        System.out.println("0) Quit");
    }

    public void buyProductByChoice() {
        List<Product> products = store.getAllProducts();
        printProductsWithNumbers(products);
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int productNumber = makeAChoice(products.size());
            if (productNumber == 0) return;
            buyProduct(products.get(productNumber - 1));
        }
    }

    private void buyProduct(Product product) {

        Thread buyingProduct = new Thread(() -> {
            int delay = (int) (Math.random() * 29 + 1);
            System.out.printf("Buying a %s. It will take %d seconds%n", product.getName(), delay);
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            store.addProductToCart(product);
            System.out.println(product.getName() + " was added to cart.");
        });
        buyingProduct.start();
    }

    private int makeAChoice(int maxNum) {
        System.out.println("Choice a product you want to buy: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect choice. Try again.");
                continue;
            }

            if (choice < 0 || choice > maxNum) {
                System.out.println("Incorrect choice. Try again.");
                continue;
            }
            break;
        }
        return choice;
    }

//    public void clearStore() {
//        store.clearStore();
//    }

    public void showCart() {
        store.showCart();
    }

    public void cleanCart() {
        store.cleanCart();
        System.out.println("Cart was cleaned");
    }
}

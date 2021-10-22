package storeApp;

import model.Root;
import model.Sort;
import model.SortOrder;
import product.Product;
import parser.Parser;
import purchase.Cart;
import randomStorePopulator.RandomStorePopulator;
import store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StoreApp {

    private Store store;
    private final Parser parser = new Parser();
    private final Root root = parser.parse();
    private final Sort sort = root.getSort();
    private final Cart cart = Cart.getCart();

    public void setStore(Store store) {
        this.store = store;
    }

    public void fillStoreWithRandomCatAndProd() {
        RandomStorePopulator rsp = new RandomStorePopulator();
        rsp.fillOnlineStore(store);
    }

    private ArrayList<Product> getSortedProducts(ArrayList<Product> products, Sort sort) {
        ArrayList<Product> sortedProducts = products.stream().
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
        ArrayList<Product> sortedProducts = getSortedProducts(store.getAllProducts(), sort);
        sortedProducts.forEach(System.out::println);
    }

    public void printFiveMostExpensiveProducts() {
        Sort sort = new Sort("no", "desc", "no");
        ArrayList<Product> sortedProducts = getSortedProducts(store.getAllProducts(), sort);
        for(int i = 0; i < 5; i++) {
            System.out.println(sortedProducts.get(i));
        }
    }

    public void showInfo() {
        store.showInfo();
    }

    private void printProductsWithNumbers(ArrayList<Product> products) {
        int i = 1;
        System.out.println("0) Quit");

        for (Product product: products) {
            System.out.println(i + ") " + product);
            i++;
        }
    }

    public void buyProductByChoice() {
        ArrayList<Product> products = store.getAllProducts();
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
            cart.addProduct(product);
            System.out.println(product.getName() + " has bought.");
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

    public void showCart() {
        cart.showCart();
    }
}

package consoleApp;

import model.Root;
import model.Sort;
import parser.Parser;
import product.Product;
import store.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleHandler {
    ConsoleHandler(Store store) {
        this.store = store;
    }

    private Scanner sc = new Scanner(System.in);
    private Parser parser = new Parser();

    private Root root = parser.parse();
    private Sort sort = root.getSort();
    private String command;
    private Store store;

    public void run() {
        outer:
        while (true) {
            command = sc.nextLine();
            switch (command){
                case "help":
                    help();
                    break;
                case "sort":
                    printAllSortedProducts();
                    break;
                case "top":
                    printFiveMostExpensiveProducts();
                    break;
                case "quit":
                    System.out.println("Buy!");
                    break outer;
                default:
                    System.out.println("Incorrect command try again.");
                    help();
                    break;
            }
        }
    }

    private void help() {
        System.out.println("help - print list of commands");
        System.out.println("sort - print list of products ordered according to config");
        System.out.println("top - print top 5 products sorted via price desc");
        System.out.println("quit - exit the app");
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

    private void printAllSortedProducts() {
        ArrayList<Product> sortedProducts = getSortedProducts(store.getAllProducts(), sort.getNameOrder(),
                sort.getPriceOrder(), sort.getRateOrder());
        sortedProducts.forEach(System.out::println);
    }

    private void printFiveMostExpensiveProducts() {
        ArrayList<Product> sortedProducts = getSortedProducts(store.getAllProducts(),
                "no", "desc", "no");
        for(int i = 0; i < 5; i++) {
            System.out.println(sortedProducts.get(i));
        }
    }
}

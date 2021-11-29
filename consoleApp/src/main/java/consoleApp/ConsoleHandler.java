package consoleApp;

import storeApp.StoreApp;

import java.util.Scanner;

public class ConsoleHandler {
    ConsoleHandler(StoreApp storeApp) {
        this.storeApp = storeApp;
    }

    StoreApp storeApp;
    private final Scanner sc = new Scanner(System.in);

    public void run() {

        outer:
        while (true) {
            String command = sc.nextLine();
            switch (command){
                case "help":
                    help();
                    break;
                case "sort":
                    storeApp.printAllSortedProducts();
                    break;
                case "top":
                    storeApp.printFiveMostExpensiveProducts();
                    break;
                case "showInfo":
                    storeApp.showInfo();
                    break;
                case "buyProduct":
                    storeApp.buyProductByChoice();
                    help();
                    break;
                case "showCart":
                    storeApp.showCart();
                    break;
                case "cleanCart":
                    storeApp.cleanCart();
                    break;
                case "quit":
                    System.out.println("Bye!");
                    break outer;
                default:
                    System.out.println("Incorrect command. Please try again.");
                    help();
                    break;
            }
        }
        sc.close();
    }

    private void help() {
        System.out.println("Help:");
        System.out.println("help - print list of commands");
        System.out.println("sort - print list of products ordered according to config");
        System.out.println("top - print top 5 products sorted via price desc");
        System.out.println("showInfo - show info about store");
        System.out.println("buyProduct - open buy product console");
        System.out.println("showCart - show the products you already bought. Cleans every 2 minutes");
        System.out.println("cleanCart - delete all products from cart");
        System.out.println("quit - exit the app");
    }
}

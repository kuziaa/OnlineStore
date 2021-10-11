package purchase;

import product.Product;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Purchase {
    public Purchase() {
        basket.start();
    }

    ConcurrentHashMap<Integer, Product> purchasedGoods = new ConcurrentHashMap<>();
    Thread basket = new Thread(new Basket(purchasedGoods));

    public void buy(Product product) {
        Thread buyThread = new Thread(new Buy(product, purchasedGoods));
        buyThread.start();
    }

    public void showBasket() {
        System.out.println("Basket:");
        purchasedGoods.forEach((k, v) -> System.out.println(k + ") " + v));
        System.out.println("=====================================================");
    }

    public void buyByChoice(ArrayList<Product> products) throws InterruptedException {
        while (true) {
            printProductList(products);
            int choice = makeAChoice(products.size());
            if (choice == 0) {
                break;
            } else if (choice != -1){
                buy(products.get(choice - 1));
                Thread.sleep(1000);
                System.out.println("Do you want to buy anything else?");
                Thread.sleep(1000);
            }
        }
    }

    private int makeAChoice(int maxNum) {
        System.out.println("Choice a product you want to buy: ");
        Scanner sc = new Scanner(System.in);
        int choice;

        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect choice. Try again.");
            return -1;
        }

        if (choice < 0 | choice > maxNum) {
            System.out.println("Incorrect choice. Try again.");
            return -1;
        }
        return choice;
    }

    private void printProductList(ArrayList<Product> products) {
        int i = 1;
        System.out.println("0) Exit");
        for (Product product: products) {
            System.out.println(i++ + ") " + product.toString());
        }
    }
}

package purchase;

import product.Product;

import java.util.concurrent.ConcurrentHashMap;

public class Cart {

    private Cart() {
        this.purchasedGoods = new ConcurrentHashMap<>();

        Thread cartCleaner = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(120_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                purchasedGoods.clear();
                System.out.println("Cart was cleaned");
            }
        });

        cartCleaner.start();
    }

    private ConcurrentHashMap<Integer, Product> purchasedGoods;
    private static Cart cart;
    private int id = 1;

    public static Cart getCart() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    public void addProduct(Product product) {
        purchasedGoods.put(id++, product);
    }

    public void showCart() {
        if (purchasedGoods.size() == 0) {
            System.out.println("Cart is empty []");
            return;
        }

        for (int key: purchasedGoods.keySet()) {
            System.out.println(key + ") " + purchasedGoods.get(key));
        }
    }
}

package purchase;

import product.Product;

import java.util.concurrent.ConcurrentHashMap;

public class Buy implements Runnable {
    Buy(Product product, ConcurrentHashMap<Integer, Product> purchasedGoods) {
        this.product = product;
        this.purchasedGoods = purchasedGoods;
    }

    Product product;
    ConcurrentHashMap<Integer, Product> purchasedGoods;
    static int id = 0;

    @Override
    public void run() {
        int delay = (int) (Math.random() * 29 + 1);
        System.out.println("Buying a " + product.getName() + ". It will take " + delay + " seconds....");
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(product.getName() + " has bought.");
        purchasedGoods.put(Buy.id(), product);
    }

    private static int id() {
        return id++;
    }
}

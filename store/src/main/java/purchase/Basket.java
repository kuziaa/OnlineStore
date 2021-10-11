package purchase;

import product.Product;

import java.util.concurrent.ConcurrentHashMap;

public class Basket implements Runnable {

    Basket(ConcurrentHashMap<Integer, Product> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    public ConcurrentHashMap<Integer, Product> purchasedGoods;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            purchasedGoods.clear();
            System.out.println("Basket was clean!");
        }
    }
}

package product;

public class Product {
    public Product(String name, double rate, double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    private final String name;
    private final double rate;
    private final double price;

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public double getPrice() {
        return price;
    }
}

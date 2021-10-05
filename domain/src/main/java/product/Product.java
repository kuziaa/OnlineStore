package product;

import java.util.Objects;

public class Product {
    public Product(String name, double rate, double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    private final String name;
    private double rate;
    private double price;

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public double getPrice() {
        return price;
    }

    public void setRate(double newRate) {
        rate = newRate;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "-" + getName() + " - " + getRate() + "% - " + getPrice() + "$";
    }


}

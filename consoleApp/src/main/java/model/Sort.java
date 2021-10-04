package model;

import java.util.ArrayList;

public class Sort {
    public Sort() {
        this.nameOrder = "no";
        this.priceOrder = "no";
        this.rateOrder = "no";
    }

    static ArrayList<String> accessibleValues = new ArrayList<>();
    static {
        accessibleValues.add("asc");
        accessibleValues.add("desc");
        accessibleValues.add("no");
    }

    private String nameOrder;
    private String priceOrder;
    private String rateOrder;

    public String getNameOrder() {
        return nameOrder;
    }

    public String getPriceOrder() {
        return priceOrder;
    }

    public String getRateOrder() {
        return rateOrder;
    }

    public void setNameOrder(String nameOrder) {
        if (accessibleValues.contains(nameOrder)) {
            this.nameOrder = nameOrder;
        } else {
            System.out.println("Incorrect value " + nameOrder + " for field Name");
        }
    }

    public void setPriceOrder(String priceOrder) {
        if (accessibleValues.contains(priceOrder)) {
            this.priceOrder = priceOrder;
        } else {
            System.out.println("Incorrect value " + priceOrder + " for field Price");
        }
    }

    public void setRateOrder(String rateOrder) {
        if (accessibleValues.contains(rateOrder)) {
            this.rateOrder = rateOrder;
        } else {
            System.out.println("Incorrect value " + rateOrder + " for field Rate");
        }
    }

    @Override
    public String toString() {
        return "Sort{" +
                "nameOrder='" + nameOrder + '\'' +
                ", priceOrder='" + priceOrder + '\'' +
                ", rateOrder='" + rateOrder + '\'' +
                '}';
    }
}

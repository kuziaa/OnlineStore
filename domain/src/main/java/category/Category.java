package category;

import product.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Category {

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    private final String categoryName;
    private final ArrayList<Product> products = new ArrayList<>();

    public String getCategoryName() {
        return categoryName;
    }

    public void addProduct(Product newProduct) {
        if (products.contains(newProduct)) {
            System.out.println("Product " + newProduct.getName() + " already exist in current category");
            return;
        }
        products.add(newProduct);
    }

    public void addProducts(ArrayList<Product> newProducts) {
        for (Product newProduct : newProducts) {
            addProduct(newProduct);
        }
    }

    public void delProduct(String delProductName) {
        for (Product product: products) {
            if (product.getName().equals(delProductName)) {
                products.remove(product);
                return;
            }
        }
        System.out.println("Product " + delProductName + " was not found to be deleted");
    }

    public void delAllProducts() {
        products.clear();
    }

//    public ArrayList<String> getAllProductsInfo() {
//        ArrayList <String> allProductsInfo = new ArrayList<>();
//        for (Product product: products) {
//            allProductsInfo.add(product.toString());
//        }
//        return allProductsInfo;
//    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder categoryInfo = new StringBuilder();

        categoryInfo.append("•");
        categoryInfo.append(getCategoryName());
        categoryInfo.append("\n");

        for (Product product : products) {
            categoryInfo.append("\t");
            categoryInfo.append(product.toString());
            categoryInfo.append("\n");
        }
        return new String(categoryInfo);
    }
}

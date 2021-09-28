package category;

import java.util.ArrayList;

import product.Product;

public class Category {

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    private final String categoryName;
    private ArrayList<Product> products = new ArrayList<>();

    public String getCategoryName() {
        return categoryName;
    }

    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public void addProducts(ArrayList<Product> newProducts) {
        for (Product newProduct : newProducts) {
            addProduct(newProduct);
        }
    }

    private ArrayList<String> getProductsInfoInPrettyForm() {
        ArrayList<String> productsInfo = new ArrayList<>();
        for (Product product : products) {
            String productInfo = "-" + product.getName() + " - " + product.getRate() + "% - " + product.getPrice() + "$";
            productsInfo.add(productInfo);
        }
        return productsInfo;
    }

    @Override
    public String toString() {
        StringBuilder categoryInfoInPrettyForm = new StringBuilder();
        ArrayList<String> productsInfoInPrettyForm = getProductsInfoInPrettyForm();

        categoryInfoInPrettyForm.append("•");
        categoryInfoInPrettyForm.append(getCategoryName());
        categoryInfoInPrettyForm.append("\n");

        for (String productInfoInPrettyForm : productsInfoInPrettyForm) {
            categoryInfoInPrettyForm.append("\t");
            categoryInfoInPrettyForm.append(productInfoInPrettyForm);
            categoryInfoInPrettyForm.append("\n");
        }

        return new String(categoryInfoInPrettyForm);
    }
}

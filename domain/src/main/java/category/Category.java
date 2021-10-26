package category;

import product.Product;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Objects;

public class Category {

    private int categoryId;
    private CategoryName categoryName;

    public Category() {
    }

    public int getId() {
         return categoryId;
    }

    public void setId(int categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryName getName() {
        return categoryName;
    }

    public void setName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

//    public void addProduct(Product newProduct) {
//        if (products.contains(newProduct)) {
//            System.out.println("Product " + newProduct.getName() + " already exist in current category");
//            return;
//        }
//        products.add(newProduct);
//    }

//    public void addProducts(ArrayList<Product> newProducts) {
//        for (Product newProduct : newProducts) {
//            addProduct(newProduct);
//        }
//    }

//    public void delProduct(String delProductName) {
//        for (Product product: products) {
//            if (product.getName().equals(delProductName)) {
//                products.remove(product);
//                return;
//            }
//        }
//        System.out.println("Product " + delProductName + " was not found to be deleted");
//    }

//    public void delAllProducts() {
//        products.clear();
//    }
//
//    public ArrayList<Product> getAllProducts() {
//        return products;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }

//    @Override
//    public String toString() {
//        StringBuilder categoryInfo = new StringBuilder();
//
//        categoryInfo.append("•");
//        categoryInfo.append(getCategoryName());
//        categoryInfo.append("\n");
//
//        for (Product product : products) {
//            categoryInfo.append("\t");
//            categoryInfo.append(product.toString());
//            categoryInfo.append("\n");
//        }
//        return new String(categoryInfo);
//    }


    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName=" + categoryName +
                '}';
    }
}

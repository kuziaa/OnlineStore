package store;

import category.Category;
import product.Product;

import java.io.*;
import java.util.ArrayList;

public class Store {

    private ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<String> getCategoriesNames() {
        ArrayList<String> categoriesNames = new ArrayList<>();
        for (Category category : categories) {
            categoriesNames.add(category.getCategoryName());
        }
        return categoriesNames;
    }

    public void addCategory(Category newCategory) {
        if (isUniqueCategory(newCategory)) {
            categories.add(newCategory);
        } else {
            System.out.println("Category was not added. Category with such a name already existed");
        }
    }

    private boolean isUniqueCategory(Category newCategory) {
        String newCategoryName = newCategory.getCategoryName();
        for (Category category : categories) {
            String categoryName = category.getCategoryName();
            if (categoryName.equals(newCategoryName)) return false;
        }
        return true;
    }

    public void addCategoriesFromFile(String fileAddress) {
        ArrayList<String> newCategoriesClassNames = loadNewCategoriesNamesFromFile(fileAddress);
        for (String newCategoryClassName : newCategoriesClassNames) {
            try {
                Class<?> clazz = Class.forName("category." + newCategoryClassName);
                addCategoryByReflection(clazz);
            } catch (ClassNotFoundException e) {
                System.out.println("Class with name " + newCategoryClassName + " was not found.");
            }
        }
    }

    private ArrayList<String> loadNewCategoriesNamesFromFile(String fileAddress) {
        ArrayList<String> CategoriesNames = new ArrayList<>();
        try {
            File file = new File(fileAddress);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                CategoriesNames.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileAddress + " was not found");
        } catch (IOException e) {
            System.out.println("There is some problems with file reading" + fileAddress + "\n" + e);
        }
        return CategoriesNames;
    }

    private void addCategoryByReflection(Class<?> newCategoryReflection) {
        try {
            addCategory((Category) newCategoryReflection.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Cannot create object from class " + newCategoryReflection.getName() + "\n" + e);
        }
    }

    public void addProductInCategoryByName(Product newProduct, String categoryName) {
        for (Category category : categories) {
            if (category.getCategoryName().equals(categoryName)) {
                category.addProduct(newProduct);
            }
        }
    }

    public void addProductsInCategoryByName(ArrayList<Product> newProducts, String categoryName) {
        for (Category category : categories) {
            if (category.getCategoryName().equals(categoryName)) {
                category.addProducts(newProducts);
            }
        }
    }

    public void showInfo() {
        for (Category category : categories) {
            System.out.println(category);
        }
    }
}

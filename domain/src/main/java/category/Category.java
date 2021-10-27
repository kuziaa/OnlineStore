package category;

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

    @Override
    public String toString() {
        return categoryName.toString();
    }
}

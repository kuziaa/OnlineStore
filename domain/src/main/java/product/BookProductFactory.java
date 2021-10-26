package product;

import category.Category;
import category.CategoryName;

public class BookProductFactory implements ProductFactory {

    long categoryId;

    BookProductFactory(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.book().title();
    }

    @Override
    public long getCategoryId() {
        return categoryId;
    }
}

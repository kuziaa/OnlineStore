package product;

import category.Category;
import category.CategoryName;

public class AnimalProductFactory implements ProductFactory {

    long categoryId;

    AnimalProductFactory(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.animal().name();
    }

    @Override
    public long getCategoryId() {
        return categoryId;
    }
}

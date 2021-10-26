package product;

import category.Category;
import category.CategoryName;

public class FruitProductFactory implements ProductFactory {

    long categoryId;

    FruitProductFactory(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.food().fruit();
    }

    @Override
    public long getCategoryId() {
        return categoryId;
    }
}

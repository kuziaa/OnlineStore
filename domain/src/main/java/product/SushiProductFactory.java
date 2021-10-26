package product;

import category.Category;
import category.CategoryName;

public class SushiProductFactory implements ProductFactory {

    long categoryId;

    SushiProductFactory(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.food().sushi();
    }

    @Override
    public long getCategoryId() {
        return categoryId;
    }
}

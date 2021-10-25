package product;

import category.Category;

public class SushiProductFactory implements ProductFactory {
    @Override
    public String getName() {
        return faker.food().sushi();
    }

    @Override
    public long getCategoryId() {
        return Category.getId("Sushi");
    }
}

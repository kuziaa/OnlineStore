package product;

import category.Category;

public class BeerProductFactory implements ProductFactory {

    @Override
    public String getName() {
        return faker.beer().name();
    }

    @Override
    public long getCategoryId() {
        return Category.getId("Beer");
    }
}

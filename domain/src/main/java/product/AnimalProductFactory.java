package product;

import category.Category;

public class AnimalProductFactory implements ProductFactory {

    @Override
    public String getName() {
        return faker.animal().name();
    }

    @Override
    public long getCategoryId() {
        return Category.getId("Animal");
    }
}

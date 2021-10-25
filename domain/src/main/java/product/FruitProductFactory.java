package product;

import category.Category;

public class FruitProductFactory implements ProductFactory {

    @Override
    public String getName() {
        return faker.food().fruit();
    }

    @Override
    public long getCategoryId() {
        return Category.getId("Fruit");
    }
}

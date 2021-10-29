package product;

public class FruitProductFactory implements ProductFactory {

    int categoryId;

    FruitProductFactory(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.food().fruit();
    }

    @Override
    public int getCategoryId() {
        return categoryId;
    }
}

package product_factory;

public class AnimalProductFactory implements ProductFactory {

    int categoryId;

    AnimalProductFactory(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.animal().name();
    }

    @Override
    public int getCategoryId() {
        return categoryId;
    }
}

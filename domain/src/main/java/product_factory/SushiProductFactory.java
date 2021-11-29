package product_factory;

public class SushiProductFactory implements ProductFactory {

    int categoryId;

    SushiProductFactory(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.food().sushi();
    }

    @Override
    public int getCategoryId() {
        return categoryId;
    }
}

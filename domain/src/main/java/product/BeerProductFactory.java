package product;

public class BeerProductFactory implements ProductFactory {

    long categoryId;

    BeerProductFactory(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.beer().name();
    }

    @Override
    public long getCategoryId() {
        return categoryId;
    }
}

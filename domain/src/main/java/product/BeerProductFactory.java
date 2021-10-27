package product;

public class BeerProductFactory implements ProductFactory {

    int categoryId;

    BeerProductFactory(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.beer().name();
    }

    @Override
    public int getCategoryId() {
        return categoryId;
    }
}

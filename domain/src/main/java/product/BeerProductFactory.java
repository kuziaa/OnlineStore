package product;

public class BeerProductFactory implements ProductFactory {

    @Override
    public String getName() {
        return faker.beer().name();
    }
}

package product;

public class SushiProductFactory implements ProductFactory {
    @Override
    public String getName() {
        return faker.food().sushi();
    }
}

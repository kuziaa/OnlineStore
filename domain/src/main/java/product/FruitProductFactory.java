package product;

public class FruitProductFactory implements ProductFactory {

    @Override
    public String getName() {
        return faker.food().fruit();
    }
}

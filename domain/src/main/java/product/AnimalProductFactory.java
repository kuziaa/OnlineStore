package product;

public class AnimalProductFactory implements ProductFactory {

    @Override
    public String getName() {
        return faker.animal().name();
    }
}

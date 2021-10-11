package product;

public class BookProductFactory implements ProductFactory {
    @Override
    public String getName() {
        return faker.book().title();
    }
}

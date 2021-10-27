package product;

public class BookProductFactory implements ProductFactory {

    int categoryId;

    BookProductFactory(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return faker.book().title();
    }

    @Override
    public int getCategoryId() {
        return categoryId;
    }
}

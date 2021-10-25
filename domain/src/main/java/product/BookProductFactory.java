package product;

import category.Category;

public class BookProductFactory implements ProductFactory {
    @Override
    public String getName() {
        return faker.book().title();
    }

    @Override
    public long getCategoryId() {
        return Category.getId("Book");
    }
}

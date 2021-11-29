package product_factory;

import entity.CategoryName;

public class ProductFactories {
    public static ProductFactory getProductFactory(CategoryName categoryName, int categoryId) {
        switch (categoryName) {
            case ANIMAL:
                return new AnimalProductFactory(categoryId);
            case BEER:
                return new BeerProductFactory(categoryId);
            case BOOK:
                return new BookProductFactory(categoryId);
            case FRUIT:
                return new FruitProductFactory(categoryId);
            case SUSHI:
                return new SushiProductFactory(categoryId);
            default:
                throw new RuntimeException("Unknown product factory " + categoryName);
        }
    }
}

package product;

public class ProductFactories {
    public static ProductFactory getProductFactory(String categoryName) {
        switch (categoryName) {
            case "Animal":
                return new AnimalProductFactory();
            case "Beer":
                return new BeerProductFactory();
            case "Book":
                return new BookProductFactory();
            case "Fruit":
                return new FruitProductFactory();
            case "Sushi":
                return new SushiProductFactory();
            default:
                throw new RuntimeException("Unknown product factory " + categoryName);
        }
    }
}

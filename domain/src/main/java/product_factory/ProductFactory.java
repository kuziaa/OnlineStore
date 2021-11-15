package product_factory;

import com.github.javafaker.Faker;
import entity.Product;

public interface ProductFactory {

    Faker faker = new Faker();

    String getName();

    int getCategoryId();

    default double getPrice(){
        return faker.number().randomDouble(2, 30, 300);
    }

    default double getRate(){
        return faker.number().randomDouble(2, 5, 25);
    }

    default Product getProduct() {
        Product product = new Product();
        product.setName(getName());
        product.setPrice(getPrice());
        product.setRate(getRate());
        product.setCategoryId(getCategoryId());
        return product;
    }
}

package product;

import com.github.javafaker.Faker;

public interface ProductFactory {

    Faker faker = new Faker();

    String getName();

    long getCategoryId();

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
        product.setCategory_id(getCategoryId());
        return product;
    }
}

package product;

import com.github.javafaker.Faker;

public interface ProductFactory {

    Faker faker = new Faker();

    default Product getProduct() {
        return new Product(getName(), getPrice(), getRate());
    }

    String getName();

    default double getPrice(){
        return faker.number().randomDouble(2, 30, 300);
    }

    default double getRate(){
        return faker.number().randomDouble(2, 5, 25);
    }
}

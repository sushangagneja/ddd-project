package domain;

public class Product {
    private final String name;
    private final Price price;
    private final double weight;

    public Product(String name, Price price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Price getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}

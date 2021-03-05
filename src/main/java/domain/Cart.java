package domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items;
    private final List<Product> removedProducts;

    public Cart() {
        this.items = new ArrayList<>();
        this.removedProducts = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
        removedProducts.remove(item.getProduct());
    }

    public void remove(Item item) {
        items.remove(item);
        removedProducts.add(item.getProduct());
    }

    public Boolean contains(Item item) {
        return items.contains(item);
    }

    public List<Product> getRemovedProducts() {
        return removedProducts;
    }
}

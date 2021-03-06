package domain.domain_service;

import domain.Cart;
import domain.Item;
import domain.Order;
import domain.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderPlacer {
	public Order placeOrder(Cart cart) {
		List<Item> items = cart.checkout();
		List<Product> products = new ArrayList<>();

		items.forEach(item -> {
			Integer quantity = item.getQuantity();
			while (quantity > 0) {
				products.add(item.getProduct());
				quantity--;
			}
		});

		return new Order(products);
	}
}

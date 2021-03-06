package domain;

import domain.Product;

import java.util.List;
import java.util.UUID;

public class Order {
	private List<Product> products;
	private UUID id;

	public Order(List<Product> products) {
		this.products = products;
		this.id = UUID.randomUUID();
	}
}

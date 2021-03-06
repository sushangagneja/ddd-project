package domain;

import domain.Product;

import java.util.Currency;
import java.util.List;
import java.util.UUID;

public class Order {
	private List<Product> products;
	private UUID id;

	public Order(List<Product> products) {
		this.products = products;
		this.id = UUID.randomUUID();
	}

	public Price totalCost() {
		Currency currency = products.get(0).getPrice().getCurrency();
		Price totalPrice = new Price(currency, 0.0);
		double totalWeight = 0.0;

		for (Product product:products) {
			Price price = product.getPrice();
			double weight = product.getWeight();
			totalPrice.add(price);
			totalWeight+=weight;
		}

		return totalPrice.add(new Price(currency, totalWeight * 0.01));
	}
}

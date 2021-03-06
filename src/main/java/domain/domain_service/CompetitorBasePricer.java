package domain.domain_service;

import domain.Price;

import java.util.Currency;
import java.util.HashMap;

public class CompetitorBasePricer {
	private HashMap<String, Price> competitorsPrice = new HashMap<>();
	private static final double DISCOUNT_PERCENTAGE = 10;

	public CompetitorBasePricer() {
		competitorsPrice.put("IPad Pro", new Price(Currency.getInstance("INR"), 200));
		competitorsPrice.put("Hero Ink Pen", new Price(Currency.getInstance("INR"), 300));
		competitorsPrice.put("GM Cricket Bat", new Price(Currency.getInstance("INR"), 400));
	}

	public Price adjustPrice(String productName, Price price) {
		if (competitorsPrice.containsKey(productName)) {
			return competitorsPrice.get(productName).reduceBy(DISCOUNT_PERCENTAGE);
		}
		return price;
	}
}

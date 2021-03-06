package domain;

import java.util.Currency;

public class Price {
	private final Currency currency;
	private final double amount;

	public Price(Currency currency, double amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public Price reduceBy(double percentage) {
		return new Price(currency, amount - amount/100.0 * percentage);
	}
}

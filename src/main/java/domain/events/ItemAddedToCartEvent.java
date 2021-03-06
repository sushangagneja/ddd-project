package domain.events;

import java.util.Objects;

public class ItemAddedToCartEvent implements DomainEvent {
	private final String name;
	private final Integer quantity;

	public ItemAddedToCartEvent(String name, Integer quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ItemAddedToCartEvent that = (ItemAddedToCartEvent) o;
		return name.equals(that.name) &&
						quantity.equals(that.quantity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, quantity);
	}
}

package domain.events;

import java.util.Objects;

public class ItemRemovedFromCartEvent implements DomainEvent {
	private final String name;

	public ItemRemovedFromCartEvent(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ItemRemovedFromCartEvent that = (ItemRemovedFromCartEvent) o;
		return name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}

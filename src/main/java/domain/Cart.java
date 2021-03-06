package domain;

import domain.events.DomainEvent;
import domain.events.ItemAddedToCartEvent;
import domain.events.ItemRemovedFromCartEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private final List<Item> items;
    private final UUID id;

    private List<DomainEvent> domainEvents;

    public Cart() {
        this.id = UUID.randomUUID();
        this.items = new ArrayList<>();
        domainEvents = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
        ItemAddedToCartEvent itemAddedToCartEvent = new ItemAddedToCartEvent(item.getProduct().getName(), item.getQuantity());
        apply(itemAddedToCartEvent);
    }

    public void remove(Item item) {
        items.remove(item);
        ItemRemovedFromCartEvent itemRemovedFromCartEvent = new ItemRemovedFromCartEvent(item.getProduct().getName());
        apply(itemRemovedFromCartEvent);
    }

    private void apply(DomainEvent domainEvent) {
        domainEvents.add(domainEvent);
    }

    public Boolean contains(Item item) {
        return items.contains(item);
    }

    public List<DomainEvent> getDomainEvents() {
        return domainEvents;
    }
}

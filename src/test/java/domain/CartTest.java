package domain;

import domain.events.ItemRemovedFromCartEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private final Cart cart = new Cart();

    @Test
    void shouldAddItemsToCart() {
        final Product someProduct = new Product("IPad Pro");
        final Product someOtherProduct = new Product("Hero Ink Pen");
        final Product yetAnotherProduct = new Product("GM Cricket Bat");
        final Item someItem = new Item(someProduct, 1);
        final Item someOtherItem = new Item(someOtherProduct, 1);
        final Item yetAnotherItem = new Item(yetAnotherProduct, 1);

        cart.add(someItem);
        cart.add(someOtherItem);
        cart.add(yetAnotherItem);

        assertTrue(cart.contains(someItem));
        assertTrue(cart.contains(someOtherItem));
        assertTrue(cart.contains(yetAnotherItem));
    }

    @Test
    void shouldRemoveItemFromCart() {
        final Product someProduct = new Product("IPad Pro");
        final Product someOtherProduct = new Product("Hero Ink Pen");
        final Item someItem = new Item(someProduct, 1);
        final Item someOtherItem = new Item(someOtherProduct, 1);
        cart.add(someItem);
        cart.add(someOtherItem);

        cart.remove(someItem);

        assertFalse(cart.contains(someItem));
        assertTrue(cart.contains(someOtherItem));
    }

    @Test
    void shouldReturnRemovedItemsFromCart() {
        final Product someProduct = new Product("IPad Pro");
        final Product someOtherProduct = new Product("Hero Ink Pen");
        final Item someItem = new Item(someProduct, 1);
        final Item someOtherItem = new Item(someOtherProduct, 1);
        cart.add(someItem);
        cart.add(someOtherItem);

        cart.remove(someItem);

        assertTrue(cart.getDomainEvents().contains(new ItemRemovedFromCartEvent(someProduct.getName())));
    }

    @Test
    void shouldReturnFalseWhenItemsInTwoCartsAreEqual() {
        Cart firstCart = new Cart();

        Cart secondCart = new Cart();

        final Product someProduct = new Product("IPad Pro");
        final Item someItem = new Item(someProduct, 1);
        final Item someOtherItem = new Item(someProduct, 1);

        firstCart.add(someItem);

        secondCart.add(someOtherItem);

        assertNotEquals(firstCart, secondCart);
    }
}

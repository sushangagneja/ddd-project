package domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

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

        assertEquals(Collections.singletonList(someProduct), cart.getRemovedProducts());
    }
}
package domain;

import domain.domain_service.CompetitorBasePricer;
import domain.domain_service.OrderPlacer;
import domain.events.ItemRemovedFromCartEvent;
import org.junit.jupiter.api.Test;

import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private final Cart cart = new Cart();
    private final CompetitorBasePricer competitorBasePricer = new CompetitorBasePricer();
    private final OrderPlacer orderPlacer = new OrderPlacer();
    String iPad_pro = "IPad Pro";
    String  hero_ink_pen = "Hero Ink Pen";
    String gm_cricket_bat = "GM Cricket Bat";

    @Test
    void shouldAddItemsToCart() {

        final Product someProduct = new Product(iPad_pro, competitorBasePricer.adjustPrice(iPad_pro, new Price(Currency.getInstance("INR"), 10)));
        final Product someOtherProduct = new Product(hero_ink_pen, competitorBasePricer.adjustPrice(hero_ink_pen, new Price(Currency.getInstance("INR"), 20)));
        final Product yetAnotherProduct = new Product(gm_cricket_bat, competitorBasePricer.adjustPrice(hero_ink_pen, new Price(Currency.getInstance("INR"), 30)));
        final Item someItem = new Item(someProduct, 1);
        final Item someOtherItem = new Item(someOtherProduct, 1);
        final Item yetAnotherItem = new Item(yetAnotherProduct, 1);


        cart.add(someItem);
        cart.add(someOtherItem);
        cart.add(yetAnotherItem);

        orderPlacer.placeOrder(cart);

        assertTrue(cart.contains(someItem));
        assertTrue(cart.contains(someOtherItem));
        assertTrue(cart.contains(yetAnotherItem));
    }

    @Test
    void shouldRemoveItemFromCart() {

        final Product someProduct = new Product(iPad_pro, competitorBasePricer.adjustPrice(hero_ink_pen, new Price(Currency.getInstance("INR"), 10)));
        final Product someOtherProduct = new Product(hero_ink_pen, competitorBasePricer.adjustPrice(hero_ink_pen, new Price(Currency.getInstance("INR"), 10)));
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
        final Product someProduct = new Product(iPad_pro, competitorBasePricer.adjustPrice(iPad_pro, new Price(Currency.getInstance("INR"), 10)));
        final Product someOtherProduct = new Product(hero_ink_pen, competitorBasePricer.adjustPrice(hero_ink_pen, new Price(Currency.getInstance("INR"), 10)));
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

        final Product someProduct = new Product(iPad_pro, competitorBasePricer.adjustPrice(iPad_pro, new Price(Currency.getInstance("INR"), 10)));
        final Item someItem = new Item(someProduct, 1);
        final Item someOtherItem = new Item(someProduct, 1);

        firstCart.add(someItem);

        secondCart.add(someOtherItem);

        assertNotEquals(firstCart, secondCart);
    }
}

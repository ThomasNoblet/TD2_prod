package fr.iut;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TestShoppingCart {

    @Test
    public void addItem(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);

        Assert.assertEquals(shoppingCart.getContent(), new HashMap<Item, Integer>(){{
            put(carot, 1);
        }});
    }

    @Test
    public void computePriceWithoutTaxes(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        Assert.assertEquals(shoppingCart.getPriceWithoutTaxes(), 2.5, 0.0001);
    }
}

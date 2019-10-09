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
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("bananas", 5), 3);
        Assert.assertEquals(shoppingCart.getPriceWithoutTaxes(), 42.5, 0.0001);
    }

    @Test
    public void computePriceWithTaxesFR(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("bananas", 5), 3);

        Assert.assertEquals(shoppingCart.getPriceWithTaxes(Country.FR), 51, 0.0001);
    }

    @Test
    public void computePriceWithTaxesDK(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("bananas", 5), 3);

        Assert.assertEquals(shoppingCart.getPriceWithTaxes(Country.DK), 53.125, 0.0001);
    }

    @Test
    public void computePriceWithTaxesAndReduction(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("bananas", 5), 1000);

        Assert.assertEquals(shoppingCart.getPriceWithTaxesAndReduction(Country.FR), 5731.35, 0.0001);
    }
}

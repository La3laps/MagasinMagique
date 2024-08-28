package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

//    @Test
//    void foo() {
//        String name = "foo";
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals(name, app.items[0].name);
//    }

    @Test
    void Kryptonite() {
        String name = "Kryptonite";
        Item[] items = new Item[] { new Item("Kryptonite", 4, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void KryptoniteSellInDecrease() {
        String name = "Kryptonite";
        Item[] items = new Item[] { new Item("Kryptonite", 3, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    void KryptoniteSellInDecreaseTwice() {
        String name = "Kryptonite";
        Item[] items = new Item[] { new Item("Kryptonite", 2, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void KryptoniteSellInDecreaseBelowZero() {
        String name = "Kryptonite";
        Item[] items = new Item[] { new Item("Kryptonite", -3, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);
    }

}

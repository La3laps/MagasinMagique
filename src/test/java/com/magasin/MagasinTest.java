package com.magasin;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/* ! Basic product rules:
* - SellIn decreases by one.
* - Quality decreases by one, if SellIn is positive.
* - Quality decreases by two, if SellIn is negative.
* - Quality doesn't decrease below zero.
! */

class MagasinTest {

    @Test
    @DisplayName("Foo")
    void foo() {
        String name = "foo";
        Item[] items = new Item[] { new Item(name, 0 , 50 ) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("Foo")
    void fooQualityDecrease() {
        String name = "foo";
        Item[] items = new Item[] { new Item(name, 10 , 10 ) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    @DisplayName("Foo")
    void fooQualityDecreaseTwice() {
        String name = "foo";
        Item[] items = new Item[] { new Item(name, -1 , 10 ) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    @DisplayName("Foo")
    void fooQualityDoesntDecreaseBelowZero() {
        String name = "foo";
        Item[] items = new Item[] { new Item(name, 2 , 0 ) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    /* ? Pouvoirs magique
    * quality decreases by two if SellIn is positive,
    * quality decreases by four if SellIn is negative,
    * quality doesn't decrease below zero.
    ? */

    @Test
    @DisplayName("PM - Quality decreases by two & Sellin>0")
    void qualityDecreasesByTwo() {
        String name = "Pouvoirs magiques";
        Item[] items = new Item[] { new Item(name, 2 , 10 ) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    @DisplayName("PM - Quality decreases by four & Sellin<=0")
    void qualityDecreasesByFour() {
        String name = "Pouvoirs magiques";
        Item[] items = new Item[] { new Item(name, -1 , 10 ) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    @DisplayName("PM - Quality doesn't decrease below zero.")
    void qualityDoesntDecreaseBelowZero() {
        String name = "Pouvoirs magiques";
        Item[] items = new Item[] { new Item(name, 5 , 0 ) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("Comté")
    void comteCheese() {
        Item[] items = new Item[] { new Item("Comté", 4, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    @DisplayName("Comté")
    void comteCheese1() {
        Item[] items = new Item[] { new Item("Comté", 0, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    @DisplayName("Comté")
    void comteCheese2() {
        Item[] items = new Item[] { new Item("Comté", 7, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(6, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    @Test
    @DisplayName("Kryptonite")
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
    @DisplayName("Kryptonite")
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
    @DisplayName("Kryptonite")
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
    @DisplayName("Kryptonite")
    void KryptoniteSellInDecreaseBelowZero() {
        String name = "Kryptonite";
        Item[] items = new Item[] { new Item("Kryptonite", -3, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);
    }

    @Test
    @DisplayName("Pass VIP")
    void SellIn_10_or_less() {
        // Cas où sellIn est égal à 10
        Item item = new Item("Pass VIP Concert", 10, 20);
        Magasin app = new Magasin(new Item[] { item });
        app.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);

        // Cas où sellIn est inférieur à 10
        item = new Item("Pass VIP Concert", 9, 20);
        app = new Magasin(new Item[] { item });
        app.updateQuality();
        assertEquals(8, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    @DisplayName("Pass VIP")
    void SellIn_5_or_less() {
        // Cas où sellIn est égal à 10
        Item item = new Item("Pass VIP Concert", 5, 20);
        Magasin app = new Magasin(new Item[] { item });
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(23, item.quality);

        // Cas où sellIn est inférieur à 10
        item = new Item("Pass VIP Concert", 4, 20);
        app = new Magasin(new Item[] { item });
        app.updateQuality();
        assertEquals(3, item.sellIn);
        assertEquals(23, item.quality);
    }
    @Test
    @DisplayName("Pass VIP")
    void SellIn_68_or_less() {
        // Cas où sellIn est égal à 10
        Item item = new Item("Pass VIP Concert", 68, 20);
        Magasin app = new Magasin(new Item[] { item });
        app.updateQuality();
        assertEquals(67, item.sellIn);
        assertEquals(21, item.quality);

        // Cas où sellIn est inférieur à 10
        item = new Item("Pass VIP Concert", 67, 20);
        app = new Magasin(new Item[] { item });
        app.updateQuality();
        assertEquals(66, item.sellIn);
        assertEquals(21, item.quality);
    }
}

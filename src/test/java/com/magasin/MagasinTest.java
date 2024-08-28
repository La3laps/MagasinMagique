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
    @DisplayName("Generic function")
    void foo() {
        String name = "foo";
        Item[] items = new Item[] { new Item(name, 0 , 0 ) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @DisplayName("Quality decreases by 1 & SellIn positive")
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
    @DisplayName("Quality decreases by 2 & SellIn negative")
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
    @DisplayName("Quality doesn't decrease below zero")
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
    @DisplayName("PM - Quality decreases by four & Sellin<=0")
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
    @DisplayName("Tests de Rémi")
    void comteCheese() {
        Item[] items = new Item[] { new Item("Comté", 4, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    @DisplayName("n°1")
    void comteCheese1() {
        Item[] items = new Item[] { new Item("Comté", 0, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    @DisplayName("n°2")
    void comteCheese2() {
        Item[] items = new Item[] { new Item("Comté", 7, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(6, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}

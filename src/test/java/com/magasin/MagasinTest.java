package com.magasin;
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

}

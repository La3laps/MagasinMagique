package com.magasin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

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

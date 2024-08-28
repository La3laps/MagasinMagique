package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
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

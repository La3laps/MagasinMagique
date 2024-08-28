package com.magasin;

public class Item {

    public String name;

    public int sellIn; // nombre de jours qui reste

    public int quality; // quality change tous les jours

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}

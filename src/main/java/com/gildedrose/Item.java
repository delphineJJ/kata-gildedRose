package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void increaseQuality(int addedQuality) {
        this.quality = Math.min(quality + addedQuality, MAX_QUALITY);
    }

    public void setQualityAtMinimum() {
        this.quality = MIN_QUALITY;
    }

    public void decreaseQuality(int removedQuality) {
        this.quality = Math.max(quality - removedQuality, MIN_QUALITY);
    }

    public boolean hasReachedSellIn(){
        return this.sellIn < 0;
    }
}

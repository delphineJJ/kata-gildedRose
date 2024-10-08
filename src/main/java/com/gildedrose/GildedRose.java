package com.gildedrose;

class GildedRose {
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final int SEUIL_MAXIMAL_QUALITE = 50;
    private static final int SEUIL_MINIMAL_QUALITE = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (SULFURAS_HAND_OF_RAGNAROS.equals(item.name)) {
                continue;
            }
            item.sellIn = item.sellIn - 1;
            switch (item.name) {
                case AGED_BRIE:
                    updatedAgedBrie(item);
                    break;
                case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                    updateBackstagePasses(item);
                    break;
                default:
                    updateClassicItem(item);
                    break;
            }
        }
    }

    private void updateClassicItem(Item item) {
        item.quality = decreaseQuality(item);
        if (hasReachedSellIn(item)) {
            item.quality = decreaseQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        if (item.sellIn >= 10) {
            item.quality = increaseQuality(item);
        } else if (item.sellIn >= 5) {
            item.quality = increaseQuality(item, 2);
        } else if (item.sellIn >= 0) {
            item.quality = increaseQuality(item, 3);
        } else {
            item.quality = SEUIL_MINIMAL_QUALITE;
        }
    }

    private void updatedAgedBrie(Item item) {
        item.quality = increaseQuality(item);
        if (hasReachedSellIn(item)) {
            item.quality = increaseQuality(item);
        }
    }

    private static int decreaseQuality(Item item) {
        return Math.max(item.quality - 1, SEUIL_MINIMAL_QUALITE);
    }

    private boolean hasReachedSellIn(Item item) {
        return item.sellIn < 0;
    }

    private int increaseQuality(Item item) {
        return increaseQuality(item, 1);
    }

    private int increaseQuality(Item item, int addedQuality) {
        return Math.min(item.quality + addedQuality, SEUIL_MAXIMAL_QUALITE);
    }
}

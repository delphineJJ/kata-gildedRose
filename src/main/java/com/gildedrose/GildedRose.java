package com.gildedrose;

class GildedRose {
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";

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
        item.decreaseQuality(1);
        if (item.hasReachedSellIn()) {
            item.decreaseQuality(1);
        }
    }

    private void updateBackstagePasses(Item item) {
        if (item.sellIn >= 10) {
            item.increaseQuality(1);
        } else if (item.sellIn >= 5) {
            item.increaseQuality(2);
        } else if (item.sellIn >= 0) {
            item.increaseQuality(3);
        } else {
            item.setQualityAtMinimum();
        }
    }

    private void updatedAgedBrie(Item item) {
        item.increaseQuality(1);
        if (item.hasReachedSellIn()) {
            item.increaseQuality(1);
        }
    }
}

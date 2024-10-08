package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        // Given
        GildedRose app = new GildedRose(createItem());
        GildedRoseGoldenMaster goldenMaster = new GildedRoseGoldenMaster(createItem());

        //When
        IntStream.range(0, 100).forEach(d -> {
            app.updateQuality();
            goldenMaster.updateQuality();
            // Then
            IntStream.range(0, app.items.length - 1)
                .forEach(index ->
                    assertEquals(goldenMaster.items[index].toString(), app.items[index].toString()));
        });
    }

    private Item[] createItem() {
        return new Item[]{new Item("foo", 0, 0),
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
    }

}

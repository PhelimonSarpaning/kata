//golden master testing

package com.gildedrose;

import java.util.Random;
import com.gildedrose.qualitycontrol.QualityControlOffice;
import com.gildedrose.sellincontrol.SellInControl;

import org.approvaltests.Approvals;
import org.junit.Test;

public class GildedRoseTest {
    private QualityControlOffice qualityControlOffice;
	private SellInControl sellInControl;
    private static final int FIXED_SEED = 100;
    private static final int NUMBER_OF_RANDOM_ITEMS = 2000;
    private static final int MINIMUM = -50;
    private static final int MAXIMUM = 101;
    private Random random = new Random(FIXED_SEED);
    private String[] itemNames = {"+5 Dexterity Vest",
                      "Aged Brie",
                      "Elixir of the Mongoose",
                      "Sulfuras, Hand of Ragnaros",
                      "Backstage passes to a TAFKAL80ETC concert",
                      "Conjured Mana Cake"};
   
    @Test
    public void foo() {
        Item[] items = generateRandomItems(NUMBER_OF_RANDOM_ITEMS);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        //assertEquals("foo", app.items[0].name);
        //Approvals.verifyAll("item", items);
        Approvals.verify(getStringRepresentationFor(items));
    }
    
    private Item[] generateRandomItems(int totalNumberOfRandomItems) {
        Item [] items = new Item[totalNumberOfRandomItems];
        for (int cnt = 0; cnt < totalNumberOfRandomItems; cnt++) {
            items[cnt] = new Item(itemName(), sellIn(), quality());
        }
        return items;
    }
    private String itemName() {
        return itemNames[0 + random.nextInt(itemNames.length)];
    }

    private int sellIn() {
        return randomNumberBetween(MINIMUM, MAXIMUM);
    }

    private int quality() {
        return randomNumberBetween(MINIMUM, MAXIMUM);
    }
    private int randomNumberBetween(int minimum, int maximum) {
        return minimum + random.nextInt(maximum);
    }
    private String getStringRepresentationFor(Item [] items) {
        StringBuilder builder = new StringBuilder();
        for (Item item : items) {
            builder.append(item).append("\r");
        }
        return builder.toString();
    }
}

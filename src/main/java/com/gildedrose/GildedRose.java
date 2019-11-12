package com.gildedrose;

import com.gildedrose.qualitycontrol.QualityControl;
import com.gildedrose.qualitycontrol.QualityControlOffice;
import com.gildedrose.sellincontrol.SellInControl;

class GildedRose {
    // private QualityControlOffice qualityControlOffice;
    // private SellInControl sellInControl;
	// //private Item[] items;
    
    // //  public GildedRose(Item[] items) {
    // //      this.items = items;
    // //  }
	
	// public GildedRose(QualityControlOffice qualityControl, SellInControl sellInControl) {
	// 	this.qualityControlOffice = qualityControl;
	// 	this.sellInControl = sellInControl;
	// }

	// public void updateQuality(Item [] items) {
        
	// 	for (Item item : items) {
	// 		udpateSellInFor(item);
	// 		updateQualityFor(item);
	// 	}
	// }
	
	// private void updateQualityFor(Item item) {
	// 	QualityControl qualityControl = qualityControlOffice.qualityControlFor(item);
	// 	qualityControl.updateQualityFor(item);
	// }

	// private void udpateSellInFor(Item item) {
	// 	sellInControl.updateSellInFor(item);
	// }
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!nameCheck(items[i].name) && !nameCheck(items[i].name)) {
                if (this.greaterCheck(items[i].quality)) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                items[i].quality =  this.combineIf(items[i].quality,items[i].name, items[i].sellIn);
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (this.greaterCheck(items[i].quality ) && !items[i].name.equals("Sulfuras, Hand of Ragnaros"))  {
        
                                items[i].quality = items[i].quality - 1;
            
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (this.lesserCheck(items[i].quality)) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    public int combineIf(int quality, String name, int sellIn){
        if (this.lesserCheck(quality)) {
           quality = quality + 1;

            if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (sellIn < 11) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }
            }
        }
        return quality;
    }
    
    public boolean greaterCheck(int check){
        if(check > 0){
            return true;
        }
        return false;
    }

    public boolean lesserCheck(int check){
        if(check < 50){
            return true;
        }
        return false;
    }
    public boolean qualityCheck(int check){
        if(check > 0 || check < 50){
            return true;
        }
        return false;
    }

    public boolean nameCheck(String name){
        switch(name){
            case "Aged Brie":
            return true;
            case "Backstage passes to a TAFKAL80ETC concert":
            return true;
            


        }
        return false;
    }
}
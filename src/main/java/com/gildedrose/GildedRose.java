package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            this.sulfur_check(items[i].name, items[i].quality, items[i].sellIn);
            this.other_check(items[i].sellIn, items[i].name, items[i].quality);    
        }
    }


    public void other_check(int sellIn, String name, int quality){
        if (sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (this.greaterCheck(quality ) && !name.equals("Sulfuras, Hand of Ragnaros"))  {
    
                            quality = quality - 1;
        
                    }
                } else {
                    quality = quality - quality;
                }
            } else {
                if (this.lesserCheck(quality)) {
                    quality = quality + 1;
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


    public  void sulfur_check(String name, int quality, int sellIn){
        if (!nameCheck(name) && !nameCheck(name)) {
            if (this.greaterCheck(quality)) {
                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    quality = quality - 1;
                }
            }
        } else {
            quality =  this.combineIf(quality,name,sellIn);
        }

        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            sellIn = sellIn - 1;
        }
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

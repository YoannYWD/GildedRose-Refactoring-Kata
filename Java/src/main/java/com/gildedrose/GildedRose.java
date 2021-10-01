package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static void decreaseQuality() {
        
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            //On commence par baisser le sellIn de 1 pour tous sauf Sulfuras
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn -= 1;
                if (items[i].quality > 50) {
                    items[i].quality = 50;
                }
                
                if (items[i].name.equals("Aged Brie")) {  //Cas Aged Brie, qualité qui augmente de 1 par jour
                    if (items[i].sellIn >= 0) {
                        items[i].quality += 1;
                    } else {
                        items[i].quality += 2;
                    }

                } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { //Cas Backstage passes to a TAFKAL80ETC concert
                    if (items[i].sellIn > 11) {
                        items[i].quality += 1;
                    } else if (items[i].sellIn < 11 && items[i].sellIn >= 6) {
                        items[i].quality += 2;
                    } else if (items[i].sellIn < 6 && items[i].sellIn >= 1) {
                        items[i].quality += 3;
                    } else if (items[i].sellIn <=0 ){
                        items[i].quality = 0;
                    }

                } else if (items[i].name.contains("Conjured")) { //Cas Conjured items
                    if (items[i].sellIn >= 0) {
                        items[i].quality -= 2;
                    } else {
                        items[i].quality -= 4;
                    }

                } else { //Cas des autres items
                    if (items[i].sellIn < 0) {
                        items[i].quality -= 2;
                    } else {
                        items[i].quality -= 1;
                    }
                    if (items[i].quality < 0) {
                        items[i].quality = 0;
                    }
                }
            }
            
        }
    }
}
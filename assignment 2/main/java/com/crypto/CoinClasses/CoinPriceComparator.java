package com.crypto.CoinClasses;

import java.util.Comparator;

public class CoinPriceComparator implements Comparator<Coin> {


    @Override
    public int compare(Coin c1, Coin c2) {
        if (c1.getPrice() > c2.getPrice()) {
            return -1;
        } else if (c1.getPrice() < c2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}

package com.crypto.TraderClasses;

import java.util.Comparator;

public class TraderProfitComparatorDescending implements Comparator<Trader> {
    @Override
    public int compare(Trader t1, Trader t2) {
        if (t1.getProfit() > t2.getProfit()) {
            return -1;
        } else if (t1.getProfit() < t2.getProfit()) {
            return 1;
        } else {
            return 0;
        }
    }
}

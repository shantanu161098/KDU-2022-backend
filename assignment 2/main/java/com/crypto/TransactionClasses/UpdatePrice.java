package com.crypto.TransactionClasses;

import com.crypto.AllExceptions.TimoutLimitExceededException;
import com.crypto.CoinClasses.Coin;

/**
 *  Here update transactions will be executed in process method.
 */

public class UpdatePrice extends Transactions {
    private Coin coin;
    private double price;


    public UpdatePrice(Coin coin, double price) {
        this.coin = coin;
        this.price = price;
    }

    public synchronized void process() throws InterruptedException, TimoutLimitExceededException {
        int tries = 0;
        /**
         * If a coin is in another transaction eg add volume or update price or buy sell (which will indirectly affect volume)
         * then current trading should be halted until the coin came out of transaction
         *
         */
        while (coin.isInTransaction() && tries < timeOutOfTransaction) {
            Thread.sleep(sleepTime);
            tries++;
        }
        if (tries > timeOutOfTransaction) {
            throw new TimoutLimitExceededException("Timeout");
        }
        coin.setInTransaction(true);
        coin.setPrice(price);
//        System.out.println("UPDATED " + coin.getSymbol() + " " + coin.getPrice());
        coin.setInTransaction(false);
    }

}

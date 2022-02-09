package com.crypto.TransactionClasses;

import com.crypto.AllExceptions.TimoutLimitExceededException;
import com.crypto.CoinClasses.Coin;

import java.util.ArrayList;

/**
 * Here add volume transaction will be executed in process method.
 */
public class AddVolume extends Transactions {
    private Coin coin;
    private long volume;


    public AddVolume(Coin coin, long volume) {
        this.coin = coin;
        this.volume = volume;
    }

    public synchronized void process() throws TimoutLimitExceededException, InterruptedException {

        int tries = 0;
        /**
         * If a coin is in another transaction eg add volume or update price or buy sell (which will indirectly affect volume)
         * then current trading should be halted until the coin came out of transaction
         */
        while (coin.isInTransaction() && tries < timeOutOfTransaction) {
            Thread.sleep(sleepTime);
            tries++;
        }
        if (tries > timeOutOfTransaction) {
            throw new TimoutLimitExceededException("Timeout");
        }


        if (coin.getCirculatingSupply() + volume > MaxCirculatingSupply) {
//            "Add volume exceeding the supply"
            return;
        }

        /**
         * lock acquired
         */
        coin.setInTransaction(true);
        coin.addCirculatingSupply((volume));
//        "Volume add " + coin.getSymbol();
        /**
         * lock released
         */
        coin.setInTransaction(false);
    }
}

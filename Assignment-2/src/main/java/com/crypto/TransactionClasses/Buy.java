package com.crypto.TransactionClasses;

import com.crypto.AllExceptions.TimoutLimitExceededException;
import com.crypto.CoinClasses.Coin;
import com.crypto.TraderClasses.Trader;

import java.util.ArrayList;

/**
 * (Please note commented code are intentionally given just for showing details)
 * Here buy transactions will be executed in process method.
 *
 */
public class Buy extends Transactions {
    private Trader trader;
    private Coin coin;
    private long quantity;


    public Buy(Trader trader, Coin coin, long quantity) {
        this.trader = trader;
        this.coin = coin;
        this.quantity = quantity;
    }

    public synchronized void process() {

        try {


            int tries = 0;
            /**
             * If a coin is in another transaction eg add volume or update price or buy sell (which will indirectly affect volume)
             * then current trading should be halted until the coin came out of transaction
             */
            while ((coin.isInTransaction() || coin.getCirculatingSupply() < quantity) && tries < timeOutOfTransaction) {
                Thread.sleep(sleepTime);
                tries++;
            }
            if (tries > timeOutOfTransaction) {
                throw new TimoutLimitExceededException("Timeout");
            }
            /**
             * lock acquired
             */
            coin.setInTransaction(true);
            hashCode.getBlockHash();
            coin.subtractCirculatingSupply(quantity);
            trader.addCoinInWallet(coin, quantity,coin.getPrice());

            /**
             * lock released
             */
            coin.setInTransaction(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}

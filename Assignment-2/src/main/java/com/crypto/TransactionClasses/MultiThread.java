package com.crypto.TransactionClasses;

import com.crypto.CoinClasses.Coin;
import com.crypto.App.MemoryLoader;
import com.crypto.TraderClasses.Trader;
import org.json.simple.JSONObject;

/**
 * (Please note commented code are intentionally given just for showing synchronisation)
 * Here is the implementation of multithreaded transaction
 *
 * Each transaction will be seperately executed
 *
 * Constraints:
 *  If trader is already in a transaction then the current thread will be in waiting state
 *  and will check if user is out of the transaction after sleeping time
 */
public class MultiThread implements Runnable {

    private JSONObject singleTransaction;
    private MemoryLoader memoryLoader;
    private Trader trader;
    private boolean isABuySell;
    private Coin coin;
    private int sleepingTime = 100;

    public MultiThread(JSONObject singleTransaction, MemoryLoader memoryLoader, Trader trader, boolean isABuySell) {
        this.singleTransaction = singleTransaction;
        this.memoryLoader = memoryLoader;
        this.trader = trader;
        this.isABuySell = isABuySell;

    }

    @Override
    public void run() {
        try {
            Transactions tx = new Transactions();

            /**
             * Waiting state if trader already is in a transaction
             */

            while (isABuySell && trader.isInTransaction()) {
                Thread.sleep(sleepingTime);
            }

            if (isABuySell) {
                /**
                 * Lock acquired
                 */
                trader.setInTransaction(true);
//                "Lock acquired " + trader.getFirstName()
                tx.transact(singleTransaction, memoryLoader);
//                "Lock released " + trader.getFirstName()
                /**
                 * Lock released
                 */
                trader.setInTransaction(false);
            } else {
                tx.transact(singleTransaction, memoryLoader);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

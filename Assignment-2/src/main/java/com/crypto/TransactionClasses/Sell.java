package com.crypto.TransactionClasses;

import com.crypto.AllExceptions.InsufficientBalanceException;
import com.crypto.AllExceptions.TimoutLimitExceededException;
import com.crypto.CoinClasses.Coin;
import com.crypto.TraderClasses.Trader;

/**
 *  Here sell transactions will be executed in process method.
 */

public class Sell extends Transactions {
    private Trader trader;
    private Coin coin;
    private long quantity;

    public Sell(Trader trader, Coin coin, long quantity) {
        this.trader = trader;
        this.coin = coin;
        this.quantity = quantity;
    }

    public synchronized void process() throws InsufficientBalanceException, TimoutLimitExceededException, InterruptedException {

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

        if (MaxCirculatingSupply < quantity) {
            System.out.println("High volume halting trade!");
            return;
        }

        if (trader.getCoinInWallet(coin) < quantity) {
            throw new InsufficientBalanceException("Insufficient balance ");
        }

        coin.setInTransaction(true);
        coin.addCirculatingSupply(quantity);
        hashCode.getBlockHash();
        trader.addProfit(quantity,coin);
        trader.addCoinInWallet(coin,-quantity,coin.getPrice());
        coin.setInTransaction(false);

    }
}

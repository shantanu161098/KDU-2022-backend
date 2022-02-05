package com.crypto.TransactionClasses;

import com.crypto.AllExceptions.AmbiguousTransactionTypeException;
import com.crypto.CoinClasses.Coin;
import com.crypto.App.MemoryLoader;
import com.crypto.TraderClasses.Trader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;


/**
 * (Please note commented code are intentionally given just for showing details)
 * For handling transactions this will be extended by individual buy, sell, update and add volume transactions.
 */
public class Transactions {

    protected long MaxCirculatingSupply = 1008938712;
    Hashcode hashCode = new Hashcode();
    int timeOutOfTransaction = 500;
    int sleepTime = 100;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return MaxCirculatingSupply == that.MaxCirculatingSupply && timeOutOfTransaction == that.timeOutOfTransaction && sleepTime == that.sleepTime && Objects.equals(hashCode, that.hashCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MaxCirculatingSupply, hashCode, timeOutOfTransaction, sleepTime);
    }

    /**
     * It is parsing a json file and making a seperate thread for every transaction
     *
     * @param transactions
     * @param memoryLoader
     */
    public void parseJSON(FileReader transactions, MemoryLoader memoryLoader) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray listOfTransactions = (JSONArray) parser.parse(transactions);

            for (Object o : listOfTransactions) {
                JSONObject singleTransaction = (JSONObject) o;
                Transactions tx = new Transactions();

                JSONObject data = (JSONObject) singleTransaction.get("data");

                if (((String) singleTransaction.get("type")).equals("BUY") || ((String) singleTransaction.get("type")).equals("SELL")) {
                    String walletAddress = (String) data.get("wallet_address");
                    Trader trader = memoryLoader.getTraderByWalletAddress(walletAddress);

                    Runnable threadRunner = new MultiThread(singleTransaction, memoryLoader, trader, true);
                    new Thread(threadRunner).start();
                } else {
                    Trader trader = null;
                    Runnable threadRunner = new MultiThread(singleTransaction, memoryLoader, trader, false);
                    new Thread(threadRunner).start();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * It is processing a single transaction and updating the corresponding values.
     *
     * @param singleTransaction A json transaction object
     * @param memoryLoader      Reference to main memory loader object
     */


    public void transact(JSONObject singleTransaction, MemoryLoader memoryLoader) {
        JSONObject data = (JSONObject) singleTransaction.get("data");
        if (((String) singleTransaction.get("type")).equals("BUY")) {
            String walletAddress = (String) data.get("wallet_address");
            long quantity = (long) data.get("quantity");
            String symbol = (String) data.get("coin");

            try {
                Trader trader = memoryLoader.getTraderByWalletAddress(walletAddress);
                Coin coin = memoryLoader.getCoinBySymbol(symbol);
                Buy buy = new Buy(trader, coin, quantity);
                buy.process();

            } catch (Exception e) {

                System.out.println(e.getMessage() + walletAddress);
            }
        } else if (((String) singleTransaction.get("type")).equals("SELL")) {
            String walletAddress = (String) data.get("wallet_address");
            long quantity = (long) data.get("quantity");
            String symbol = (String) data.get("coin");

            try {
                Trader trader = memoryLoader.getTraderByWalletAddress(walletAddress);
                Coin coin = memoryLoader.getCoinBySymbol(symbol);
                Sell sell = new Sell(trader, coin, quantity);
                sell.process();

            } catch (Exception e) {
                /**
                 * The below method if uncommented will throw insufficient balance exception
                 *  System.out.println(e.getMessage() + walletAddress);
                  */
            }
        } else if (((String) singleTransaction.get("type")).equals("UPDATE_PRICE")) {
            String symbol = (String) data.get("coin");
            double price = (double) data.get("price");

            try {
                Coin coin = memoryLoader.getCoinBySymbol(symbol);
                UpdatePrice updateprice = new UpdatePrice(coin, price);
                updateprice.process();

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        } else if (((String) singleTransaction.get("type")).equals("ADD_VOLUME")) {
            try {
                Coin coin = memoryLoader.getCoinBySymbol((String) data.get("coin"));
                long volume = (long) data.get("volume");
                AddVolume addVolume = new AddVolume(coin, volume);
                addVolume.process();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                throw new AmbiguousTransactionTypeException("unknown type " + (String) singleTransaction.get("type"));
            } catch (AmbiguousTransactionTypeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

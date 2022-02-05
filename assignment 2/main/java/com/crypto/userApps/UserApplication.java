package com.crypto.userApps;

import com.crypto.AllExceptions.TopFiftyNotExistException;
import com.crypto.AllExceptions.ZeroOrMultipleValueException;
import com.crypto.App.MemoryLoader;
import com.crypto.CoinClasses.Coin;
import com.crypto.CoinClasses.CoinPriceComparator;
import com.crypto.TraderClasses.Asset;
import com.crypto.TraderClasses.Trader;
import com.crypto.TraderClasses.TraderProfitComparatorAscending;
import com.crypto.TraderClasses.TraderProfitComparatorDescending;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * This will be running in the main thread which will do the processing of logic
 *
 * Components are -
 * details of a particular coin
 * details of top N coin
 * show portfolio of the trader
 * show top and bottom trader
 */
public class UserApplication {

    private MemoryLoader memoryLoader;

    public UserApplication(MemoryLoader memoryLoader) {
        this.memoryLoader = memoryLoader;
    }

    public void detailsOfAParticularCoin(String nameOrCodeOfTheCoin) {
        List<Coin> coins = memoryLoader.getListOfCoins().parallelStream().filter(c -> c.getName().equals(nameOrCodeOfTheCoin) || c.getSymbol().equals(nameOrCodeOfTheCoin)).collect(Collectors.toList());
        for (Coin c : coins) {
            System.out.println(c.toString());
        }
    }

    public void detailsOfTopNCoin(int NCoinValue) {
        List<Coin> coins = memoryLoader.getListOfCoins();
        Collections.sort(coins, new CoinPriceComparator());

        try {
            if (coins.size() < NCoinValue) {
                throw new TopFiftyNotExistException("Less than 50 coins exist");
            }

            for (int i = 0; i < NCoinValue; i++) {
                System.out.println(coins.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showPortfolioOfTheTrader(String walletAddress) {
        try {
            Trader trader = memoryLoader.getTraderByWalletAddress(walletAddress);
            Map<Coin, Asset> walletContents = trader.getWalletContents();
            if(walletContents.size() == 0){
                System.out.println("Wallet is empty");
                return;
            }
            for (Map.Entry<Coin,Asset> entry : walletContents.entrySet()) {
                System.out.println("Coin " + entry.getKey().getSymbol() + " Quantity " + entry.getValue());
            }

        } catch (ZeroOrMultipleValueException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showProfitOfTheTrader(String walletAddress) {
        try {
            Trader trader = memoryLoader.getTraderByWalletAddress(walletAddress);
            System.out.println(trader.getProfit());
        } catch (ZeroOrMultipleValueException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showTopAndBottomN(int NTradersValue) {
        List<Trader> traders = memoryLoader.getListOfTraders();
        if (traders.size() < NTradersValue) {
            System.out.println("Top and bottom 5 does'nt exist");
        }
        Collections.sort(traders, new TraderProfitComparatorDescending());
        System.out.println("Showing top 5 most profitable traders");
        for (int i = 0; i < NTradersValue; i++) {
            System.out.println(traders.get(i));

        }

        Collections.sort(traders, new TraderProfitComparatorAscending());
        System.out.println("Showing top 5 least profitable traders");
        for (int i = 0; i < NTradersValue; i++) {
            System.out.println(traders.get(i));

        }
    }
}

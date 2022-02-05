package com.crypto.App;

import com.crypto.AllExceptions.ZeroOrMultipleValueException;
import com.crypto.CoinClasses.Coin;
import com.crypto.TraderClasses.Trader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class MemoryLoader {


    /**
     * Load the csv file into main memory
     *
     * @param file
     * @return - list of coins
     */
    private List<Coin> listOfCoins = new ArrayList<Coin>();
    private List<Trader> listOfTraders = new ArrayList<>();

    public void setListOfCoins(List<Coin> listOfCoins) {
        this.listOfCoins = listOfCoins;
    }

    public void setListOfTraders(List<Trader> listOfTraders) {
        this.listOfTraders = listOfTraders;
    }

    @Override
    public String toString() {
        return "MemoryLoader{" +
                "listOfCoins=" + listOfCoins +
                ", listOfTraders=" + listOfTraders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryLoader that = (MemoryLoader) o;
        return Objects.equals(listOfCoins, that.listOfCoins) && Objects.equals(listOfTraders, that.listOfTraders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfCoins, listOfTraders);
    }


    MemoryLoader(FileReader tradersfile, FileReader coinsfile) {
        setListOfTraders(tradersfile);
        setListOfCoins(coinsfile);
    }


    public Trader getTraderByWalletAddress(String walletAddress) throws ZeroOrMultipleValueException {
        List<Trader> trader = listOfTraders.parallelStream().filter(t -> t.getWalletAddress().equals(walletAddress)).collect(Collectors.toList());
        if (trader.size() == 0) {
            throw new ZeroOrMultipleValueException("No such wallet trader exist");
        } else if (trader.size() > 1) {
            throw new ZeroOrMultipleValueException("Multple trader exist");
        } else {
            return trader.get(0);
        }
    }

    public Coin getCoinBySymbol(String symbol) throws ZeroOrMultipleValueException {
        List<Coin> coin = listOfCoins.parallelStream().filter(t -> t.getSymbol().equals(symbol)).collect(Collectors.toList());
        if (coin.size() == 0) {
            throw new ZeroOrMultipleValueException("No such coin exist");
        } else if (coin.size() > 1) {
            throw new ZeroOrMultipleValueException("Multple coin exist");
        } else {
            return coin.get(0);
        }
    }


    public void setListOfCoins(FileReader file) {

        try {
            BufferedReader reader = new BufferedReader(file);

            // for passing the header
            reader.readLine();
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] coinArray = line.split(",");
                try {
                    listOfCoins.add(new Coin(Integer.valueOf(coinArray[1]), coinArray[2], coinArray[3], Double.valueOf(coinArray[4]), Long.valueOf(coinArray[5])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found " + e);
        }
    }

    public List<Coin> getListOfCoins() {
        return listOfCoins;
    }

    public void printListOfCoins() {
        for (Coin coin : listOfCoins) {
            System.out.println(coin.toString());
        }
    }

    public void setListOfTraders(FileReader file) {

        try {
            BufferedReader reader = new BufferedReader(file);

            // for passing the header
            reader.readLine();
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] traderArray = line.split(",");
                try {
                    listOfTraders.add(new Trader(traderArray[1], traderArray[2], traderArray[3], traderArray[4]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found " + e);
        }
    }

    public List<Trader> getListOfTraders() {
        return listOfTraders;
    }

    public void printListOfTraders() {
        for (Trader trader : listOfTraders) {
            System.out.println(trader.toString());
        }
    }
}

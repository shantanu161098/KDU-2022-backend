package com.crypto.TraderClasses;

import com.crypto.CoinClasses.Coin;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Trader implements Comparable<Trader> {
    @NotNull(message="Firstname should be not null")
    private String firstName;
    @NotNull(message=" Lastname should be not null")
    private String lastName;
    @NotNull(message=" phone no should be not null")
    private String phoneNumber;
    @NotNull(message=" wallet address should be not null")
    private String walletAddress;
    private Map<Coin,Asset> walletContents = new HashMap<>();

    private boolean isInTransaction = false;
    /**
     * this is profit due to selling asset ie real profit
     * unrealised profit is calculated at seperate function and added in getProfit method.
     */
    private double profit = 0;


    public boolean isInTransaction() {
        return isInTransaction;
    }

    public void setInTransaction(boolean inTransaction) {
        isInTransaction = inTransaction;
    }

    /**
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param walletAddress
     */
    public Trader(String firstName, String lastName, String phoneNumber, String walletAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.walletAddress = walletAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public Map<Coin, Asset> getWalletContents() {
        return walletContents;
    }

    public void setWalletContents(Map<Coin, Asset> walletContents) {
        this.walletContents = walletContents;
    }

    public void addCoinInWallet(Coin coin, long quantity, double currentPrice) {


        if (walletContents.size() == 0) {
            walletContents.put(coin, new Asset(quantity,quantity*currentPrice));
            return;
        }
        for (Map.Entry<Coin,Asset> entry : walletContents.entrySet()) {

            if (coin.equals(entry.getKey())) {
                Asset currentAsset = entry.getValue();
                currentAsset.updateAsset(quantity,currentPrice);
                walletContents.put(entry.getKey(), currentAsset);
                return;
            }
        }
        walletContents.put(coin, new Asset(quantity,currentPrice));
    }

    public long getCoinInWallet(Coin coin) {
        for (Map.Entry<Coin, Asset> entry : walletContents.entrySet()) {
            if (coin.equals(entry.getKey())) {
                return entry.getValue().getQuantity();
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trader trader = (Trader) o;
        return firstName.equals(trader.firstName) && Objects.equals(lastName, trader.lastName) && Objects.equals(phoneNumber, trader.phoneNumber) && Objects.equals(walletAddress, trader.walletAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, walletAddress);
    }

    @Override
    public String toString() {
        return "Trader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", walletAddress='" + walletAddress + '\'' +
                ", profit = " + (profit + getProfit()) +
                '}';
    }


    public double getProfit() {
        double unrealisedProfit = 0;
        for(Map.Entry<Coin,Asset> e : walletContents.entrySet()){
            unrealisedProfit = unrealisedProfit + e.getKey().getPrice() - e.getValue().getAmount();
        }
        return unrealisedProfit + profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void addProfit(double quantity,Coin coin) {

        for (Map.Entry<Coin,Asset> entry : walletContents.entrySet()) {

            if (coin.getSymbol().equals(entry.getKey().getSymbol())) {

                Asset currentAsset = entry.getValue();

                double averagePrice = currentAsset.getAmount()/currentAsset.getQuantity();
                profit = profit + (coin.getPrice() - averagePrice)*quantity;
            }
        }
    }

    @Override
    public int compareTo(Trader t) {
        return 0;
    }
}

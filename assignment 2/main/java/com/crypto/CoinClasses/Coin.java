package com.crypto.CoinClasses;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Objects;


public class Coin implements Comparable<Coin> {


    @NotNull(message="Rank should be not null")
    private int rank;
    @NotNull(message="Name should be not null")
    private String name;
    @NotNull(message="Symbol should be not null")
    private String symbol;
    @NotNull(message="Price should be not null")
    private double price;
    @NotNull(message="Supply should be not null")
    private long circulatingSupply;

    private boolean isInTransaction = false;

    public boolean isInTransaction() {
        return isInTransaction;
    }

    public void setInTransaction(boolean inTransaction) {
        isInTransaction = inTransaction;
    }

    /**
     * @param rank
     * @param name
     * @param symbol
     * @param price
     * @param circulatingSupply
     */
    public Coin(int rank, String name, String symbol, double price, long circulatingSupply) {
        this.rank = rank;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.circulatingSupply = circulatingSupply;
    }

    public void addCirculatingSupply(long quantity) {
        circulatingSupply = circulatingSupply + quantity;
    }

    public void subtractCirculatingSupply(long quantity) {
        circulatingSupply = circulatingSupply - quantity;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Objects.equals(symbol, coin.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, name, symbol, price, circulatingSupply);
    }

    @Override
    public String toString() {
        return "Coin{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", circulatingSupply=" + circulatingSupply +
                '}';
    }

    public int compareTo(Coin c) {
        return 0;
    }
}

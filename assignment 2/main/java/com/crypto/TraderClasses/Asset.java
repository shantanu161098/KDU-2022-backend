package com.crypto.TraderClasses;

public class Asset {
    private long quantity;
    private double amount;

    public Asset(long quantity, double amount) {
        this.quantity = quantity;
        this.amount = amount;
    }

    /**
     * For buy quantity should be positive and for sell it should be negative.
     * @param quantity
     * @param currentPrice
     */
    public void updateAsset(long quantity, double currentPrice){
        this.quantity = this.quantity + quantity;
        amount = amount + quantity * currentPrice;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

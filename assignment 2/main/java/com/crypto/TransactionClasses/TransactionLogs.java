package com.crypto.TransactionClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TransactionLogs {
    private ArrayList<String> transactionLogs = new ArrayList<>();

    public ArrayList<String> getTransactionLogs() {
        return transactionLogs;
    }

    public void setTransactionLogs(ArrayList<String> transactionLogs) {
        this.transactionLogs = transactionLogs;
    }

    public void addTransaction(String transactionlog){
        System.out.println("Adding transactions");
        transactionLogs.add(transactionlog);
//        System.out.println(transactionlog);
    }


}

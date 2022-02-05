package com.crypto.TransactionClasses;

import com.crypto.App.MemoryLoader;

import java.io.FileReader;

/**
 * This tread seperates main thread with parse thread
 * This will run on different thread while main is displaying the user application.
 */
public class ParserThread implements Runnable {

    private Transactions tx;
    private FileReader file;
    private MemoryLoader memoryLoader;

    public ParserThread(Transactions tx, FileReader file, MemoryLoader memoryLoader) {
        this.tx = tx;
        this.file = file;
        this.memoryLoader = memoryLoader;
    }

    @Override
    public void run() {
        tx.parseJSON(file, memoryLoader);
    }
}

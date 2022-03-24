package com.thread.javaconcurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Indexing implements Runnable {
    private final CountDownLatch latch;

    public Indexing(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.err.println("[" + Thread.currentThread().getName() + "] email is indexing ...");
        try {
            Thread.sleep(100);
            System.err.println("[" + Thread.currentThread().getName() + "] email was indexed.");
            latch.countDown();
            Thread.sleep(100);
            System.err.println("[" + Thread.currentThread().getName() + "] index was finalize.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

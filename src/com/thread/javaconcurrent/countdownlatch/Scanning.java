package com.thread.javaconcurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Scanning implements Runnable {
    private final CountDownLatch latch;

    public Scanning(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.err.println("[" +Thread.currentThread().getName() + "] scanning email ...");
        try {
            Thread.sleep(100);
            System.err.println("[" + Thread.currentThread().getName() + "] scanning is finished.");
            latch.countDown();
            Thread.sleep(100);
            System.err.println("[" + Thread.currentThread().getName() + "] scanning is finalize.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

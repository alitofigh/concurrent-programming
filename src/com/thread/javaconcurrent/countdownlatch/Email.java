package com.thread.javaconcurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Email implements Runnable{
    private final CountDownLatch latch;

    public Email(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.err.println("[" + Thread.currentThread().getName() + "] An email is ready to send.");
        try {
            latch.await();
            // send email ...
            System.err.println("[" + Thread.currentThread().getName() + "] email is sent.");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
